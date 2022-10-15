import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { DisplayLoanComponent } from './display-loan/display-loan.component';
import { ExitPageComponent } from './exit-page/exit-page.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { PaymentScheduleComponent } from './payment-schedule/payment-schedule.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {
    path:"", component:WelcomeComponent
  },
  {
    path:"home", component:HomeComponent
  },
  {
    path:"createloan", component:CreateLoanComponent
  },
  {
    path:"paymentschedule", component:PaymentScheduleComponent
  },
  {
    path:"displayloan", component:DisplayLoanComponent
  },
  {
    path:"exit",component:ExitPageComponent
  },
  {
    path: "**",component:NotFoundComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
