import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {

  constructor(private http: Http) {
  }

  async loggingUser(email: String,password :String): Promise<number>{

    const response = await  this.http.get('http://localhost:8080/grupoc/rest/users/loggingUser/'+email+'/'+password).toPromise();
    return response.json();
  }

}