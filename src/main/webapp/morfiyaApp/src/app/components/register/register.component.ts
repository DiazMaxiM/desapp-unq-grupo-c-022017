import { Component, Input, OnInit, AfterViewChecked } from '@angular/core';
import {ValidationManager} from "ng2-validation-manager";
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import {UserData} from './../../model/userData';
import {Router} from '@angular/router';

declare var $:any;

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form;
  user:User;
  idUser:string;
  userName : string;
  userData : UserData;
  mensaje :String;

  constructor(public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService){
  }
  
    ngOnInit() {
      $('#login').hide();
      $('#register').hide();
      $('#backToHome').show();
      this.form = new ValidationManager({
        'name'        : 'required',
        'surname'     : 'required',
        'cuit'        : 'required',
        'email'       : 'required|email',
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


    newUser() {
      if(this.form.isValid()){
        this.userService.register(this.form.getValue('password'),this.form.getValue('name'),this.form.getValue('surname'),this.form.getValue('cuit'),this.form.getValue('email'),this.form.getValue('countryCode'),this.form.getValue('areaCode'),this.form.getValue('localNumber'),this.form.getValue('locality').toUpperCase(),this.form.getValue('street'), this.form.getValue('number'),this.form.getValue('floor'),this.form.getValue('latitude'),this.form.getValue('length')).subscribe(data => 
          {this.result(data)},
        err => {
          this.form.reset();
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
      if(window.screen.width <=767){
        $('#modal-update').modal('show')
      }
    }

    showError(msgError){
      this.alertService.clear();
      this.alertService.error(msgError);
      this.showModal(msgError);
    }
    
}