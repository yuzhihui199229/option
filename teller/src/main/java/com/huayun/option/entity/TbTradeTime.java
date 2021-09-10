package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易时间表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbTradeTime对象", description="交易时间表(MyISAM)")
public class TbTradeTime implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "交易时间组号")
    private Integer tradeTimeGroup;

    @ApiModelProperty(value = "开始时间")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间")
    private Integer stopTime;

    @ApiModelProperty(value = "交易时间类型;0连续竞价(Normal),  1开盘集合竞价(Open) , 2收盘集合竞价(Close) , 3盘中临时停牌复牌集合竞价(Temp)")
    private Integer timeType;

    @ApiModelProperty(value = "交易类型;0正常可交易可取消(Normal)， 1不可交易(NONTRADABLE), 2不可取消(NONCANCELLABLE)")
    private Integer tradeType;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


}
