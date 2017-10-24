import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent  {
  public model:any = {};
  private user : User = new User();
   @ViewChild('closeBtn') closeBtn: ElementRef;
  
  changeLang(lang: string) {
    this.translate.use(lang);
  }

  constructor(public userService: UserService,public alertService: AlertService,private router:Router,private translate: TranslateService,public messageService : MessageService){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  logginUser(){
     
     this.userService.login(this.model.email,this.model.password).subscribe(data => 
     {this.respuestaLogin(data)},
     err => {
      this.model.email="";
      this.model.password="";
      this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
      setInterval (() => {
        this.alertService.clear();
      }, 2000)
    });
  }

  newUser() {
    this.userService.register(this.model.cuit, this.model.name, this.model.surname, this.model.email, this.model.telephone, this.model.locality, this.model.street, this.model.numberStreet, this.model.floor, this.model.password).subscribe(data => 
     {this.respuestaRegister(data)},
     err => {
      
      this.model.cuit="";
      this.model.name="";
      this.model.surname="";
      this.model.email="";
      this.model.telephone="";
      this.model.locality="";
      this.model.street="";
      this.model.numberStreet="";
      this.model.floor="";
      this.model.password="";
      this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
      setInterval (() => {
        this.alertService.clear();
      }, 2000)
    });
  }

  respuestaLogin(data){
<<<<<<< HEAD
       this.user= Object.assign(new User,data);
=======
       this.user= data as User;
       this.sendData();
       this.closeModal();
       this.router.navigate(['users']);
  }

  respuestaRegister(data){
       this.user= data as User;
>>>>>>> cd9ca61cd30b6524254c99717da7a0c6fe5366e8
       this.sendData();
       this.closeModal();
       this.router.navigate(['users']);
  }

  //call this wherever you want to close modal
    private closeModal(): void {
        this.closeBtn.nativeElement.click();
  }

  private sendData(): void {
       this.messageService.changeMessage(this.user);
    }

  search()  {
    this.router.navigate(['menus']);
  }

}