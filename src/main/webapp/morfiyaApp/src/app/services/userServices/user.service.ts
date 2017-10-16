import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class UserService {
  private url = '/conexion-servidor/';
  constructor(private http: HttpClient) {
  }

  loggingUser(email: String,password :String){

    this.http.get('/grupoc/rest/users/loggingUser/'+email+'/'+password).subscribe(data => {
      console.log(data);
    });
  }

}