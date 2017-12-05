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
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
import { MenuService } from '../../services/menuService/menu.service';
import { PurchaseService } from '../../services/purchaseService/purchase.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerI18n} from '@ng-bootstrap/ng-bootstrap';
import { I18n,CustomDatepickerI18n } from '../../services/calendarLanguage/customDatepickerI18n.service';
import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';
import {NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import { LanguageService} from './../../services/languageService/languageService.service';
declare var $:any;
import { NgModule } from '@angular/core';
import { Order } from '../../model/order';
@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {
  user;
  idUser;
  idMenu : string;
  balance : string;
  idProvider = 2;
  client = null;
  provider = null;
  services;
  form: FormGroup;
  menu;
  currency:String;
  total=0;
  startDeliveryTime;
  endDeliveryTime;
  dateDelivery;
  scores;
  

  constructor(public purchaseService: PurchaseService,public languague:LanguageService ,private parserFormatter: NgbDateParserFormatter,public menuService: MenuService,public listMenusService:ListMenusService,private utilsServices: UtilsService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private providerService: ProviderService,private formBuilder: FormBuilder){
  }

  ngOnInit() {
    $('#login').hide();
    $('#register').hide();
    $('#back').show();
    this.languague.currentMessage.subscribe(message =>this.currency=message);
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.form = this.formBuilder.group({
      numberOfMenusToOrder:[null,[Validators.required,Validators.min(1)]],
      typeOfDelivery:[null,[Validators.required]],
      dateOfDelivery:[null,[Validators.required]],
      startDeliveryTime:[null,[Validators.required]],
      endDeliveryTime:[null,[Validators.required]]
    });
    this.menuService.currentMessage.subscribe(menu=>this.resultData(menu));
  
  }

  onChangeNumberOfMenusToOrder(numberOfMenusToOrder){
    if(numberOfMenusToOrder>=this.menu.firstMinimumNumberOfMenusToBuy && numberOfMenusToOrder < this.menu.secondMinimumNumberOfMenusToBuy ){
      this.total= numberOfMenusToOrder * this.menu.firstminimumPriceOfMenusToBuy.value;
    }else{
      if(numberOfMenusToOrder>=this.menu.secondMinimumNumberOfMenusToBuy){
        this.total= numberOfMenusToOrder * this.menu.secondMinimumPriceOfMenusToBuy.value; 
      }else{
        this.total= numberOfMenusToOrder * this.menu.menuPrice.value;
      }
    }

  }

  onChangeDeliveyType(typeDelivery){
    if(typeDelivery=="HOMEDELIVERY"){
      this.total = this.total + this.menu.menuDeliveryPrice.value;
    }
  }

  resultData(data){
    this.menu=data;
    this.idMenu= this.menu.id;
  }

  onChangeStartTimeDelivery(time){
    if(time!==null){
      this.startDeliveryTime= time.hour +":" + time.minute;
    }
  }

  onChangeEndTimeDelivery(time){
    if(time!==null){
      this.endDeliveryTime= time.hour +":" + time.minute;
    }
  }

  onChangDateDelivery(date){
   
    this.dateDelivery= date.year+"-"+date.month+"-"+date.day;
  }

  displayFieldCss(field: string) {
    return {
      'is-invalid': this.isFieldValid(field)
    }}

  isFieldValid(field: string) {
    return !this.form.get(field).valid && this.form.get(field).touched;
  }

  buyMenu(){
    if(this.form.valid){
        var order = new Order();
        order.client= this.idUser;
        order.provider= this.idProvider;
        order.menu = this.idMenu;
        order.countMenu = this.form.value.numberOfMenusToOrder;
        order.typeDelivery = this.form.value.typeOfDelivery;
        order.startTimeDelivery= this.startDeliveryTime;
        order.endTimeDelivery = this.endDeliveryTime;
        order.dateDelivery = this.dateDelivery;
         this.purchaseService.newOrder(order).subscribe(data => 
           {data},
         err => {
         }); 

        }
      }

 
}