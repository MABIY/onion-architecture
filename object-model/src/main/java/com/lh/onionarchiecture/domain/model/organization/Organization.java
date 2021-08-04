package com.lh.onionarchiecture.domain.model.organization;

import com.baomidou.mybatisplus.annotation.TableField;
import com.lh.onionarchiecture.domain.model.BaseEntity;
import com.lh.onionarchiecture.domain.model.Status;
import com.lh.onionarchiecture.domain.model.util.AreaCodeHierarchicalStructure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;

/** @author lh createTime: 2021-06-18 */
@Data
@Entity
@ApiModel("企业")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@org.hibernate.annotations.Table(appliesTo = "organization", comment = "企业")
@Table(
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"no"}),
      @UniqueConstraint(columnNames = {"name"}),
    })
public class Organization extends BaseEntity {

  /** 企业地址 */
  @ApiModelProperty(value = "企业地址")
  @Column(columnDefinition = "varchar(45) comment '企业地址'")
  private String address;

  /** 企业营业执照文件名 */
  @ApiModelProperty(value = "企业营业执照文件名")
  @Column(columnDefinition = "varchar(255) comment '企业营业执照文件名'")
  private String businessLicenseFilename;

  /** 关闭时间 */
  @ApiModelProperty(value = "关闭时间")
  @Column(columnDefinition = "datetime comment '关闭时间'")
  private Instant cancelTime;

  /** 企业法人 */
  @ApiModelProperty(value = "企业法人")
  @Column(columnDefinition = "varchar(45) comment '企业法人'")
  private String legalPerson;

  /** 企业法人电话 */
  @ApiModelProperty(value = "企业法人电话")
  @Column(columnDefinition = "varchar(45) comment '企业法人电话'")
  private String legalPersonPhone;

  /** 企业名称 */
  @ApiModelProperty(value = "企业名称")
  @Column(columnDefinition = "varchar(45) comment '企业名称'")
  private String name;

  /** 企业编号 */
  @ApiModelProperty(value = "企业编号")
  @Column(columnDefinition = "varchar(45) comment '企业编号'")
  private String no;

  /** 服务城市 */
  @ApiModelProperty(value = "服务城市")
  @Column(columnDefinition = "int comment '服务城市'")
  private Integer serviceCityCode;

  /** 服务城市地址信息 */
  @ApiModelProperty(value = "服务城市地址信息")
  @Transient
  @TableField(exist = false)
  private AreaCodeHierarchicalStructure serviceCityHierarchicalStructure;
  /** 状态 */
  @ApiModelProperty(value = "状态")
  @Column(columnDefinition = "varchar(45) comment '状态'")
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private Status status = Status.normal;

  /** 企业类型 */
  @ApiModelProperty(value = "企业类型")
  @Column(columnDefinition = "varchar(45) not null comment '企业类型'")
  @Enumerated(EnumType.STRING)
  private OrganizationType type;

  /** 统一社会信用代号 */
  @ApiModelProperty(value = "统一社会信用代号")
  @Column(columnDefinition = "varchar(45) comment '统一社会信用代号'")
  private String unifiedSocialCreditCode;

  /** 客服中心实例ID */
  @ApiModelProperty(value = "客服中心实例ID")
  @Column(columnDefinition = "varchar(45) comment '客服中心实例ID'")
  private String ccInstanceId;

  /** 未交付项目 */
  @ApiModelProperty(value = "未交付项目")
  @Transient
  @TableField(exist = false)
  private Integer undeliveredProjects;

  /** 已交付项目 */
  @ApiModelProperty(value = "已交付项目")
  @Transient
  @TableField(exist = false)
  private Integer deliveredProjects;

  @ApiModelProperty(value = "管理员账户")
  @Transient
  @TableField(exist = false)
  private String accountName;

  /** 联系人名称 */
  @ApiModelProperty(value = "联系人名称")
  @Transient
  @TableField(exist = false)
  private String contactName;

  /** 联系人手机号 */
  @ApiModelProperty(value = "联系人手机号")
  @Transient
  @TableField(exist = false)
  private String contactPhone;

  public static String getEntityNotFoundExceptionMessage(String columns, String values) {
    return String.format("%s:%s,对应公司实体,不存在", columns, values);
  }

  public static String getEntityExistsExceptionMessage(String columns, String values) {
    return String.format("%s:%s,对应公司实体已存在", columns, values);
  }

  /*
  子公司负责的项目
   */
  public enum OrganizationProjectType {
    /** 已交付 */
    DELIVERED,
    /** 未交付 */
    UNDELIVERED,
  }
}
