import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AlertService } from '../../alert/services/index';
import {User} from './../../model/user';
import {Router} from '@angular/router';

@Component({
  selector: 'checkBalance',
  templateUrl: './checkBalance.component.html',
  styleUrls: ['./checkBalance.component.css']
})
export class CheckBalanceComponent implements OnInit {
  user: User
  idUser : String
  balance : String
  value : number = 0;
  @ViewChild('closeBtn') closeBtn: ElementRef;
  constructor(public userService: UserService, private router:Router,public messageService : MessageService,public alertService: AlertService,private translate: TranslateService){
  }

  ngOnInit() {
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
      this.alertService.success(this.translate.instant("1001"));
      setInterval (() => {
        this.alertService.clear();
      }, 2000);
      this.checkbalance()
      
    }
  }

   //call this wherever you want to close modal
   private closeModal(): void {
    this.closeBtn.nativeElement.click();
}

clearValue(){
    this.value = 0;
  }

  
}