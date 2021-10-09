package com.huayun.option.mapper;

import com.huayun.option.entity.TbTellRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzh
 * @since 2021-10-09
 */
public interface TbTellRoleMapper extends BaseMapper<TbTellRole> {
    /**
     * 批量插入tb_tell_role数据
     * @param rids
     * @param tid
     * @return
     */
    int insertBatch(@Param("list") List<Integer> rids, @Param("tid") Integer tid);
}
