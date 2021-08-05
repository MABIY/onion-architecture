package com.lh.onionarchitecture.application.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/** @author lh */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "创建用户")
public class CreateUserAccountRequest {
  /** 账户名称 */
  @ApiModelProperty(required = true, value = "账户名称")
  @NotNull(message = "账户名称不能为空")
  private String accountName;

  /** 密码 */
  @ApiModelProperty(required = true, value = "密码")
  @NotNull(message = "密码不能为空")
  private String password;

  /** 归属公司id */
  @ApiModelProperty(required = true, value = "归属公司")
  @NotNull(message = "归属公司不能为空")
  private Long organizationId;


  /** 手机号码 */
  @ApiModelProperty(value = "手机号码")
  private String phone;

  /** 真实姓名 */
  @ApiModelProperty(value = "真实姓名")
  private String realName;
}
