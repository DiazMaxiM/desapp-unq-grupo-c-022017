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
  
  constructor(private router:Router,public messageService : MessageService){}
  
  ngOnInit() {
    this.userCurrent = this.messageService.getMessage();
    this.user = this.userCurrent.name;
    this.idUser = this.userCurrent.id;
}
}