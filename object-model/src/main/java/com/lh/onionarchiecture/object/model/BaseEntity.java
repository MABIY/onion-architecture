package com.lh.onionarchiecture.object.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

/**
 * 基础的实体对象.
 *
 * @author lh
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@TypeDefs({
  @TypeDef(name = "json", typeClass = JsonStringType.class),
  @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Accessors(chain = true)
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "BIGINT comment '创建人'")
  @CreatedBy
  @ApiModelProperty(value = "创建人")
  private Long createBy;

  @CreatedDate
  @Column(columnDefinition = "DATETIME NOT NULL comment '创建时间'")
  @ApiModelProperty(value = "创建时间")
  private Instant createTime;

  @Column(columnDefinition = "BIGINT comment '修改人'")
  @LastModifiedBy
  @ApiModelProperty(value = "修改人")
  private Long lastModifiedBy;

  @LastModifiedDate
  @Column(columnDefinition = "DATETIME comment '修改时间'")
  @ApiModelProperty(value = "修改时间")
  private Instant lastModifiedTime;
}
