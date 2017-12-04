import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class PurchaseService {
  currency : string;
  constructor(private http: Http) {
  }

  newOrder(order){
    return this.http.post('/grupoc/rest/orders/newOrder/',order).map((res:Response)=>res);
  }

  
  hasPendingScore(idClient: string){
    return this.http.get('/grupoc/rest/score/scorePending/'+ idClient).map((res:Response)=>res);
  }

}