package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbRoleInfo;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.service.TbRoleInfoService;
import com.huayun.option.service.TbTellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 * 管理员表(MyISAM) 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/tellInfo")
public class TbTellInfoController {
    @Autowired
    private TbTellInfoService tellInfoService;

    @Autowired
    private TbRoleInfoService roleInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody TbTellInfo tellInfo) {
        //包装login的查询条件
        LambdaQueryWrapper<TbTellInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TbTellInfo::getUserName, tellInfo.getUserName())
                .eq(TbTellInfo::getPassword,DigestUtils.md5DigestAsHex(tellInfo.getPassword().getBytes()) );
        //查询该用户是否存在
        TbTellInfo one = tellInfoService.getOne(wrapper);
        if (one != null) {
            //查询用户的角色
            List<TbRoleInfo> roleList = roleInfoService.getRoleList(one);
            return new Result(0, "登录成功");
        }
        return new Result(1, "登录失败");
    }
}
