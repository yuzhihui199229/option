package com.huayun.option.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ReqCombinedStrategy",description = "组合策略构建申报请求")
public class ReqCombinedStrategy {
    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "消息类型")
    private Integer msgType;

    @ApiModelProperty(value = "消息长度:包长度-消息头-消息尾")
    private Integer bodyLength;

    @ApiModelProperty(value = "消息类型",dataType = "char[3]")
    private String applID;

    @ApiModelProperty(value = "申报交易单元",dataType = "char[6]")
    private String submittingPBUID;

    @ApiModelProperty(value = "证券代码",dataType = "char[8]")
    private String securityID;

    @ApiModelProperty(value = "证券代码源",dataType = "char[4]")
    private String securityIDSource;

    @ApiModelProperty(value = "订单所有者类型")
    private Short ownerType;

    @ApiModelProperty(value = "结算机构代码",dataType = "char[2]")
    private String clearingFirm;

    @ApiModelProperty(value = "委托时间:YYYYMMDDHHMMSSsss")
    private Long transactTime;

    @ApiModelProperty(value = "用户私有信息",dataType = "char[8]")
    private String userInfo;

    @ApiModelProperty(value = "客户订单编号:不填",dataType = "char[10]")
    private String ClOrdID;

    @ApiModelProperty(value = "证券账户",dataType = "char[12]")
    private String accountID;

    @ApiModelProperty(value = "营业部代码",dataType = "char[4]")
    private String branchID;

    @ApiModelProperty(value = "订单限定",dataType = "char")
    private String orderRestrictions;

    @ApiModelProperty(value = "买卖方向",dataType = "char")
    private String side;

    @ApiModelProperty(value = "订单类别",dataType = "char")
    private String ordType;

    @ApiModelProperty(value = "订单数量")
    private Long orderQty;

    @ApiModelProperty(value = "价格")
    private Long price;

    @ApiModelProperty(value = "合约账户标识码",dataType = "char[6]")
    private String contractAccountCode;

    @ApiModelProperty(value = "第二交易所订单编号",dataType = "char[16]")
    private String secondaryOrderID;

    @ApiModelProperty(value = "证券类别",dataType = "char[8]")
    private String securityType;

    @ApiModelProperty(value = "证券子类别",dataType = "char[8]")
    private String securitySubType;

    @ApiModelProperty(value = "成份合约个数")
    private Integer noLegs;

    @ApiModelProperty(value = "校验和")
    private Integer checkSum;

    @ApiModelProperty(value = "申报交易单元整型编号")
    private Short pbuID;

    @ApiModelProperty(value = "证券账户整型编号")
    private Integer accID;

    @ApiModelProperty(value = "成份合约证券代码整型编号")
    private Integer secID;

    @ApiModelProperty(value = "成份合约证券代码整型编号")
    private Integer posID;
}
