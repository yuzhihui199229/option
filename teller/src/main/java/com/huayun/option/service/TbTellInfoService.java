package com.huayun.option.service;

import com.huayun.option.entity.TbPrivilegeInfo;
import com.huayun.option.entity.TbTellInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表(MyISAM) 服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
public interface TbTellInfoService extends IService<TbTellInfo> {
    /**
     * 新增管理员用户
     *
     * @param map userName,password ,roleId
     * @return boolean 是否新增成功
     */
    boolean addUser(Map<String, Object> map);

    /**
     * 修改用户的角色
     *
     * @param userName 用户名
     * @param map      用户的角色List
     * @return boolean 是否修改成功
     */
    boolean updateUserRole(String userName, Map<String, Object> map);
}
