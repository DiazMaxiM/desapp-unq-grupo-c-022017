import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {User} from './../../model/user';

@Injectable()
export class UserService {


  constructor(private http: Http) {
  }

  login(email: String,password :String){
    return this.http.get('/grupoc/rest/users/loggingUser/'+email+'/'+password).map((res:Response)=>res.json() as User);            
  }

  balance(id: String){
    return this.http.get('/grupoc/rest/users/getBalanceUser/'+id).map((res:Response)=>res.json());
  }

  addBalance(id: String, value:String){
    console.log(id);
    return this.http.get('/grupoc/rest/users/addTransactionUser/' + id +'/CREDIT/'+value).map((res:Response)=>res.json());
  }

  register(cuit: String, name: String, surname: String, email: String, telephone: String, locality: String, street: String, numberStreet: String, floor: String, password: String){
    return this.http.get('/grupoc/rest/users/loggingUser/'+email+'/'+password).map((res:Response)=>res.json() as User);
  }

}