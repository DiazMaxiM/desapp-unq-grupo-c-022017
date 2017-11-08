import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ProviderService {
    
  constructor(private http: Http) {
  }

  registerProvider(password: String, name: String, surname: String,cuit:string, email: String,countryCode: String, areaCode: String,localNumber: String, locality: String, street: String, numberStreet: String, floor: String,latitude: String,length: String){
    return this.http.get('/grupoc/rest/provider/newuser/'+ password+'/'+name+'/'+ surname+'/'+ cuit +'/'+ email+'/'+countryCode+'/'+ areaCode+'/'+ localNumber+'/'+ locality+'/'+street+'/'+numberStreet+'/'+floor+'/'+latitude+'/'+length).map((res:Response)=>res);
  }

}