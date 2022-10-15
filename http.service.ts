import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url: String = "http://localhost:8080/"
  
  constructor(private http: HttpClient) { }

  setLoan(data:any){
    return(this.http.post(`${this.url}newloan`,data,{responseType: 'text'}))
  }

  getLoan(){
    return(this.http.get(`${this.url}displayloan`))
  }
  getSchedule(){
    return (this.http.get(`${this.url}displayschedule`))
  }
}
