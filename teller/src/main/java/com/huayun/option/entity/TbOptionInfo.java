package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 期权信息表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbOptionInfo对象", description="期权信息表(MyISAM)")
public class TbOptionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    private Integer id;

    @ApiModelProperty(value = "合约简称")
    private String contractName;

    @ApiModelProperty(value = "合约代码")
    private String contractCode;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccountCode;

    @ApiModelProperty(value = "合约编码")
    private String optionId;

    @ApiModelProperty(value = "证券代码源")
    private String optionIdSource;

    @ApiModelProperty(value = "标的资产")
    private Integer usecurityId;

    @ApiModelProperty(value = "合约类型;认沽、认购")
    private Integer contractType;

    @ApiModelProperty(value = "合约单位;单张合约对应合约标的的数量")
    private Integer contractUnit;

    @ApiModelProperty(value = "到期月份;第四个周三、第三个周五")
    private Integer expirateMonth;

    @ApiModelProperty(value = "行权价格;x10000")
    private Long strikePrice;

    @ApiModelProperty(value = "行权价格间距;x10000")
    private Long strikePriceStep;

    @ApiModelProperty(value = "行权方式;欧式、美式")
    private Integer exerciseMethod;

    @ApiModelProperty(value = "交割方式;实物，现金")
    private Integer deliverMethod;

    @ApiModelProperty(value = "最小变动单位;股票为0.001元，开放式基金为0.0001元,，标识的是位数")
    private Integer minChangeUnit;

    @ApiModelProperty(value = "期权状态;0：正常，1：冻结")
    private Integer optionStatus;

    @ApiModelProperty(value = "前收盘价;x10000")
    private Long prevClosePrice;

    @ApiModelProperty(value = "线性浮动比例;x10000")
    private Integer floatRatio;

    @ApiModelProperty(value = "认购非线性比例参数1;x10000")
    private Integer firstRatioCall;

    @ApiModelProperty(value = "认购非线性比例参数2;x10000")
    private Integer secondRatioCall;

    @ApiModelProperty(value = "认沽非线性比例参数1;x10000")
    private Integer firstRatioPut;

    @ApiModelProperty(value = "认沽维持保证金参数2;x10000")
    private Integer secondRatioPut;

    @ApiModelProperty(value = "限价买入上限")
    private Long buyQtyUpperLimit;

    @ApiModelProperty(value = "限价卖出上限")
    private Long sellQtyUpperLimit;

    @ApiModelProperty(value = "市价买入上限")
    private Long marketBuyQtyUpLimit;

    @ApiModelProperty(value = "市价卖出上限")
    private Long marketSellQtyUpLimit;

    @ApiModelProperty(value = "买数量单位")
    private Integer buyQtyUnit;

    @ApiModelProperty(value = "卖数量单位")
    private Integer sellQtyUnit;

    @ApiModelProperty(value = "价格档次")
    private Integer priceTick;

    @ApiModelProperty(value = "涨价限制值")
    private Integer upperLimitPrice;

    @ApiModelProperty(value = "跌价限制值")
    private Integer lowLimitPrice;

    @ApiModelProperty(value = "昨卖开每张保证金;x10000")
    private Long lastSellMargin;

    @ApiModelProperty(value = "今卖开每张保证金;x10000")
    private Long sellMargin;

    @ApiModelProperty(value = "做市商标识;Y=是，N=否")
    private Integer marketMakeFlag;

    @ApiModelProperty(value = "手续费")
    private Integer feeRate;

    @ApiModelProperty(value = "交易时间组")
    private Integer tradeTimeGroup;

    @ApiModelProperty(value = "用户日买入上限")
    private Integer cumBuyUpper;


}
