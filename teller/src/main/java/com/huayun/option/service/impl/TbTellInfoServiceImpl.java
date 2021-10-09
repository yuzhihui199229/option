package com.huayun.option.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.TellerApplication;
import com.huayun.option.entity.TbPrivilegeInfo;
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
        TbTellInfo tellInfo = new TbTellInfo();
        Object userName = map.get("userName");
        Optional.of(userName).ifPresent(e -> tellInfo.setUserName((String) e));
        Optional.of(map.get("password")).ifPresent(e -> tellInfo.setPassword((String) e));
        int add = tellInfoMapper.insert(tellInfo);
        QueryWrapper<TbTellInfo> wrapper = new QueryWrapper<>();
        if (add > 0) {
            wrapper.select("id").eq("user_name", userName);
            TbTellInfo tellInfoAdd = tellInfoMapper.selectOne(wrapper);
            TbTellRole tellRole = new TbTellRole();
            Optional.ofNullable(map.get("roleId")).ifPresent(e -> tellRole.setRid((int) e));
            tellRole.setTid(tellInfoAdd.getId());
            return tellRoleMapper.insert(tellRole) > 0;
        }
        return false;
    }
}
