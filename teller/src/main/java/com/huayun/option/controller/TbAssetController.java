package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbAsset;
import com.huayun.option.service.TbAssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

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
    public Result selectByCondition(@RequestBody Map<String, Object> map) {
        QueryWrapper<TbAsset> wrapper = new QueryWrapper<>();
        Optional.ofNullable(map.get("uoptionId")).ifPresent(e -> wrapper.eq("uoption_id", e));
        Optional.ofNullable(map.get("uaccountId")).ifPresent(e -> wrapper.eq("uaccount_id", e));
        Optional.ofNullable(map.get("uposId")).ifPresent(e -> wrapper.eq("upos_id", e));
        Optional.ofNullable(map.get("ustrategyPosId")).ifPresent(e -> wrapper.eq("ustrategy_pos_id", e));
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), assetService.list(wrapper));
    }
}
