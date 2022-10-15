import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-create-loan',
  templateUrl: './create-loan.component.html',
  styleUrls: ['./create-loan.component.css']
})
export class CreateLoanComponent implements OnInit {

  Response: String=""
  issubmitDissabled:boolean=true
  data: any;
  backendResponse: any;

  constructor(private service:HttpService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(value:any)
  {
    this.data=value
    this.service.setLoan(this.data).subscribe((result:any)=>
    {
    this. issubmitDissabled=false;
    this.  Response=result
    //console.log(result)
   })
  }

  ApplyLoan(){
    let popup = document.getElementById('loan')
    popup?.classList.add("open-popup")
  }

  cancelLoan(){
    let popup = document.getElementById("loan")
    popup?.classList.remove("open-popup")
    window.location.reload();
  }
  closeCancel(){
    let popup = document.getElementById("loan")
    popup?.classList.remove("open-popup")
    alert("Loan is canceled")
    window.location.reload();
     }
   
}