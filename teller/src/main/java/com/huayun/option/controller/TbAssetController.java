package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbAsset;
import com.huayun.option.entity.TbAssetInfo;
import com.huayun.option.service.TbAssetInfoService;
import com.huayun.option.service.TbAssetService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资金流水表 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/option/tb-asset")
@Api(tags = "资金流水")
public class TbAssetController {
    @Autowired
    private TbAssetService assetService;

    @GetMapping("/selectByCondition")
    @ApiOperation("根据条件查询资金流水")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetAccount", value = "保证金账户"),
    })
    public Result selectByCondition(String assetAccount) {
        LambdaQueryWrapper<TbAsset> wrapper=new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(assetAccount)) {
            wrapper.eq(TbAsset::getUaccountId, assetAccount);
        }
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), assetService.list(wrapper));
    }
}
