package com.huayun.option.mapper;

import com.huayun.option.entity.TbRoleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.entity.TbUserInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
public interface TbRoleInfoMapper extends BaseMapper<TbRoleInfo> {
    /**
     * 根据用户查询到相关的角色
     * @param tellInfo
     * @return
     */
    List<TbRoleInfo> getRoleList(TbTellInfo tellInfo);
}
