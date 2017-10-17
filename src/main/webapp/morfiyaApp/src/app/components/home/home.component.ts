import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent  {
  public model:any = {};
  private idUser: any;
   @ViewChild('closeBtn') closeBtn: ElementRef;
  
  changeLang(lang: string) {
    this.translate.use(lang);
  }
  constructor(public userService: UserService,private router:Router,private translate: TranslateService,private http: HttpClient){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  logginUser(){

     return this.http.get('/grupoc/rest/users/loggingUser/'+ this.model.email+'/'+ this.model.password).subscribe(res=>{
        this.idUser = res ;
        this.closeModal();
        this.router.navigate(['users']);
    });
  }

  //call this wherever you want to close modal
    private closeModal(): void {
        this.closeBtn.nativeElement.click();
  }
}