import { Component, OnInit } from '@angular/core';
import { NgserviceService } from 'src/app/ngservice.service';
import { Router } from '@angular/router';
import {FormGroup,FormControl, Validators, FormBuilder} from '@angular/forms';
import { defaultThrottleConfig } from 'rxjs/internal/operators/throttle';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.css']
})
export class ProductdetailsComponent implements OnInit {

  url="assets/images/"
  product : any = {};
  id : any;
  mydate = new Date();
  sample = 5;
  searchFlag =false;
  searchFlag1 =false;
  days : any;
  search:any = new FormGroup({});
  constructor(private _service:NgserviceService,private _route:Router, private FB: FormBuilder) { 
    this.search=FB.group({
      pincode: ['', [Validators.required, Validators.minLength(6),Validators.maxLength(6),Validators.pattern('[0-9]*')]]
    }
    )

   
  }

  ngOnInit(): void {

    this.id = this._service.getId();
    this._service
    .getProductById(this.id)
    .subscribe((result : any) => {
      this.product = result;
      console.warn(this.product);
    }
    )
  }


get f()
{
  return this.search.controls;
}

clicked(){
  console.warn(this.id);
  this._service
  .getProductById(this.id)
  .subscribe((result:any) =>{
    this.product= result;
    console.warn(this.product);  
  })
}

findDays(){

  console.warn(this.search.value['pincode']);
  

  this._service
  .getDaysByPincode(this.search.value['pincode'])
  .subscribe((result:any) => {
    this.mydate = new Date();
    console.warn(result);
    if(result==null){
      this.searchFlag1= true;
    }
    else{
      this.searchFlag = true;
      this.days = result.days;

      this.mydate.setDate(this.mydate.getDate()+ parseInt(this.days));
      console.warn(this.mydate);
      
    }
  });

  this.searchFlag = false;
  this.searchFlag1 = false;
}



}

