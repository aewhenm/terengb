import { NgModule } from '@angular/core';

import { LoginPageRoutingModule } from './login-page-routing.module';
import { LoginPage } from './login-page';
import { LoginPageService } from './login-page.service';
import { CoreModule } from '@core/core.module';

const services = [
  LoginPageService
];

@NgModule({
  declarations: [LoginPage],
  imports: [
    CoreModule,
    LoginPageRoutingModule
  ],
  providers: [services]
})
export class LoginPageModule {
}
