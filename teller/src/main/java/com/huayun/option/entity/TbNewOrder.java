package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表(MyISAM)
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbNewOrder对象", description="订单表(MyISAM)")
public class TbNewOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "应用标识")
    private String applId;

    @ApiModelProperty(value = "申报交易单元")
    private String submittingPbuid;

    @ApiModelProperty(value = "期权代码")
    private String securityId;

    @ApiModelProperty(value = "期权代码源;102=深圳证券交易所")
    private String securityIdSource;

    @ApiModelProperty(value = "订单所有者类型")
    private Integer ownerType;

    @ApiModelProperty(value = "结算机构代码")
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户信息")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号")
    private String clOrderId;

    @ApiModelProperty(value = "证券账户")
    private String accountId;

    @ApiModelProperty(value = "营业部代码")
    private String branchId;

    @ApiModelProperty(value = "订单限定")
    private String orderRestrictions;

    @ApiModelProperty(value = "买卖方向")
    private Integer side;

    @ApiModelProperty(value = "订单类别;1 表示市价 2 表示限价 U 本方最优")
    private Integer ordType;

    @ApiModelProperty(value = "订单数量")
    private Long orderQty;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "止损价(扩展)")
    private Long stopPx;

    @ApiModelProperty(value = "最低成交数量")
    private Long minQty;

    @ApiModelProperty(value = "最多成交位数")
    private Integer maxPriceLevel;

    @ApiModelProperty(value = "订单有效时间类型")
    private Integer timeInForce;

    @ApiModelProperty(value = "平仓标识;O开仓 ,C平仓")
    private Integer positionEffect;

    @ApiModelProperty(value = "备兑标签;0表示备兑，1表示非备兑")
    private Integer coveredOrUncoverd;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccountCode;

    @ApiModelProperty(value = "订单事务ID")
    private Integer txId;

    @ApiModelProperty(value = "订单状态;0:新订单 1部分成交 2完全成交 4已撤销 8已拒绝 5已确认新订单 3对敲 6超频 7发送失败")
    private Integer orderStatus;

    @ApiModelProperty(value = "原始订单数量;已乘以100")
    private Long originOrdQty;

    @ApiModelProperty(value = "原始冻结手续费")
    private Double originFee;

    @ApiModelProperty(value = "最终扣除手续费")
    private Double finalFee;

    @ApiModelProperty(value = "累计成交金额")
    private Double cumExec;

    @ApiModelProperty(value = "客户端序列号")
    private Integer seq;

    @ApiModelProperty(value = "原始冻结价格;无涨跌幅限制的订单在下单时的冻结价格，与有涨跌幅限制的价格不同。这里记录了下单时的原始冻结价格")
    private Long origFrozenPrice;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "期权持仓ID")
    private Integer uposId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "申报交易单元ID")
    private Integer upbuId;


}
