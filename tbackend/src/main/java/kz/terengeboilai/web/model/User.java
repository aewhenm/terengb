package kz.terengeboilai.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kz.terengeboilai.web.model.entity.RoleEntity;
import kz.terengeboilai.web.model.entity.UserInfoEntity;
import kz.terengeboilai.web.model.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User {

  private String id;
  private List<RoleEnum> roles;

  public User(UserInfoEntity user) {
    super(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
    this.id = id;
    this.roles = Optional.ofNullable(user.getRoles())
        .orElseGet(ArrayList::new)
        .stream()
        .map(RoleEntity::getCode)
        .collect(Collectors.toList());
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(List<RoleEntity> roleEntities) {
    List<String> permissions = getPermissions(roleEntities);
    return getGrantedAuthorities(permissions);
  }

  private static List<String> getPermissions(List<RoleEntity> roleEntities) {
    return Optional.ofNullable(roleEntities)
        .orElseGet(ArrayList::new)
        .stream()
        .map(roleEntity -> String.valueOf(roleEntity.getCode()))
        .collect(Collectors.toList());
  }

  private static Collection<? extends GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
    return Optional.ofNullable(permissions)
        .orElseGet(ArrayList::new)
        .stream()
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }

  public String getId() {
    return id;
  }

  public List<RoleEnum> getRoles() {
    return roles;
  }

}
