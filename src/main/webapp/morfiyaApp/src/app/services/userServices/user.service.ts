import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserService {
  private apiUrl = 'http://localhost:3030/api/pub/items';
  private operationsCount = 0;

  constructor(private http: HttpClient) {
  }

  saveOperation$(newOperation: String): Observable<any> {
    return this.http
      .post(this.apiUrl, newOperation);
  }

}