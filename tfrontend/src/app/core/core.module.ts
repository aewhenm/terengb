import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpService } from './http.service';
import { HttpClientModule } from '@angular/common/http';

const services = [
  HttpService
];

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [
    services
  ]
})
export class CoreModule {
}
