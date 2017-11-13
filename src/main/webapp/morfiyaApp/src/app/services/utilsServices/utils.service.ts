import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UtilsService {
  currency : string;
  constructor(private http: Http) {
  }

  localities(){
    return this.http.get('/grupoc/rest/locality/listLocality').map((res:Response)=>res);
  }

  setCurrency(curr: string) {
    this.currency = curr;
  }
  
  getCurrency() {
  	if (this.currency==''){
  		return 'USD';
  	}
    return this.currency;
  }
}