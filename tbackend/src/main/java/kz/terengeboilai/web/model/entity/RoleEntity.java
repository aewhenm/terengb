package kz.terengeboilai.web.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import kz.terengeboilai.web.model.enums.RoleEnum;

@Entity(name = "Role")
@Table(name = "role")
public class RoleEntity extends ActualEntity {

  @Id
  @Enumerated(EnumType.STRING)
  private RoleEnum code;

  private String name;

  public RoleEnum getCode() {
    return code;
  }

  public void setCode(RoleEnum code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
