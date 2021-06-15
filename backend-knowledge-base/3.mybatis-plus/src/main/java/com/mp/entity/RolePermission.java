package com.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("rolePermission")
@ApiModel("角色权限关系类")
public class RolePermission implements Serializable {

    @ApiModelProperty(name = "id", value = "ID 主键")
    @TableId(type = IdType.AUTO)
    private String id;

    @ApiModelProperty(name = "roleCode", value = "角色编号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer roleCode;

    @ApiModelProperty(name = "permission", value = "权限编号")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionCode;

}