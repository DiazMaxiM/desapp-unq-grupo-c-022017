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
import { Directive, forwardRef, Attribute,OnChanges, SimpleChanges,Input } from '@angular/core';
import { NG_VALIDATORS,Validator,AbstractControl,ValidatorFn } from '@angular/forms';

declare var $:any;

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

  public model:any = {};
  private user : User = new User();
  form: FormGroup;
  submitted = false;
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
       this.user= Object.assign(new User,JSON.parse(data._body));
       this.sendData();
       $('#modalLogin').modal('hide');
       $('#modalRegister').modal('hide');
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

  resetForm(){
    this.form.reset();
  }


  
}