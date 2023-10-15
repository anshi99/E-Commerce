import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from '../ngservice.service';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  _reviewCount!:any;
  _userCount!:any;
  _productlist : any;
  url="assets/images/"
  //user=new User();
  
  constructor(private _service:NgserviceService,private _route:Router,private _regService:RegistrationService) { }

  ngOnInit() {

    this._service.fetchProductlistFromRemote().subscribe(
      data=>{console.log(data)
       this._productlist=data;
       
     },
      error=>console.log("exception occured")
)
    

this._regService.fetchUserCountFromRemote().subscribe(
  data=>{console.log(data)
    this._userCount=data;
 },
  error=>console.log("exception occured")
)
  }

  details(data : any){

  }

}
