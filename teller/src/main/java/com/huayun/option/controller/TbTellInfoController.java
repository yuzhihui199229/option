package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbRoleInfo;
import com.huayun.option.entity.TbTellInfo;
import com.huayun.option.service.TbRoleInfoService;
import com.huayun.option.service.TbTellInfoService;
import com.huayun.option.utils.JwtUtil;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
                .eq(TbTellInfo::getPassword, DigestUtils.md5DigestAsHex(tellInfo.getPassword().getBytes()));
        //查询该用户是否存在
        TbTellInfo tellInfoRsp = tellInfoService.getOne(wrapper);
        if (tellInfoRsp != null) {
            //查询用户的角色
            List<TbRoleInfo> roleList = roleInfoService.getRoleList(tellInfoRsp);
            //生成角色的字符串组
            StringBuilder sb = new StringBuilder();
            for (TbRoleInfo tbRoleInfo : roleList) {
                sb.append(tbRoleInfo.getRoleId());
            }
            String roleStr = sb.toString();
            //生成token
            String token = JwtUtil.sign(tellInfoRsp.getUserName());
            //创建保存信息的map
            Map<String, Object> map = new HashMap<>();
            map.put("token",token);
            return new Result(0, "登录成功",map);
        }
        return new Result(1, "登录失败");
    }

    @GetMapping("/selectList")
    public Result selectList() {
        List<TbTellInfo> list = tellInfoService.list();
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(),list);
    }
}
