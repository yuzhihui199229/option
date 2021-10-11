package com.huayun.option.controller;


import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.service.TbRoleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @ApiOperation("新增角色")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody Map<String, Object> map) {
        return roleInfoService.addRole(map) ? new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage()) : new Result(CodeMessage.ERROR.getCode(), CodeMessage.ERROR.getMessage());
    }

    @GetMapping("/queryByCondition/{userName}")
    public Result queryByCondition(@PathVariable("userName") String userName) {
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), roleInfoService.queryByCondition(userName));
    }

    @ApiOperation("修改角色的权限")
    @PostMapping("/updateRolePrivilege/{rid}")
    public Result updateRolePrivilege(@PathVariable("rid") Integer rid, @RequestBody Map<String, Object> map) {
        return roleInfoService.updateRolePrivilege(rid, (List<Integer>) map.get("pids")) ? new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage()) : new Result(CodeMessage.ERROR.getCode(), CodeMessage.ERROR.getMessage());
    }
}
