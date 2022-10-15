import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-display-loan',
  templateUrl: './display-loan.component.html',
  styleUrls: ['./display-loan.component.css']
})
export class DisplayLoanComponent implements OnInit {

  Details:any[]=[];

  constructor(private service:HttpService) { }

  ngOnInit(): void 
  {
    document.body.className="white";
    this.getLoanDetails();
  }

  getLoanDetails(){
    this.service.getLoan().subscribe((result:any)=>{
       this.Details=result
     // console.log(result)
    })
  }
}
