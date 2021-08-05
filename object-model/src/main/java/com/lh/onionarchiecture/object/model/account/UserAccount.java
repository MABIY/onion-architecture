package com.lh.onionarchiecture.object.model.account;

import com.lh.onionarchiecture.object.model.Status;
import com.lh.onionarchiecture.object.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/** @author lh createTime: 2021-06-18 */
@Data
@Entity
@ApiModel("账户")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@org.hibernate.annotations.Table(appliesTo = "user_account", comment = "账户")
@Accessors(chain = true)
@Table(
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"accountName"}),
    })
public class UserAccount extends BaseEntity {

  /** 账户名称 */
  @ApiModelProperty(value = "账户名称")
  @Column(columnDefinition = "varchar(45) comment '账户名称'")
  private String accountName;

  /** 密码 */
  @ApiModelProperty(value = "密码")
  @Column(columnDefinition = "varchar(100) comment '密码'")
  private String password;

  /** 状态 */
  @ApiModelProperty(value = "状态")
  @Column(columnDefinition = "varchar(45) comment '状态'")
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private Status status = Status.normal;

  /** 手机号码 */
  @ApiModelProperty(value = "手机号码")
  @Column(columnDefinition = "varchar(45) comment '手机号码'")
  private String phone;

  /** 真实姓名 */
  @ApiModelProperty(value = "真实姓名")
  @Column(columnDefinition = "varchar(45) comment '真实姓名'")
  private String realName;

  /** 坐席AK */
  @ApiModelProperty(value = "坐席AK")
  @Column(columnDefinition = "varchar(45) comment '坐席AK'")
  private String ccAK;

  /** 坐席SK*/
  @ApiModelProperty(value = "坐席SK")
  @Column(columnDefinition = "varchar(45) comment '坐席SK'")
  private String ccSK;

  /** 头像*/
  @ApiModelProperty(value = "头像")
  @Column(columnDefinition = "varchar(255) comment '头像'")
  private String avatar;

  public static String getEntityNotFoundExceptionMessage(String columns, String values) {
    return String.format("%s:%s,对应账户数据不存在", columns, values);
  }

  public static String getEntityExistsExceptionMessage(String columns, String values) {
    return String.format("%s:%s,对应账户已存在", columns, values);
  }
}
