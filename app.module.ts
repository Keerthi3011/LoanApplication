import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { PaymentScheduleComponent } from './payment-schedule/payment-schedule.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { DisplayLoanComponent } from './display-loan/display-loan.component';
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';
import { ExitPageComponent } from './exit-page/exit-page.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    CreateLoanComponent,
    PaymentScheduleComponent,
    NotFoundComponent,
    DisplayLoanComponent,
    HomeComponent,
    WelcomeComponent,
    ExitPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
