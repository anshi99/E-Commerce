import { Component, OnInit, ɵgetUnknownElementStrictMode } from '@angular/core';
import {FormGroup,FormControl, Validators, FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { NgserviceService } from 'src/app/ngservice.service';
import { User } from '../user';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  // ProductModelobj:ProductModel=new ProductModel();
  brandlist = new Set<String>();
  productNameParam  = ""
  brandName = ""
  productCode = ""
  url="assets/images/"
   _productlist !:any[];
   userid:any;
   user=new User();
   _searchproduct={
    id:"",
    name:"",
    brand:"",
    price:0
   };
   msg='';
   pricesearch:any = new FormGroup({});
   demo : any = new FormGroup({});
   brandfilter: any = new FormGroup({});

  constructor(private _service:NgserviceService,private _route:Router,private FB : FormBuilder) { 

    this.brandfilter=FB.group({
     brandvalue: ['', [Validators.required]]
    }
    )



    this.demo=FB.group({
      m: ['', [Validators.required]],
      n: ['', [Validators.required]]
    }
    )

  }

  ngOnInit(){
   this.userid=sessionStorage.getItem('userId');            
    this._service.fetchProductlistFromRemote().subscribe(
                       data=>{console.log(data)
                        this._productlist=data;
                        
                      },
                       error=>console.log("exception occured")
    )
  }

  search:any = new FormGroup({});
  filterBrand:any = new FormGroup({});


SearchProducts(){

  this.brandlist.clear()
  this.productNameParam=this._searchproduct.name
  this.brandName=this._searchproduct.brand
  this.productCode=this._searchproduct.id

  console.warn(this.productNameParam);
  console.warn(this.brandName);
  console.warn(this.productCode);
  

  console.warn("print hello");
  this._service.searchProductsFromRemotes(this._searchproduct).subscribe(
    data =>{
      for(let i=0;i<data.length;i++){

        this.brandlist.add(data[i].brand)

      }
      console.log("response received");
      //this._route.navigate(['/productlist'])
      this._productlist=data;
      console.warn(data);
      
    },
    error =>{
      console.log("Exception occured");
      this.msg="Product not Found";
    })
}

goToAddProduct(){
  this._route.navigate(['/addproduct']);
}



details(data : any){

  this._service.setIdtoService(data);
  this._route.navigate(['/productdetails'])
}



getPriceFilter(){

  console.warn(this.productNameParam);
  console.warn(this.brandName);
  console.warn(this.productCode);


  

  console.warn( this.pricesearch.value['min']);
  console.warn( this.pricesearch.value['max']);
  
  // this._service
  // .filterByPrice(this.productNameParam,this.brandName,this.productCode,
  //   this.pricefilter.value['min'],this.pricefilter.value['max'])


    
}

check()
{

  console.warn(this.productNameParam);
  console.warn(this.brandName);
  console.warn(this.productCode);

  
  console.warn( this.demo.value['m']);
  console.warn( this.demo.value['n']);

    this._service

      .filterByPrice(this.productNameParam,this.brandName,this.productCode+"", ""+ this.demo.value['m'],""+ this.demo.value['n'])

      .subscribe((result:any) => {

        this._productlist = result;

        console.warn(result);

      });
}

brandsearch(){

  console.warn(this.brandfilter.value['brandvalue']);
  
  this._service

  .filterByBrand(this.productNameParam,this.brandfilter.value['brandvalue'],this.productCode+"")

  .subscribe((result:any) => {

    this._productlist = result;

    console.warn(result);

  });

}


}
