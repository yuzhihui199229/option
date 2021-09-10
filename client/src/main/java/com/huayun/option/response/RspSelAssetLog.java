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
@ApiModel(value = "RspSelAssetInfo",description = "资金流水响应")
public class RspSelAssetLog {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事务ID")
    private Long txId;

    @ApiModelProperty(value = "期权ID")
    private Integer uoptionId;

    @ApiModelProperty(value = "合约账户ID")
    private Integer uaccountId;

    @ApiModelProperty(value = "持仓ID")
    private Integer uposId;

    @ApiModelProperty(value = "组合策略持仓ID")
    private Integer ustrategyPosId;

    @ApiModelProperty(value = "执行编号")
    private String execId;

    @ApiModelProperty(value = "成交余额")
    private Double fromBalance;

    @ApiModelProperty(value = "成交冻结")
    private Double fromFrozen;

    @ApiModelProperty(value = "成交余额")
    private Double toBalance;

    @ApiModelProperty(value = "成交冻结")
    private Double toFrozen;

    @ApiModelProperty(value = "资金交易类型;0:buy, 1:sell, 2:in, 3:out, 4:frozen, 5:unfrozen")
    private Integer tradeType;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    /**
     * 将字节码数组转化为 RspSelAssetLog
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public List<RspSelAssetLog> getRspSelAssetLog(byte[] bytes) throws InvalidProtocolBufferException {
        //将字节码数组通过protobuf转化
        ClientMgr.RspSelAssetLog rspSelAssetLogProto = ClientMgr.RspSelAssetLog.parseFrom(bytes);
        List<ClientMgr.SelAssetLog> list = rspSelAssetLogProto.getInfosList();
        List<RspSelAssetLog> rspList = new ArrayList<>();
        for (ClientMgr.SelAssetLog selAssetLog : list) {
            //将ClientMgr.SelAssetLog 中的数据封装到 RspSelAssetLog 中
            RspSelAssetLog rspSelAssetLog = new RspSelAssetLog();
            rspSelAssetLog.setTxId(selAssetLog.getTxId())
                    .setUoptionId(selAssetLog.getUoptionId())
                    .setUaccountId(selAssetLog.getUaccountId())
                    .setUposId(selAssetLog.getUposId())
                    .setUstrategyPosId(selAssetLog.getUstrategyPosId())
                    .setExecId(selAssetLog.getExecId())
                    .setFromBalance(selAssetLog.getFromBalance())
                    .setFromFrozen(selAssetLog.getFromFrozen())
                    .setToBalance(selAssetLog.getToBalance())
                    .setToFrozen(selAssetLog.getToFrozen())
                    .setTradeType(selAssetLog.getTradeType())
                    .setCreateTime(selAssetLog.getCreateTime());
            rspList.add(rspSelAssetLog);
        }
        return rspList;
    }

}
