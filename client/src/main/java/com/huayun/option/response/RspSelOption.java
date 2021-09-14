package com.huayun.option.response;

import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "RspSelOption", description = "期权持仓查询接口出参")
public class RspSelOption extends BaseResponse<RspSelOption> {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "权利仓")
    private Long rightsQty;

    @ApiModelProperty(value = "义务仓")
    private Long obligQty;

    @ApiModelProperty(value = "备兑持仓")
    private Long coverQty;

    @ApiModelProperty(value = "权利冻结仓")
    private Long rightsFrozenQty;

    @ApiModelProperty(value = "义务冻结仓")
    private Long obligFrozenQty;

    @ApiModelProperty(value = "备兑冻结仓")
    private Long coverFrozenQty;

    @ApiModelProperty(value = "权利价格")
    private Double rightsPrice;

    @ApiModelProperty(value = "义务价格")
    private Double obligPrice;

    @ApiModelProperty(value = "当日权利仓开仓数量")
    private Integer cumRightsQty;

    @ApiModelProperty(value = "当日义务仓开仓数量")
    private Integer cumObligQty;

    @ApiModelProperty(value = "盈亏")
    private Double profitAndLoss;

    @ApiModelProperty(value = "收益率")
    private Double rateOfReturn;

    @ApiModelProperty(value = "行权标识：数据字典100021")
    private Integer excercise;

    @ApiModelProperty(value = "注册时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "版本号")
    private Integer vers;

    /**
     * 将字节码数组转化为RspSelAssetInfo
     *
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public List<RspSelOption> parseResponse(byte[] bytes) throws InvalidProtocolBufferException {
        //将字节码数组通过protobuf转化
        ClientMgr.RspSelOption rspSelOptionProtobuf = ClientMgr.RspSelOption.parseFrom(bytes);
        List<ClientMgr.SelOption> list = rspSelOptionProtobuf.getInfosList();
        List<RspSelOption> rspList = new ArrayList<>();
        for (ClientMgr.SelOption selOption : list) {
            //将ClientMgr 中的数据封装到这个对象中r
            RspSelOption rspSelOption = new RspSelOption();
            rspSelOption.setId(selOption.getId())
                    .setUuserId(selOption.getUuserId())
                    .setUoptionId(selOption.getUoptionId())
                    .setUaccountId(selOption.getUaccountId())
                    .setRightsQty(selOption.getRightsQty())
                    .setObligQty(selOption.getObligQty())
                    .setCoverQty(selOption.getCoverQty())
                    .setCumRightsQty(selOption.getCumRightsQty())
                    .setProfitAndLoss(selOption.getProfitAndLoss())
                    .setRateOfReturn(selOption.getRateOfReturn())
                    .setExcercise(selOption.getExcercise());
            rspList.add(rspSelOption);
        }
        return null;
    }

}
