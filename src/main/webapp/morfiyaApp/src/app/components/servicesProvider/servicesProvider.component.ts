import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {Router} from '@angular/router';
import { ProviderService} from './../../services/providerService/provider.service';
import {FormGroup,FormBuilder,Validators, FormControl} from '@angular/forms';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { ServiceProvider} from './../../services/serviceProvider/serviceProvider.service';
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
declare var $:any;

@Component({
  selector: 'servicesProvider',
  templateUrl: './servicesProvider.component.html',
  styleUrls: ['./servicesProvider.component.css']
})
export class ServicesProviderComponent implements OnInit {
  user;
  idUser : string
  balance : String
  services;
  form: FormGroup;
  localities:any;
  menus;


  constructor(public serviceProvider:ServiceProvider,public listMenusService:ListMenusService,private utilsServices: UtilsService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private providerService: ProviderService,private formBuilder: FormBuilder){
  }

  ngOnInit() {
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.getServices();
  }

  getServices(){
    this.providerService.getServices(this.idUser).subscribe(data => this.result(data));
  }  

  result(data){
    this.services= JSON.parse(data._body);
  }

  resultLocalities(data){
    this.localities= JSON.parse(data._body);
  }

  showMenus(idService){
    this.providerService.getMenusOfService(idService).subscribe(menus=>this.resultMenus(menus))

  }


  resultMenus(data){
    this.menus= JSON.parse(data._body);
    if(this.menus.length>0){
      this.listMenusService.changeMessage(this.menus);
      this.router.navigate(['menus']);
    }else{
      this.showMenusNotFound();
    }
  }

  showMenusNotFound(){
    $('#modalResult').modal("show");
  }

  addNewService(){
    this.router.navigate(['service']);
  }

  update(service){
    this.serviceProvider.changeMessage(service);
    this.router.navigate(['service']);

  }
}