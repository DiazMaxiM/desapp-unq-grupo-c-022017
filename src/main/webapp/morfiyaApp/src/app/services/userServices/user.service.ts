import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {


  constructor(private http: Http) {
  }

  login(email: String,password :String){
    return this.http.get('/grupoc/rest/users/loggingUser/'+email+'/'+password).map((res:Response)=>res.json());            
  }

  balance(id: String){
    return this.http.get('/grupoc/rest/users/getBalanceUser/'+id).map((res:Response)=>res.json());
  }

  addBalance(id: String, value:number){

    return this.http.get('/grupoc/rest/users/addTransactionUser/' + id +'/CREDIT/'+value).map((res:Response)=>res);
  }

  getUserData(id: String){
    return this.http.get('/grupoc/rest/users/getUserData/'+id).map((res:Response)=>res.json());
  }

  updateUser(id:string,password:string,countryCode:number,areaCode:number,localNumber:number,locality:string,street:string,numberStreet:number,floor:number,latitude:number,length:number){
    return this.http.get('/grupoc/rest/users/updateuser/'+id+'/'+password+'/'+countryCode+'/'+areaCode+'/'+localNumber+'/'+locality+'/'+street+'/'+numberStreet+'/'+floor+'/'+latitude+'/'+length).map((res:Response)=>res);
  }

}