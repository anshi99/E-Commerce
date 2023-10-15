import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NgserviceService {

  private id : any;

  constructor(private _http:HttpClient) { }



  fetchProductlistFromRemote():Observable<any>{
     return this._http.get<any>("http://localhost:8030/getproductlist");
     
  }

  getDaysByPincode(data:any)
  {
    return this._http.get("http://localhost:8030/bypincode" + "?pincode="+data);
  }

  setIdtoService(data : any){
    this.id=data;
  }

  getId()
  {
    return this.id;
  }

  getProductById(data : any){
    return this._http.get("http://localhost:8030/getproductbyid?id="+ data);
  }

  searchProductsFromRemote(product:any):Observable<any>{
    var id=product.id==''? 0: product.id;//if product id is blank controller expect 0 value
    id=id==null? 0: product.id; //even if value is null, 0 value should pass to controller
    console.warn(id);
    
    var name=product.name==''?'\"\"':product.name;//if product name is blank controller expect "" value

    console.warn(name);
    
    var brand=product.brand==''?'\"\"':product.brand;////if product brand is blank controller expect "" value

    console.warn(brand);
    
    //  return this._http.get<any>('http://localhost:8030/fetchproduct/'+id+'/'+name+'/'+brand)

    return this._http.get<any>('http://localhost:8030/fetchproducts?id='+id+'&name='+name+'&brand='+brand)
 }

 filterByPrice(productNameParam : any,brandName  : any,productCode  : any,min  : any,max  : any){

  if(productNameParam==""){
    productNameParam=null;
  }

  if(productCode==""){
    productCode=0;
  }

  if(brandName==""){
    brandName=null;
  }


   return this._http.get<any>('http://localhost:8030/filterbyprice?id=' + productCode + 
   '&productName=' + productNameParam + "&brandName=" + brandName + "&min=" + min + "&max=" + max);
  }


  filterByBrand(productNameParam : any,brandName  : any,productCode  : any){

    if(productNameParam==""){
      productNameParam="";
    }
  
    if(productCode==""){
      productCode=0;
    }
  
    if(brandName==""){
      brandName="";
    }
  
  
     return this._http.get<any>('http://localhost:8030/filterbybrand?' + 
     'productName=' + productNameParam + "&brand=" + brandName +  "&id=" + productCode);
    }


    searchProductsFromRemotes(product:any):Observable<any>{
     
      var id = product.id;
      var name = product.name;
      var brand = product.brand;
      //  return this._http.get<any>('http://localhost:8030/fetchproduct/'+id+'/'+name+'/'+brand)

      if(id==""){
        id=0;
      }
    
      if(name == ""){
        name=null;
      }
    
      if(brand==""){
        brand=null;
      }
    
  
      return this._http.get<any>('http://localhost:8030/fetchproducts?id='+id+'&name='+name+'&brand='+brand)

      
   }
}
