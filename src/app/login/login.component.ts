import { Component, OnInit } from '@angular/core';
import { NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   
 user=new User();
 msg='';
  constructor(private _service:RegistrationService,private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser(){
   this._service.loginUserFromRemote(this.user).subscribe(
    data =>{
      console.log("response received");
     sessionStorage.setItem('userId',data.userName);
      console.log(data);
      console.log(this.user.userName?.toString());
      this._router.navigate(['/productlist'])
    },
    error =>{
      console.log("Exception occured");
      this.msg="Bad credentials,please enter valid emailid and password";
    })
  }

  gotoregistration(){
    this._router.navigate(['/registration'])
  }

}
