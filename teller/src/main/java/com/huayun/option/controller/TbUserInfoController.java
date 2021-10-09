package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbUserInfo;
import com.huayun.option.service.TbUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/option/tb-user-info")
public class TbUserInfoController {

    @Autowired
    private TbUserInfoService userInfoService;

    @PostMapping("queryByCondition")
    @ApiOperation("根据条件查询用户信息")
    public Result queryByCondition(@RequestBody Map<String, Object> map) {
        QueryWrapper<TbUserInfo> wrapper = new QueryWrapper<>();
        Optional.ofNullable(map.get("id")).ifPresent(e -> wrapper.eq("id", e));
        Optional.ofNullable(map.get("userId")).ifPresent(e -> wrapper.eq("user_id", e));
        Optional.ofNullable(map.get("userName")).ifPresent(e -> wrapper.like("user_name", e));
        Optional.ofNullable(map.get("companyId")).ifPresent(e -> wrapper.like("company_id", e));
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), userInfoService.list(wrapper));
    }
}
