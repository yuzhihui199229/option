package com.huayun.option.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.TbRoleInfo;
import com.huayun.option.entity.TbRolePrivilege;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbUserInfo;
import com.huayun.option.mapper.TbRoleInfoMapper;
import com.huayun.option.mapper.TbRolePrivilegeMapper;
import com.huayun.option.service.TbRoleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
@Service
public class TbRoleInfoServiceImpl extends ServiceImpl<TbRoleInfoMapper, TbRoleInfo> implements TbRoleInfoService {

    @Autowired
    private TbRoleInfoMapper roleInfoMapper;

    @Autowired
    private TbRolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public List<TbRoleInfo> getRoleList(TbTellInfo tellInfo) {
        return roleInfoMapper.getRoleList(tellInfo);
    }

    @Override
    @Transactional
    public boolean addRole(Map<String, Object> map) {
        TbRoleInfo roleInfo = new TbRoleInfo();
        Object roleId = map.get("roleId");
        Optional.of(roleId).ifPresent(e -> roleInfo.setRoleId(Integer.parseInt((String) e)));
        Optional.of(map.get("roleName")).ifPresent(e -> roleInfo.setRoleName(((String) e)));
        int addCount = roleInfoMapper.insert(roleInfo);
        if (addCount > 0) {
            QueryWrapper<TbRoleInfo> wrapper = new QueryWrapper<>();
            wrapper.select("id").eq("role_id", roleId);
            TbRoleInfo roleInfoAdd = roleInfoMapper.selectOne(wrapper);
            List<Integer> pids = (List<Integer>) map.get("pid");
            int rolePrivilegeCount = rolePrivilegeMapper.insertBatch(pids, roleInfoAdd.getId());
            return rolePrivilegeCount == pids.size();
        }
        return false;
    }

    @Override
    public List<TbRoleInfo> queryByCondition(String userName) {
        return roleInfoMapper.queryByCondition(userName);
    }

    @Override
    @Transactional
    public boolean updateRolePrivilege(int rid, List<Integer> pids) {
        //删除该角色原有的权限
        QueryWrapper<TbRolePrivilege> wrapper=new QueryWrapper<>();
        wrapper.eq("rid",rid);
        rolePrivilegeMapper.delete(wrapper);
        //添加新的权限
        int rolePrivilegeCount = rolePrivilegeMapper.insertBatch(pids, rid);
        return pids.size() == rolePrivilegeCount;
    }
}
