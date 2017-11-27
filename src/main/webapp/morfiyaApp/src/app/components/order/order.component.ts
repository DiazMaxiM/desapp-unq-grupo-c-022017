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
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
import { MenuService } from '../../services/menuService/menu.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerI18n} from '@ng-bootstrap/ng-bootstrap';
import { I18n,CustomDatepickerI18n } from '../../services/calendarLanguage/customDatepickerI18n.service';
import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';
import {NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import { LanguageService} from './../../services/languageService/languageService.service';
declare var $:any;
import { NgModule } from '@angular/core';
@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {
  user: User
  idUser : string
  balance : String
  services;
  form: FormGroup;
  menu;
  currency:String;
  total=0;

  constructor(public languague:LanguageService ,private parserFormatter: NgbDateParserFormatter,public menuService: MenuService,public listMenusService:ListMenusService,private utilsServices: UtilsService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private providerService: ProviderService,private formBuilder: FormBuilder){
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
    this.menuService.currentMessage.subscribe(menu=>this.menu=menu);
  }



  displayFieldCss(field: string) {
    return {
      'is-invalid': this.isFieldValid(field)
    }}

  isFieldValid(field: string) {
    return !this.form.get(field).valid && this.form.get(field).touched;
  }

  onChangeDate(date){
    var stringDate=this.parserFormatter.format(date);
    console.log(stringDate);
  }
}