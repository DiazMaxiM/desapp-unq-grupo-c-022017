import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {TranslateService} from '@ngx-translate/core';
import { RouterModule, Routes } from '@angular/router';
import { UserService } from './../../services/userServices/user.service';


@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  {
  public model:any = {};
  
  changeLang(lang: string) {
    this.translate.use(lang);
    console.log(lang);
  }
  constructor(private http: HttpClient,private translate: TranslateService){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }
  logginUser(): void {
  console.log('http://localhost:8080/grupoc/rest/users/loggingUser/'+this.model.username+'/'+this.model.password);
  this.http.get('http://localhost:8080/grupoc/rest/users/loggingUser/'+this.model.username+'/'+this.model.password).subscribe(data => {
      console.log(data);
    });
  }
}