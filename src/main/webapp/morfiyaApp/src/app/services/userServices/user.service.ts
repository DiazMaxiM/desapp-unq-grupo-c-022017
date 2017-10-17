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

}