import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class MenusService {

  constructor(private http: Http) {
  }
  
  getMenuForName(name :String){
    return this.http.get('/grupoc/rest/menu/locality/listMenu/'+name).map((res:Response)=>res);
  }

  getMenuForLocality(name :String){
    return this.http.get('/grupoc/rest/menu/locality/listMenu/'+name).map((res:Response)=>res);
  }

  getMenus(){
    return this.http.get('/grupoc/rest/menu/listMenus').map((res:Response)=>res);
  }

}