package com.huayun.option.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 组合策略流水表
 * </p>
 *
 * @author yuzh
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbStrategyCombineLog对象", description="组合策略流水表")
public class TbStrategyCombineLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "应用标志")
    private String applId;

    @ApiModelProperty(value = "申报交易单元")
    private String submittingPbuId;

    @ApiModelProperty(value = "证券代码")
    private String securityId;

    @ApiModelProperty(value = "证券代码源")
    private String securityIdSource;

    @ApiModelProperty(value = "订单所有者类型")
    private Integer ownerType;

    @ApiModelProperty(value = "结算机构代码")
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号")
    private String clOrdId;

    @ApiModelProperty(value = "证券账户")
    private String accountId;

    @ApiModelProperty(value = "营业部代码")
    private String branchId;

    @ApiModelProperty(value = "订单限定")
    private String orderRestrictions;

    @ApiModelProperty(value = "买卖方向")
    private String side;

    @ApiModelProperty(value = "订单类别")
    private String ordType;

    @ApiModelProperty(value = "订单数量;实时数量")
    private Long orderQty;

    @ApiModelProperty(value = "冻结数量")
    private Long fronzenQty;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "合约账户标识码")
    private String contractAccountCode;

    @ApiModelProperty(value = "证券类别")
    private String securityType;

    @ApiModelProperty(value = "证券子类别")
    private String securitySubType;

    @ApiModelProperty(value = "策略状态;0=新订单1=构建成功2=构建失败3=完全解除4=完全执行5=已过期")
    private String strategyStatus;

    @ApiModelProperty(value = "交易所订单编号")
    private String orderId;

    @ApiModelProperty(value = "策略应收取保证金")
    private Double strategyMargin;

    @ApiModelProperty(value = "增加的净权利金")
    private Double payoffPremium;

    @ApiModelProperty(value = "期权1合约代码")
    private String legSecurityId1;

    @ApiModelProperty(value = "期权1合约代码源")
    private String legSecurityIdSource1;

    @ApiModelProperty(value = "期权1成分合约方向")
    private String legSide1;

    @ApiModelProperty(value = "期权1成份合约数量")
    private Long legOrderQty1;

    @ApiModelProperty(value = "期权1行权价格")
    private Long execPrice1;

    @ApiModelProperty(value = "期权1开仓保证金")
    private Double legOpenMargin1;

    @ApiModelProperty(value = "期权1维持保证金")
    private Double legMaintainMargin1;

    @ApiModelProperty(value = "期权2合约代码")
    private String legSecurityId2;

    @ApiModelProperty(value = "期权2合约代码源")
    private String legSecurityIdSource2;

    @ApiModelProperty(value = "期权2成分合约方向")
    private String legSide2;

    @ApiModelProperty(value = "期权2成份合约数量")
    private Long legOrderQty2;

    @ApiModelProperty(value = "期权2行权价格")
    private Long execPrice2;

    @ApiModelProperty(value = "期权2开仓保证金")
    private Double legOpenMargin2;

    @ApiModelProperty(value = "期权2维持保证金")
    private Double legMaintainMargin2;

    @ApiModelProperty(value = "期权3合约代码")
    private String legSecurityId3;

    @ApiModelProperty(value = "期权3合约代码源")
    private String legSecurityIdSource3;

    @ApiModelProperty(value = "期权3成分合约方向")
    private String legSide3;

    @ApiModelProperty(value = "期权3成份合约数量")
    private Long legOrderQty3;

    @ApiModelProperty(value = "期权3行权价格")
    private Long execPrice3;

    @ApiModelProperty(value = "期权3开仓保证金")
    private Double legOpenMargin3;

    @ApiModelProperty(value = "期权3维持保证金")
    private Double legMaintainMargin3;

    @ApiModelProperty(value = "期权4合约代码")
    private String legSecurityId4;

    @ApiModelProperty(value = "期权4合约代码源")
    private String legSecurityIdSource4;

    @ApiModelProperty(value = "期权4成分合约方向")
    private String legSide4;

    @ApiModelProperty(value = "期权4成份合约数量")
    private Long legOrderQty4;

    @ApiModelProperty(value = "期权4行权价格")
    private Long execPrice4;

    @ApiModelProperty(value = "期权4开仓保证金")
    private Double legOpenMargin4;

    @ApiModelProperty(value = "期权4维持保证金")
    private Double legMaintainMargin4;

    @ApiModelProperty(value = "已解除数量")
    private Long reliefOrderQty;

    @ApiModelProperty(value = "已执行数量")
    private Long execOrderQty;

    @ApiModelProperty(value = "组合策略创建时间")
    private Long createTime;

    @ApiModelProperty(value = "策略版本号")
    private Integer strategyVersion;


}
