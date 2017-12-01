import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ProviderService{
    
  constructor(private http: Http) {
  }

  registerProvider(password: string, name: string, surname: string,cuit:string, email: string,countryCode: string, areaCode: string,localNumber: string, locality: string, street: string, numberStreet: string, floor: string,latitude: string,length: string){
    return this.http.get('/grupoc/rest/provider/newuser/'+ password+'/'+name+'/'+ surname+'/'+ cuit +'/'+ email+'/'+countryCode+'/'+ areaCode+'/'+ localNumber+'/'+ locality+'/'+street+'/'+numberStreet+'/'+floor+'/'+latitude+'/'+length).map((res:Response)=>res);
  }

  getServices(id:string){
    return this.http.get('/grupoc/rest/provider/getServices/'+id).map((res:Response)=>res);
  }

  getMenusOfService(id:string){
    return this.http.get('/grupoc/rest/menu/listMenuForService/'+id).map((res:Response)=>res);
  }

  updateProvider(id:string,password:string,countryCode:number,areaCode:number,localNumber:number,locality:string,street:string,numberStreet:number,floor:number,latitude:number,length:number){
    return this.http.get('/grupoc/rest/provider/updateuser/'+id+'/'+password+'/'+countryCode+'/'+areaCode+'/'+localNumber+'/'+locality+'/'+street+'/'+numberStreet+'/'+floor+'/'+latitude+'/'+length).map((res:Response)=>res);
  }


}