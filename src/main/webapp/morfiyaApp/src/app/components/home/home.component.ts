import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import { AlertService } from '../../alert/services/index';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent  {
  public model:any = {};
  private user = {};
   @ViewChild('closeBtn') closeBtn: ElementRef;
  
  changeLang(lang: string) {
    this.translate.use(lang);
  }
  constructor(public userService: UserService,public alertService: AlertService,private router:Router,private translate: TranslateService){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  logginUser(){
     
     this.userService.login(this.model.email,this.model.password).subscribe(data => 
     {this.respuestaLogin(data)},
     err => {
      this.alertService.clear();
      this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
     }
     );
    
  }

  respuestaLogin(data){
       
       this.user= data;
       this.closeModal();
       this.router.navigate(['users']);
  }

  //call this wherever you want to close modal
    private closeModal(): void {
        this.closeBtn.nativeElement.click();
  }
}