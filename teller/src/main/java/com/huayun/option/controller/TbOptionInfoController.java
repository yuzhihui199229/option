package com.huayun.option.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayun.option.entity.CodeMessage;
import com.huayun.option.entity.Result;
import com.huayun.option.entity.TbOptionInfo;
import com.huayun.option.service.TbOptionInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 期权信息表(MyISAM) 前端控制器
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/option/optionInfo")
@Api(tags = "期权信息")
@CrossOrigin
public class TbOptionInfoController {

    @Autowired
    private TbOptionInfoService optionInfoService;

    @GetMapping("/selectList")
    public Result selectList(@RequestBody Map<String, Object> map) {
        QueryWrapper<TbOptionInfo> wrapper = new QueryWrapper<>();
        Optional.ofNullable(map.get("contractName")).ifPresent(e -> wrapper.like("contract_name", e));
        Optional.ofNullable(map.get("contractCode")).ifPresent(e -> wrapper.eq("contract_code", e));
        Optional.ofNullable(map.get("contractAccountCode")).ifPresent(e -> wrapper.eq("contract_account_code", e));
        Optional.ofNullable(map.get("optionId")).ifPresent(e -> wrapper.eq("option_id", e));
        return new Result(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage(), optionInfoService.list(wrapper));
    }
}
