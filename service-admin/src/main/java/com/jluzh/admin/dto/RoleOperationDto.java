package com.jluzh.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleOperationDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    private Long Id;
    private OperationProp operation;
}
