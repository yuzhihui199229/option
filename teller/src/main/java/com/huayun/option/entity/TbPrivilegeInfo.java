package com.huayun.option.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author yuzh
 * @since 2021-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TbPrivilegeInfo对象", description="权限表")
public class TbPrivilegeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜单ID")
    private String menuId;

    @ApiModelProperty(value = "菜单级别：1=1级目录,2=2级目录")
    private String menuLevel;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单路径")
    private String menuPath;

    @ApiModelProperty(value = "上级菜单id")
    private String preMenuId;

    @ApiModelProperty(value = "当前目录基本排序")
    private Integer sort;

    @ApiModelProperty(value = "子菜单")
    private TbPrivilegeInfo childMenu;


}
