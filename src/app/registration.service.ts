import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import { HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http:HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8030/login",user)
  }

  public registerUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8030/registeruser",user)
  }

  fetchUserCountFromRemote():Observable<any>{
    return this._http.get<any>("http://localhost:8030/userstats");
    
  }

   handleError(error:Response) {   
    
   } 

}
