import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgserviceService } from '../ngservice.service';
import { ProductlistComponent } from '../productlist/productlist.component';
@Component({
  selector: 'app-appproduct',
  templateUrl: './appproduct.component.html',
  styleUrls: ['./appproduct.component.css']
})
export class AppproductComponent implements OnInit {
// product=new Product();
  constructor( private _route:Router,private _service:NgserviceService) { }

  ngOnInit(): void {
  }

  addProductformsubmit(){
    //  this._service.addProductToRemote(this.product).subscribe
    //  (
    //   data =>{
    //     console.log("data added successufully");
    //     this._route.navigate(['productlist']);
    //   },
    //   error=>console.log("error")
      
    //  )
  }

  gotolist(){
    console.log("go back");
    this._route.navigate(['productlist']);
  }
}
