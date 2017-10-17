import { Component, OnInit } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  @ViewChild('closeBtn') closeBtn: ElementRef;
  user :String
  message: any
  idUser : String
  
  constructor(private router:Router,public messageService : MessageService){}
  
  ngOnInit() {
    this.message = this.messageService.getMessage();
    this.user = this.message.name;
    this.idUser = this.message.id;
}
}