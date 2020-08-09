package kz.terengeboilai.web.service.impl;

import kz.terengeboilai.web.exception.UserIsNotActualException;
import kz.terengeboilai.web.model.User;
import kz.terengeboilai.web.model.entity.UserInfoEntity;
import kz.terengeboilai.web.repository.UserRepository;
import kz.terengeboilai.web.service.AuthUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsServiceImpl implements AuthUserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserInfoEntity user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    if (!user.isActual()) {
      throw new UserIsNotActualException(username);
    }

    return new User(user);
  }

}
