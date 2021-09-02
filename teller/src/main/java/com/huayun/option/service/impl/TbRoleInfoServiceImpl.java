package com.huayun.option.service.impl;

import com.huayun.option.entity.TbRoleInfo;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbUserInfo;
import com.huayun.option.mapper.TbRoleInfoMapper;
import com.huayun.option.service.TbRoleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
@Service
public class TbRoleInfoServiceImpl extends ServiceImpl<TbRoleInfoMapper, TbRoleInfo> implements TbRoleInfoService {

    @Autowired
    private TbRoleInfoMapper roleInfoMapper;

    /**
     * 根据用户查询到相关的角色
     * @param tellInfo
     * @return
     */
    @Override
    public List<TbRoleInfo> getRoleList(TbTellInfo tellInfo) {
        return roleInfoMapper.getRoleList(tellInfo);
    }
}
