package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbAssetInfo;
import com.huayun.option.service.TbAssetInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资金信息表(MyISAM) 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/option/tb-asset-info")
@Api(tags = "资金信息管理")
public class TbAssetInfoController {
    @Autowired
    private TbAssetInfoService assetInfoService;

    @GetMapping("/selectByCondition")
    @ApiOperation("根据条件查询资金信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetAccount", value = "保证金账户"),
            @ApiImplicitParam(name = "uuserId", value = "用户ID")
    })
    public Result selectByCondition(String assetAccount,Integer uuserId) {
        LambdaQueryWrapper<TbAssetInfo> wrapper=new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(assetAccount))
            wrapper.eq(TbAssetInfo::getAssetAccount,assetAccount);
        if (uuserId!=null)
            wrapper.eq(TbAssetInfo::getUuserId,uuserId);
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), assetInfoService.list(wrapper));
    }
}
