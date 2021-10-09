package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.option.entity.*;
import com.huayun.option.service.TbPrivilegeInfoService;
import com.huayun.option.service.TbRoleInfoService;
import com.huayun.option.service.TbTellInfoService;
import com.huayun.option.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表(MyISAM) 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/option/tellInfo")
@Api(tags = "柜员管理员信息")
public class TbTellInfoController {
    @Autowired
    private TbTellInfoService tellInfoService;

    @Autowired
    private TbRoleInfoService roleInfoService;

    @Autowired
    private TbPrivilegeInfoService privilegeInfoService;

    @GetMapping("/login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public Result login(String userName, String password) {
        //包装login的查询条件
        LambdaQueryWrapper<TbTellInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TbTellInfo::getUserName, userName)
                .eq(TbTellInfo::getPassword, DigestUtils.md5DigestAsHex(password.getBytes()));
        //查询该用户是否存在
        TbTellInfo tellInfoRsp = tellInfoService.getOne(wrapper);
        if (tellInfoRsp != null) {
            //查询用户的所有权限
            List<TbRoleInfo> roleList = roleInfoService.getRoleList(tellInfoRsp);
            List<TbPrivilegeInfo> privilegeInfos = privilegeInfoService.getPrivilege(roleList, null);
            //生成token
            String token = JwtUtil.sign(tellInfoRsp.getUserName());
            //创建保存信息的map
            Map<String, Object> map = new HashMap<>(16);
            map.put("token", token);
            map.put("menus", privilegeInfos);
            return new Result(0, "登录成功", map);
        }
        return new Result(1, "登录失败");
    }

    @GetMapping("/selectList")
    public Result selectList() {
        List<TbTellInfo> list = tellInfoService.list();
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), list);
    }

    @PostMapping("/addUser")
    @ApiOperation("新增管理员用户")
    public Result addUser(@RequestBody Map<String, Object> map) {
        return tellInfoService.addUser(map) ? new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage()) : new Result(CodeMessage.ERROR.getCode(), CodeMessage.ERROR.getMessage());
    }
}
