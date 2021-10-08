package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbPositionLimit;
import com.huayun.option.service.TbPositionLimitService;
import io.swagger.annotations.*;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 持仓限额配置表 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/option/positionLimit")
@Api(tags = "持仓限额配置")
public class TbPositionLimitController {

    @Autowired
    private TbPositionLimitService positionLimitService;

    @GetMapping("/selectByCondition")
    @ApiOperation("根据标的物ID和股东账户ID查询持仓限额配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usecurityId", value = "标的物ID"),
            @ApiImplicitParam(name = "uaccountId", value = "股东账户ID")
    })
    public Result selectByCondition(Integer usecurityId, Integer uaccountId) {
        LambdaQueryWrapper<TbPositionLimit> wrapper = new LambdaQueryWrapper<>();
        if (usecurityId != null) {
            wrapper.eq(TbPositionLimit::getUsecurityId, usecurityId);
        }
        if (uaccountId != null) {
            wrapper.eq(TbPositionLimit::getUaccountId, uaccountId);
        }
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), positionLimitService.list(wrapper));
    }
}
