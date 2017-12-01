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
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerI18n} from '@ng-bootstrap/ng-bootstrap';
import { I18n,CustomDatepickerI18n } from '../../services/calendarLanguage/customDatepickerI18n.service';
import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';
import {NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
declare var $:any;

@Component({
  selector: 'menuOfferd',
  templateUrl: './menuOfferd.component.html',
  styleUrls: ['./menuOfferd.component.css']
})
export class MenuOfferdComponent implements OnInit {
  user;
  idUser : string
  balance : String
  services;
  form: FormGroup;
  categories;
  menuEdition=null;

  constructor(private parserFormatter: NgbDateParserFormatter,public menuService: MenuService,public listMenusService:ListMenusService,private utilsServices: UtilsService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private providerService: ProviderService,private formBuilder: FormBuilder){
  }

  ngOnInit() {
    $('#login').hide();
    $('#register').hide();
    $('#back').show();
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.form = this.formBuilder.group({
      name:[null,[Validators.required,Validators.minLength(4),Validators.maxLength(30)]],
      description:[null,[Validators.required,Validators.minLength(20),Validators.maxLength(40)]],
      category:[null,[Validators.required]],
      deliveryPrice:[null,[Validators.required,Validators.min(10),Validators.max(40)]],
      startDateToOfferd:[null,[Validators.required]],
      endDateToOfferd:[null,[Validators.required]],
      startDeliveryTime:[null,[Validators.required]],
      endDeliveryTime:[null,[Validators.required]],
      averageDeliveryTime:[null,[Validators.required]],
      price:[null,[Validators.required]],
      salesPerDay:[null,[Validators.required]],  
      minimumAmount1:[null,[Validators.required,Validators.min(10),Validators.max(70)]],
      priceMinimunAmount1:[null,[Validators.required,Validators.min(0),Validators.max(1000)]],
      minimunAmount2:[null,[Validators.required,Validators.min(40),Validators.max(150)]],
      priceMinimunAmount2:[null,[Validators.required,Validators.min(0),Validators.max(1000)]]      
    });
    this.menuService.currentMessage.subscribe(menu=>this.showData(menu));
    this.utilsServices.categories().subscribe(data =>this.resultCategories(data));
  }

  showData(menu){
    this.menuEdition= menu;
    if(this.menuEdition!=null){
      this.form.setValue({
        'name': this.menuEdition.menuName,
        'description':this.menuEdition.menuDescription,
        'category':this.menuEdition.menuCategory,
        'deliveryPrice':this.menuEdition.menuDeliveryPrice.value,
        'startDateToOfferd':{ 
          day:  this.menuEdition.startDateOfferMenu[1],
          month: this.menuEdition.startDateOfferMenu[2],
          year: this.menuEdition.startDateOfferMenu[0]
        },
        'endDateToOfferd':{
          day: this.menuEdition.endDateOfferMenu[1],
          month: this.menuEdition.endDateOfferMenu[2],
          year: this.menuEdition.endDateOfferMenu[0]
        } ,
        'startDeliveryTime':{hour: this.menuEdition.deliveryTimesMenus[0].startHours.hourOfDay,minute: this.menuEdition.deliveryTimesMenus[0].startHours.minuteOfHour},
        'endDeliveryTime': {hour: this.menuEdition.deliveryTimesMenus[0].endHours.hourOfDay,minute: this.menuEdition.deliveryTimesMenus[0].endHours.minuteOfHour},
        'averageDeliveryTime':this.menuEdition.averageDeliveryTimeOfMenu,
        'price': this.menuEdition.menuPrice.value,
        'salesPerDay': this.menuEdition.maximumNumberOfMenusSalesPerDay,
        'minimumAmount1': this.menuEdition.firstMinimumNumberOfMenusToBuy,
        'priceMinimunAmount1':this.menuEdition.firstminimumPriceOfMenusToBuy.value,
        'minimunAmount2': this.menuEdition.secondMinimumNumberOfMenusToBuy,
        'priceMinimunAmount2':this.menuEdition.secondMinimumPriceOfMenusToBuy.value 
      });
    }  
  }

  displayFieldCss(field: string) {
    return {
      'is-invalid': this.isFieldValid(field)
    }}

  isFieldValid(field: string) {
    return !this.form.get(field).valid && this.form.get(field).touched;
  }

  resultCategories(data){
    this.categories= JSON.parse(data._body);
  }

  onChangeDate(date){
    var stringDate=this.parserFormatter.format(date);
    console.log(stringDate);
  }
}