import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {ValidationManager} from "ng2-validation-manager";
declare var $:any;

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  public model:any = {};
  private user : User = new User();
  form: FormGroup;
  formRegister 
  changeLang(lang: string) {
    this.translate.use(lang);
  }
  mensaje :String;

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

    this.formRegister = new ValidationManager({
      'name'        : 'required',
      'surname'     : 'required',
      'cuit'        : 'required',
      'email'       : 'required',
      'street'      : 'required',
      'number'      : 'required',
      'floor'       : 'required',
      'locality'    : 'required',
      'countryCode' : 'required',
      'areaCode'    : 'required',
      'localNumber' : 'required',
      'length'    : 'required',
      'latitude' : 'required',
      'password'    : 'required|rangeLength:3,50',
      'repassword'  : 'required|equalTo:password'
    });
  }

  logginUser(){
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
    console.log(this.formRegister.getValue('length'));
    if(this.formRegister.isValid()){
      this.userService.register(this.formRegister.getValue('password'),this.formRegister.getValue('name'),this.formRegister.getValue('surname'),this.formRegister.getValue('cuit'),this.formRegister.getValue('email'),this.formRegister.getValue('countryCode'),this.formRegister.getValue('areaCode'),this.formRegister.getValue('localNumber'),this.formRegister.getValue('locality').toUpperCase(),this.formRegister.getValue('street'), this.formRegister.getValue('number'),this.formRegister.getValue('floor'),this.formRegister.getValue('latitude'),this.formRegister.getValue('length')).subscribe(data => 
        {this.result(data)},
      err => {
        this.formRegister.reset();
        this.showModal(this.translate.instant(JSON.parse(err._body).code.toString()));
      });
    }else{
      this.showModal(this.translate.instant("1004"));
    }
  }

  result(data){
       this.user= Object.assign(new User,JSON.parse(data._body));
       this.sendData();
       $('#modalLogin').modal('hide');
       this.router.navigate(['users']);
  }

  //call this wherever you want to close modal
  private sendData(): void {
       this.messageService.changeMessage(this.user);
    }  

  search()  {
    this.router.navigate(['menus']);
  }

  showModal(msg){
    this.mensaje= msg;
      $('#modal-update').modal('show');
  }


}