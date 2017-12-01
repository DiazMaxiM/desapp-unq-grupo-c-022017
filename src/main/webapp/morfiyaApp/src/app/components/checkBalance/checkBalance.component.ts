import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {Router} from '@angular/router';
import {Input,Output} from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { LanguageService} from './../../services/languageService/languageService.service';
import { CurrencyFormat } from './../../pipes/currencyFormat.pipe';
import { NgModule } from '@angular/core';

declare var $:any;
declare var currency: string;


@Component({
  selector: 'checkBalance',
  templateUrl: './checkBalance.component.html',
  styleUrls: ['./checkBalance.component.css'],
})

export class CheckBalanceComponent implements OnInit {
  user;
  idUser : String
  balance : String  
  value : number = 0;
  currency:String;

  constructor(public languague: LanguageService,public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService,private utilsServices: UtilsService){
  	
  }

  ngOnInit() {
    this.languague.currentMessage.subscribe(message =>this.currency=message);
    this.messageService.currentMessage.subscribe(message => this.user = message);
    this.idUser = this.user.id;
    this.checkbalance();
  }

  checkbalance(){
    this.userService.balance(this.idUser).subscribe(data => this.balance=data);
  }

  addBalance(){
    if(this.isValidValue()){
      this.userService.addBalance(this.idUser,this.value).subscribe(data => 
        {this.resultBalance(data.status)},
        err => {
         this.alertService.error(this.translate.instant("1002"));
         setInterval (() => {
           this.alertService.clear();
         }, 2000)
       });
    } else{
      this.alertService.error(this.translate.instant("118"));
      setInterval (() => {
        this.alertService.clear();
      }, 2000);
    }
    
  }

  private isValidValue(){
    return this.value > 0;
  }

  private resultBalance(status){
    if(status== 200){
      this.alertService.clear();
      this.alertService.success(this.translate.instant("1001"));
      $('#balanceModal').modal('hide');
      this.clearValue();
      this.checkbalance()
      
    }
  }
  
clearValue(){
    this.value = 0;
  }

}