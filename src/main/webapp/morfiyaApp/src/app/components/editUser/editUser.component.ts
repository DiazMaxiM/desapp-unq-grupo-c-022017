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
import { UtilsService} from './../../services/utilsServices/utils.service';
import {FormGroup,FormBuilder,Validators, FormControl} from '@angular/forms';
import { AuthService } from '../../auth/auth.service';

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
  localities;

  constructor(private formBuilder: FormBuilder,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private utilsServices: UtilsService, public auth:AuthService){
    this.auth.handleAuthentication()    
    console.log(this.auth.getUser())
  }
  
    ngOnInit() {
      this.utilsServices.localities().subscribe(data =>this.resultLocalities(data));
      this.messageService.currentMessage.subscribe(message => this.user = message);
      this.idUser = this.user.id;
      this.getUserData();
  
      this.form = this.formBuilder.group({
        name:[null,[Validators.required]],
        surname:[null,[Validators.required]],
        cuit:[null,[Validators.required]],
        email:[null,[Validators.required,Validators.email]],
        street:[null,[Validators.required]],
        number:[null,[Validators.required]],
        floor:['0',[Validators.required]],
        countryCode:['54',[Validators.required]],
        areaCode:['011',[Validators.required]],
        localNumber:[null,[Validators.required]],
        locality:[null,[Validators.required]],
        length:[null,[Validators.required]],
        latitude:[null,[Validators.required]],
        password:[null,[Validators.required]],
        repassword:[null,[Validators.required]]        
      },{validator: this.checkIfMatchingPasswords('password', 'repassword')});

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

    validateAllFormFields(formGroup: FormGroup) {
      Object.keys(formGroup.controls).forEach(field => {
        const control = formGroup.get(field);
        if (control instanceof FormControl) {
          control.markAsTouched({ onlySelf: true });
        } else if (control instanceof FormGroup) {
          this.validateAllFormFields(control);
        }
      });
    }

    displayFieldCss(field: string) {
      return {
        'is-invalid': this.isFieldValid(field)
      };
    }

    isFieldValid(field: string) {
      return !this.form.get(field).valid && this.form.get(field).touched;
    }

    checkIfMatchingPasswords(passwordKey: string, passwordConfirmationKey: string) {
      return (group: FormGroup) => {
        let passwordInput = group.controls[passwordKey],
            passwordConfirmationInput = group.controls[passwordConfirmationKey];
        if (passwordInput.value !== passwordConfirmationInput.value) {
          return passwordConfirmationInput.setErrors({notEquivalent: true})
        }
      }
    }
    

    updateUser(){
      if(this.form.valid){
        this.userService.updateUser(this.idUser,this.form.value.password,this.form.value.countryCode,this.form.value.areaCode,this.form.value.localNumber,this.form.value.locality,this.form.value.street, this.form.value.number,this.form.value.floor,this.form.value.latitude,this.form.value.length)
        .subscribe(data => 
          {this.resultUpdate(data.status)},
          err => {
           this.showError(this.translate.instant(JSON.parse(err._body).code.toString()));
         });
      }else{
        this.validateAllFormFields(this.form);
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

    resultLocalities(data){
      this.localities= JSON.parse(data._body);
    }
  
}