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
    /**
     * 根据用户查询菜单的信息
     *
     * @param roleInfos
     * @param preMenuId
     * @return
     */
    List<TbPrivilegeInfo> getPrivilege(@Param("list") List<TbRoleInfo> roleInfos, @Param("preMenuId") String preMenuId);

    /**
     * 根据角色id查询用户的权限
     *
     * @param id 角色id
     * @return
     */
    List<TbPrivilegeInfo> queryByCondition(Integer id);
}
