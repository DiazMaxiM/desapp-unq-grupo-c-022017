import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import {TypeRegisterService} from './../../services/typeRegisterService/typeRegister.service';
import { AlertService } from '../../alert/services/index';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Directive, forwardRef, Attribute,OnChanges, SimpleChanges,Input } from '@angular/core';
import { NG_VALIDATORS,Validator,AbstractControl,ValidatorFn } from '@angular/forms';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { AuthService } from '../../auth/auth.service';
import { LanguageService} from './../../services/languageService/languageService.service';
import { Location } from '@angular/common';
import { ServiceProvider} from './../../services/serviceProvider/serviceProvider.service';
declare var $:any;
import {NgbDatepickerI18n} from '@ng-bootstrap/ng-bootstrap';
import { I18n,CustomDatepickerI18n } from './../../services/calendarLanguage/customDatepickerI18n.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

  public model:any = {};
  private user=null;
  form: FormGroup;
  submitted = false;
  currency : string;

  changeLang(lang: string) {
    this.translate.use(lang);
    this.setCurrency(lang);
  }

  setCurrency(lang:string){
    console.log(lang);
    if (lang == 'es'){
      this.currency = 'ARS';
    }else if (lang == 'en'){
      this.currency =  'USD';
    }else {
       this.currency = 'EUR';
    }
    this.languague.changeMessage(this.currency);
    this.setCalendarLanguage(lang);
  }

  setCalendarLanguage(key){
   this.custom.changeLanguage(key);
  
  }

  mensaje :String;


  constructor( public serviceProvider:ServiceProvider,private custom:CustomDatepickerI18n,private location: Location,public languague: LanguageService,public userService: UserService,public alertService: AlertService,private router:Router,private translate: TranslateService,public messageService : MessageService,private formBuilder: FormBuilder,private typeRegisterService: TypeRegisterService,private utilsServices: UtilsService,public auth: AuthService){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
    this.setCurrency('es');
  }

  ngOnInit() {

    this.form = this.formBuilder.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, Validators.required],
    });
  }

  onSubmit() { 
    this.submitted = true; 
    this.logginUser();
  
  }

  logginUser(){
     this.userService.login(this.model.email,this.model.password).subscribe(data => 
     {this.result(data)},
     err => {
      this.resetForm();
      this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
      setInterval (() => {
        this.alertService.clear();
      }, 2000)
    });
  }

  result(data){
       this.user= JSON.parse(data._body);
       this.sendData();
       $('#modalLogin').modal('hide');
       this.router.navigate(['users']);
  }

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

  resetForm(){
    this.form.reset();
  }

  registerClient(){
    $('#modalRegister').modal('hide');
    this.typeRegisterService.changeMessage("CLIENT");
    this.router.navigate(['register']);

  }

  registerProvider(){
    $('#modalRegister').modal('hide');
    this.typeRegisterService.changeMessage("PROVIDER");
    this.router.navigate(['register']);

  }

  back(){
    this.serviceProvider.changeMessage(null);
    this.location.back();
  }


  
}