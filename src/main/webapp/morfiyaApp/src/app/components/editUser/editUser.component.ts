import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import {UserData} from './../../model/userData';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'editUser',
  templateUrl: './editUser.component.html',
  styleUrls: ['./editUser.component.css']
})
export class EditUserComponent {
  user:User;
  idUser:string;
  userName : string;
  userData : UserData;
  surname : string;
  cuit : string;
  mail : string;
  password : string;
  street: string;
  numberStreet: number;
  floor: number;
  locality : string;
  length: number;
  latitude: number;
  telephoneNumber :number;
  areaCode : number;
  countryCode: number;

  constructor(public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService){
  }

  ngOnInit() {
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.getUserData();
    
  }

  getUserData(){
    this.userService.getUserData(this.user.id).subscribe(data =>this.resultUserData(data));
  }
  
  resultUserData(data){
    this.userData = Object.assign(new UserData,data);
    this.userName = this.userData.name
    this.surname = this.userData.surname;
    this.cuit = this.userData.cuit;
    this.mail = this.userData.mail;
    this.password = this.userData.password;
    this.street = this.userData.address.street;
    this.numberStreet = this.userData.address.numberStreet;
    this.floor = this.userData.address.floor;
    this.locality =  this.userData.address.locality;
    this.length = this.userData.address.mapPosition.length;
    this.latitude = this.userData.address.mapPosition.latitude;
    this.areaCode = this.userData.telephone.areaCode;
    this.telephoneNumber = this.userData.telephone.localNumber;
    this.password = this.userData.password;
    this.countryCode = this.userData.telephone.countryCode;

  }

  updateUser(){
    this.userService.updateUser(this.idUser,this.password,this.countryCode,this.areaCode,this.telephoneNumber,this.locality,this.street,this.numberStreet,this.floor,this.latitude,this.length)
    .subscribe(data => 
      {this.resultUpdate(data.status)},
      err => {
       this.alertService.error(this.translate.instant(JSON.parse(err._body).code.toString()));
       setInterval (() => {
         this.alertService.clear();
       }, 2000)
     });

  }

  resultUpdate(status){
    if(status == 200){
      this.alertService.success(this.translate.instant("1000"));
      setInterval (() => {
        this.alertService.clear();
      }, 2000);
      this.getUserData();
    }
  }
}