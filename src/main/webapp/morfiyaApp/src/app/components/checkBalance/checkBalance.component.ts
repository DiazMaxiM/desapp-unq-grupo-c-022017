import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {MessageService} from './../../services/messageServices/message.service';
import {ViewChild, ElementRef} from '@angular/core';
import {User} from './../../model/user';

@Component({
  selector: 'checkBalance',
  templateUrl: './checkBalance.component.html',
  styleUrls: ['./checkBalance.component.css']
})
export class CheckBalanceComponent implements OnInit {
  user: User
  idUser : String
  balance : String
  @ViewChild('closeBtn') closeBtn: ElementRef;
  constructor(public userService: UserService, public messageService : MessageService){
  }

  ngOnInit() {
    this.user = this.messageService.getMessage();
    this.idUser = this.user.id;
    this.checkbalance();
  }

  checkbalance(){
    this.userService.balance(this.idUser).subscribe(data => this.balance=data);
  }

  addBalance(){
    this.userService.addBalance(this.idUser,"5");
    this.checkbalance();
    this.closeModal();
    
  }

   //call this wherever you want to close modal
   private closeModal(): void {
    this.closeBtn.nativeElement.click();
}

  
}