package kz.terengeboilai.web.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import kz.terengeboilai.web.model.enums.PermissionEnum;

@Entity(name = "RolePermission")
@Table(name = "role_permission")
public class RolePermissionEntity extends ActualEntity {

  @Id
  @Enumerated(EnumType.STRING)
  private PermissionEnum code;

  private String name;

  public PermissionEnum getCode() {
    return code;
  }

  public void setCode(PermissionEnum code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
