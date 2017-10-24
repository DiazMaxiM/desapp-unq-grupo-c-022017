import { Component, OnInit } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import {User} from './../../model/user';
@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  @ViewChild('closeBtn') closeBtn: ElementRef;
  user :String
  userCurrent: User
  idUser : String
  message:User;
  
  constructor(private router:Router,public messageService : MessageService){}
  
  ngOnInit() {
    this.messageService.currentMessage.subscribe(message => this.message = message);
    this.user = this.message.name;
    this.idUser = this.message.id;
}

backToHome(){
  this.router.navigate(['home']);
}
}