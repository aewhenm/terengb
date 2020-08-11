package kz.terengeboilai.web.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "user_info")
public class UserInfoEntity extends ActualEntity {

  @Id
  private String id;

  private String username;

  private String password;

  @ManyToMany
  @JoinTable(
      name = "user_info_roles",
      joinColumns = @JoinColumn(name = "user_info_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "code")
  )
  private List<RoleEntity> roles;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String nickname) {
    this.username = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<RoleEntity> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleEntity> roles) {
    this.roles = roles;
  }

}
