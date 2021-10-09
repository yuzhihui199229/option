package com.huayun.option.controller;


import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.service.TbRoleInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
@RestController
@RequestMapping("/option/tb-role-info")
@Api(tags = "角色信息")
public class TbRoleInfoController {

    @Autowired
    private TbRoleInfoService roleInfoService;

    @PostMapping("/addRole")
    public Result addRole(@RequestBody Map<String, Object> map) {
        return roleInfoService.addRole(map) ? new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage()) : new Result(CodeMessage.ERROR.getCode(), CodeMessage.ERROR.getMessage());
    }
}
