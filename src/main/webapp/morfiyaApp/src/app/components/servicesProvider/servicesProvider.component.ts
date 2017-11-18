import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import {Router} from '@angular/router';
import { ProviderService} from './../../services/providerService/provider.service';
import {FormGroup,FormBuilder,Validators, FormControl} from '@angular/forms';
import { UtilsService} from './../../services/utilsServices/utils.service';
declare var $:any;

@Component({
  selector: 'checkBalance',
  templateUrl: './servicesProvider.component.html',
  styleUrls: ['./servicesProvider.component.css']
})
export class ServicesProviderComponent implements OnInit {
  user: User
  idUser : string
  balance : String
  services;
  form: FormGroup;
  localities:any;


  constructor(private utilsServices: UtilsService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private providerService: ProviderService,private formBuilder: FormBuilder){
  }

  ngOnInit() {
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.getServices();
    this.startWindow();
    this.utilsServices.localities().subscribe(data =>this.resultLocalities(data));
    this.form = this.formBuilder.group({
      name:[null,[Validators.required]],
      logo:[null,[Validators.required]],
      description:[null,[Validators.required,Validators.minLength(30),Validators.maxLength(200)]],
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
      site:[null,[]],
      localityMax:[null,[Validators.required]]        
    });
  }

  startWindow(){
    if(window.screen.width <=768){
      $('#createNewService').hide();
    }
  }

  displayFieldCss(field: string) {
    return {
      'is-invalid': this.isFieldValid(field)
    }}

  getServices(){
    this.providerService.getServices(this.idUser).subscribe(data => this.result(data));
  }  

  result(data){
    this.services= JSON.parse(data._body);
    console.log(this.services);
  }

  isFieldValid(field: string) {
    return !this.form.get(field).valid && this.form.get(field).touched;
  }

  update(service:any){
    console.log(service);
    this.form.setValue({
      'name': service.serviceName,
      'logo':service.serviceLogo,
      'description':service.serviceDescription,
      'email': service.serviceEmail,
      'street':service.serviceAddress.street,
      'number':service.serviceAddress.numberStreet,
      'floor':service.serviceAddress.floor,
      'locality'    : service.serviceAddress.locality,
      'countryCode' : service.serviceTelephone.countryCode,
      'areaCode'    :service.serviceTelephone.areaCode,
      'localNumber' : service.serviceTelephone.localNumber,
      'length'    : service.serviceAddress.mapPosition.length,
      'latitude' : service.serviceAddress.mapPosition.latitude,
      "site":"",
      "localityMax":service.serviceDeliveryLocations
    });
    $('#createService').hide();
    $('#updateService').show();
  }

  resultLocalities(data){
    this.localities= JSON.parse(data._body);
  }
}