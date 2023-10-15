import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppproductComponent } from './appproduct/appproduct.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { RegistrationComponent } from './registration/registration.component';
import {ProductdetailsComponent} from './productdetails/productdetails.component';

const routes: Routes = [
  {path:'',component:HomepageComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'homepage',component:HomepageComponent},
  {path:'productlist',component:ProductlistComponent},
  {path:'addproduct',component:AppproductComponent},
  {path: 'productdetails', component:ProductdetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
