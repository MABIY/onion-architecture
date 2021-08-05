package com.lh.onionarchiecture.object.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("账户状态")
public enum Status {
  @ApiModelProperty("启用")
  normal,
  @ApiModelProperty("禁用")
  disable
}
