import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  public model:any = {};
  private user : User = new User();
  form: FormGroup;
  @ViewChild('closeBtn') closeBtn: ElementRef;
  
  changeLang(lang: string) {
    this.translate.use(lang);
  }

  constructor(public userService: UserService,public alertService: AlertService,private router:Router,private translate: TranslateService,public messageService : MessageService,private formBuilder: FormBuilder){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, Validators.required],
    });
  }

  logginUser(){
    console.log(this.form.get('email').value);
     this.userService.login(this.form.get('email').value,this.form.get('password').value).subscribe(data => 
     {this.result(data)},
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
    this.userService.register(this.model.cuitToRegister, this.model.nameToRegister, this.model.surnameToRegister, this.model.emailToRegister, this.model.telephoneToRegister, this.model.localityToRegister, this.model.streetToRegister, this.model.numberStreetToRegister, this.model.floorToRegister, this.model.passwordToRegister).subscribe(data => 
     {this.result(data)},
     err => {
      
      this.model.cuitToRegister="";
      this.model.nameToRegister="";
      this.model.surnameToRegister="";
      this.model.emailToRegister="";
      this.model.telephone="";
      this.model.localityToRegister="";
      this.model.streetToRegister="";
      this.model.numberStreetToRegister="";
      this.model.floorToRegister="";
      this.model.passwordToRegister="";
      this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
      setInterval (() => {
        this.alertService.clear();
      }, 2000)
    });
  }

  result(data){
       this.user= Object.assign(new User,JSON.parse(data._body));
       this.sendData();
       this.closeModal();
       this.router.navigate(['users']);
  }

  //call this wherever you want to close modal

  private sendData(): void {
       this.messageService.changeMessage(this.user);
    }  

  search()  {
    this.router.navigate(['menus']);
  }

   //call this wherever you want to close modal
   private closeModal(): void {
    this.closeBtn.nativeElement.click();
}

}