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
  selector: 'editUser',
  templateUrl: './editUser.component.html',
  styleUrls: ['./editUser.component.css']
})
export class EditUserComponent implements OnInit {
  form;
  user:User;
  idUser:string;
  userName : string;
  userData : UserData;
  mensaje :String;

  constructor(public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService){
  }
  
    ngOnInit() {
      
      this.messageService.currentMessage.subscribe(message => this.user = message);
      this.idUser = this.user.id;
      this.getUserData();
  
      this.form = new ValidationManager({
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
  
    getUserData(){
      this.userService.getUserData(this.user.id).subscribe(data =>this.resultUserData(data));
    }
    
    resultUserData(data){
      this.userData = Object.assign(new UserData,data);
      this.form.setValue({
        'name': this.userData.name,
        'surname':this.userData.surname,
        'email': this.userData.mail,
        'cuit':this.userData.cuit,
        'street':this.userData.address.street,
        'number':this.userData.address.numberStreet,
        'floor':this.userData.address.floor,
        'locality'    : this.userData.address.locality,
        'countryCode' : this.userData.telephone.countryCode,
        'areaCode'    : this.userData.telephone.areaCode,
        'localNumber' : this.userData.telephone.localNumber,
        'length'    : this.userData.address.mapPosition.length,
        'latitude' : this.userData.address.mapPosition.latitude,
        "password":this.userData.password,
        "repassword":this.userData.password
      });
  
    }

    updateUser(){
      if(this.form.isValid()){
        this.userService.updateUser(this.idUser,this.form.getValue('password'),this.form.getValue('countryCode'),this.form.getValue('areaCode'),this.form.getValue('localNumber'),this.form.getValue('locality').toUpperCase(),this.form.getValue('street'),this.form.getValue('number'),this.form.getValue('floor'),this.form.getValue('latitude'),this.form.getValue('length'))
        .subscribe(data => 
          {this.resultUpdate(data.status)},
          err => {
           this.showError(this.translate.instant(JSON.parse(err._body).code.toString()));
         });
      }else{
        this.showError(this.translate.instant("1004"));
      }
  
    }
  
    resultUpdate(status){
      if(status == 200){
        this.alertService.clear();
        this.alertService.success(this.translate.instant("1000"));
        this.showModal(this.translate.instant("1000"));
        this.getUserData();
      }
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