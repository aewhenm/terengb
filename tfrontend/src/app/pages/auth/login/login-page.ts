import { Component, OnInit } from '@angular/core';
import { LoginPageService } from './login-page.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.html',
  styleUrls: ['./login-page.scss']
})
export class LoginPage implements OnInit {

  constructor(private loginService: LoginPageService) {
  }

  ngOnInit(): void {
  }

  onInstaLoginClick() {
    this.loginService.redirectToInstaWindow();
  }
}
