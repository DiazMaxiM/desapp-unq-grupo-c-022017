import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {TranslateService} from '@ngx-translate/core';
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
    translate.addLangs(['en', 'hy']);
    translate.setDefaultLang('en');
    translate.use('en');
  }
  logginUser(): void {
  console.log('http://localhost:8080/grupoc/rest/users/loggingUser/'+this.model.username+'/'+this.model.password);
  this.http.get('http://localhost:8080/grupoc/rest/users/loggingUser/'+this.model.username+'/'+this.model.password).subscribe(data => {
      console.log(data);
    });
  }
}