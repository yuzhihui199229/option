package com.huayun.option.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.TellerApplication;
import com.huayun.option.entity.TbPrivilegeInfo;
import com.huayun.option.entity.TbRolePrivilege;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbTellRole;
import com.huayun.option.mapper.TbTellInfoMapper;
import com.huayun.option.mapper.TbTellRoleMapper;
import com.huayun.option.service.TbTellInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.DigestUtils;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 管理员表(MyISAM) 服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Service
public class TbTellInfoServiceImpl extends ServiceImpl<TbTellInfoMapper, TbTellInfo> implements TbTellInfoService {

    @Autowired
    private TbTellInfoMapper tellInfoMapper;

    @Autowired
    private TbTellRoleMapper tellRoleMapper;

    @Override
    @Transactional
    public boolean addUser(Map<String, Object> map) {
        //插入tb_tell_info
        TbTellInfo tellInfo = new TbTellInfo();
        Object userName = map.get("userName");
        Optional.of(userName).ifPresent(e -> tellInfo.setUserName((String) e));
        Optional.of(map.get("password")).ifPresent(e -> tellInfo.setPassword(DigestUtils.md5DigestAsHex(((String) e).getBytes())));
        tellInfo.setUserStatus(0);
        int add = tellInfoMapper.insert(tellInfo);
        if (add > 0) {
            //批量插入tb_tell_role
            QueryWrapper<TbTellInfo> wrapper = new QueryWrapper<>();
            wrapper.select("id").eq("user_name", userName);
            TbTellInfo tellInfoAdd = tellInfoMapper.selectOne(wrapper);
            List<Integer> rids = (List<Integer>) map.get("rid");
            int insertBatchCount = tellRoleMapper.insertBatch(rids, tellInfoAdd.getId());
            return insertBatchCount == rids.size();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateUserRole(String userName, Map<String, Object> map) {
        //用户名对应的id
        QueryWrapper<TbTellInfo> tellInfoQueryWrapper = new QueryWrapper<>();
        tellInfoQueryWrapper.select("id").eq("user_name", userName);
        TbTellInfo tellInfo = tellInfoMapper.selectOne(tellInfoQueryWrapper);
        //删除该用户的所有角色
        QueryWrapper<TbTellRole> tellRoleWrapper = new QueryWrapper<>();
        tellRoleWrapper.eq("tid", tellInfo.getId());
        tellRoleMapper.delete(tellRoleWrapper);
        //添加该用户的新角色
        List<Integer> rids = (List<Integer>) map.get("rids");
        int insertBatch = tellRoleMapper.insertBatch(rids, tellInfo.getId());
        return rids.size() == insertBatch;
    }
}
