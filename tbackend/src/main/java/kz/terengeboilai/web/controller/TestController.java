package kz.terengeboilai.web.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/test")
public class TestController {

  @GetMapping("/auth/insta")
  public String instaAuth(Principal principal) {
    return "";
  }

}
