package com.huayun.option.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayun.option.entity.TbPrivilegeInfo;
import com.huayun.option.entity.TbRoleInfo;
import com.huayun.option.mapper.TbPrivilegeInfoMapper;
import com.huayun.option.service.TbPrivilegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class TbPrivilegeInfoServiceImpl extends ServiceImpl<TbPrivilegeInfoMapper, TbPrivilegeInfo> implements TbPrivilegeInfoService {

    @Autowired
    private TbPrivilegeInfoMapper privilegeInfoMapper;

    @Override
    public List<TbPrivilegeInfo> getPrivilege(List<TbRoleInfo> roleInfos, String preMenuId) {
        String preMenuIdDynamic = preMenuId != null ? preMenuId : "";
        List<TbPrivilegeInfo> privilegeInfos = privilegeInfoMapper.getPrivilege(roleInfos, preMenuIdDynamic);
        if (privilegeInfos.size() > 0) {
            for (TbPrivilegeInfo privilegeInfo : privilegeInfos) {
                String menuId = privilegeInfo.getMenuId();
                privilegeInfo.setChildMenu(getPrivilege(roleInfos,menuId));
            }
        }
        return privilegeInfos;
    }

    @Override
    public List<TbPrivilegeInfo> queryByCondition(Integer id) {
        return privilegeInfoMapper.queryByCondition(id);
    }
}
