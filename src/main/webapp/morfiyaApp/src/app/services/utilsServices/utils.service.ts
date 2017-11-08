import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UtilsService {
    
  constructor(private http: Http) {
  }

  localities(){
    return this.http.get('/grupoc/rest/locality/listLocality').map((res:Response)=>res);
  }

}