package com.huayun.option.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.protobuf.InvalidProtocolBufferException;
import com.huayun.option.protobuf.ClientMgr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
@ApiModel(value = "RspUserInfo",description = "查询用户信息,响应")
public class RspUserInfo {
    @ApiModelProperty(name = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "开户公司ID")
    private String companyId;

    @ApiModelProperty(value = "证券公司开户账号")
    private String userAccount;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户属性")
    private Integer userPropty;

    @ApiModelProperty(value = "用户状态;0正常，1冻结，2禁止")
    private Integer userStatus;

    @ApiModelProperty(value = "用户费率组")
    private Integer feeGroup;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    /**
     * 将字节码数组转化为RspUserInfo
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public RspUserInfo getRspUserInfo(byte[] bytes) throws InvalidProtocolBufferException {
        //将字节码数组通过protobuf转化
        ClientMgr.RspUserInfo rspUserInfo = ClientMgr.RspUserInfo.parseFrom(bytes);
        //将ClientMgr.RspUserInfo中的数据封装到RspUserInfo中
        RspUserInfo userInfo = new RspUserInfo();
        userInfo.setUserId(rspUserInfo.getUserId())
                .setUserName(rspUserInfo.getUserName())
                .setCompanyId(rspUserInfo.getUserAccount())
                .setUserAccount(rspUserInfo.getUserAccount())
                .setPhone(rspUserInfo.getPhone())
                .setUserPropty(rspUserInfo.getUserPropty())
                .setUserStatus(rspUserInfo.getUserStatus())
                .setFeeGroup(rspUserInfo.getFeeGroup())
                .setCreateTime(rspUserInfo.getCreateTime())
                .setUpdateTime(rspUserInfo.getUpdateTime());
        return userInfo;
    }

    /**
     * 将字节码数组转化为RspUserInfoList
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public List<RspUserInfo> getRspUserInfoList(byte[] bytes) throws InvalidProtocolBufferException {
        List<RspUserInfo> rspUserInfoList=new ArrayList<>();
        //如果数组的length大于0，就循环执行
        while (bytes.length > 0) {
            RspUserInfo rspUserInfo = getRspUserInfo(bytes);
            rspUserInfoList.add(rspUserInfo);
        }
        return rspUserInfoList;
    }
}
