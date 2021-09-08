package com.huayun.option.controller;


import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbOptionInfo;
import com.huayun.option.service.TbOptionInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 期权信息表(MyISAM) 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/optionInfo")
@Api(tags = "期权信息")
@CrossOrigin
public class TbOptionInfoController {

    @Autowired
    private TbOptionInfoService optionInfoService;

    @GetMapping("/selectList")
    public Result selectList() {
        List<TbOptionInfo> optionInfos = optionInfoService.list();
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(),optionInfos);
    }
}
