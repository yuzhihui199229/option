package com.huayun.option.service;

import com.huayun.option.entity.TbRoleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbUserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
public interface TbRoleInfoService extends IService<TbRoleInfo> {
    List<TbRoleInfo> getRoleList(TbTellInfo tbTellInfo);
}
