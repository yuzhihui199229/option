package com.huayun.option.controller;


import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.service.TbPrivilegeInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
@RestController
@RequestMapping("/option/tb-privilege-info")
@Api(tags = "权限管理")
public class TbPrivilegeInfoController {

    @Autowired
    private TbPrivilegeInfoService privilegeInfoService;

    @GetMapping("/queryByCondition/{id}")
    public Result queryByCondition(@PathVariable("id") Integer id) {
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), privilegeInfoService.queryByCondition(id));
    }
}
