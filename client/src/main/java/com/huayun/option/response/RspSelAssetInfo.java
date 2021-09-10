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
@ApiModel(value = "RspSelAssetInfo",description = "资金信息响应")
public class RspSelAssetInfo {
    private Integer id;

    @ApiModelProperty(value = "保证金账户")
    private String assetAccount;

    @ApiModelProperty(value = "用户ID")
    private Integer uuserId;

    @ApiModelProperty(value = "日间余额")
    private Double balance;

    @ApiModelProperty(value = "冻结资金")
    private Double frozen;

    @ApiModelProperty(value = "实时保证金")
    private Double marginAmount;

    @ApiModelProperty(value = "注册时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "资金版本号")
    private Integer vers;

    /**
     * 将字节码数组转化为RspSelAssetInfo
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public List<RspSelAssetInfo> getRspSelAssetInfo(byte[] bytes) throws InvalidProtocolBufferException {
        //将字节码数组通过protobuf转化
        ClientMgr.RspSelAssetInfo rspSelAssetInfoProto = ClientMgr.RspSelAssetInfo.parseFrom(bytes);
        List<ClientMgr.SelAssetInfo> list = rspSelAssetInfoProto.getInfosList();
        List<RspSelAssetInfo> rspList = new ArrayList<>();
        for (ClientMgr.SelAssetInfo selAssetInfo : list) {
            //将ClientMgr.SelAssetInfo 中的数据封装到 RspSelAssetInfo 中
            RspSelAssetInfo rspSelAssetInfo = new RspSelAssetInfo();
            rspSelAssetInfo.setId(selAssetInfo.getId())
                    .setAssetAccount(selAssetInfo.getAssetAccount())
                    .setUuserId(selAssetInfo.getUuserId())
                    .setBalance(selAssetInfo.getBalance())
                    .setFrozen(selAssetInfo.getFrozen())
                    .setMarginAmount(selAssetInfo.getMarginAmount())
                    .setCreateTime(selAssetInfo.getCreateTime())
                    .setUpdateTime(selAssetInfo.getUpdateTime())
                    .setVers(selAssetInfo.getVers());
            rspList.add(rspSelAssetInfo);
        }
        return rspList;
    }

}
