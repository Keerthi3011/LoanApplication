import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-payment-schedule',
  templateUrl: './payment-schedule.component.html',
  styleUrls: ['./payment-schedule.component.css']
})
export class PaymentScheduleComponent implements OnInit {

  Details:any[]=[];

  constructor(private service:HttpService) { }

  ngOnInit(): void 
  {
    this.getScheduleDetails();
  }

  getScheduleDetails(){
    this.service.getSchedule().subscribe((result:any)=>{
       this.Details=result
    })
  }
}
