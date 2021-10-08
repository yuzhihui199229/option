package com.huayun.option.service;

import com.huayun.option.entity.TbPrivilegeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayun.option.entity.TbRoleInfo;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
public interface TbPrivilegeInfoService extends IService<TbPrivilegeInfo> {

    /**
     * 通过角色查询该角色所有的权限
     * @param roleInfos 角色集合
     * @param preMenuId
     * @return List<TbPrivilegeInfo> 返回权限列表
     */
    List<TbPrivilegeInfo> getPrivilege(List<TbRoleInfo> roleInfos, String preMenuId);
}
