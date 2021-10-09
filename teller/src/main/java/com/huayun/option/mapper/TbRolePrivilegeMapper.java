package com.huayun.option.mapper;

import com.huayun.option.entity.TbRolePrivilege;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-10-09
 */
public interface TbRolePrivilegeMapper extends BaseMapper<TbRolePrivilege> {
    /**
     * 批量插入角色权限关系
     *
     * @param pids
     * @param rid
     * @return
     */
    int insertBatch(@Param("list") List<Integer> pids, @Param("rid") Integer rid);
}
