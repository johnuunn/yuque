package com.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("permission")
@ApiModel("权限类")
public class Permission implements Serializable {

    @ApiModelProperty(name = "id", value = "ID 主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty(name = "permissionCode", value = "权限编号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionCode;

    @ApiModelProperty(name = "permissionName", value = "权限名")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionName;

    @ApiModelProperty(name = "path", value = "映射路径")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String path;

}