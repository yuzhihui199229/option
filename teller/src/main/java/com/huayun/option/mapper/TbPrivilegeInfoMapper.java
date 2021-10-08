package com.huayun.option.mapper;

import com.huayun.option.entity.TbPrivilegeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayun.option.entity.TbRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
public interface TbPrivilegeInfoMapper extends BaseMapper<TbPrivilegeInfo> {
    List<TbPrivilegeInfo> getPrivilege(@Param("list") List<TbRoleInfo> roleInfos, @Param("preMenuId") String preMenuId);
}
