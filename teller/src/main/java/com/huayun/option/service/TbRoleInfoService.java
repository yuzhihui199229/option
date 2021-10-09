package com.huayun.option.service;

import com.huayun.option.entity.TbRoleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbUserInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
public interface TbRoleInfoService extends IService<TbRoleInfo> {
    /**
     * 获取角色信息列表
     * @param tbTellInfo 角色信息
     * @return List<TbRoleInfo> 返回角色信息列表
     */
    List<TbRoleInfo> getRoleList(TbTellInfo tbTellInfo);

    /**
     * 添加角色
     * @param map 角色的输入参数，roleId，roleName,menuId
     * @return 是否添加角色成功
     */
    boolean addRole(Map<String, Object> map);
}
