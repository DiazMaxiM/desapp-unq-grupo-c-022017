import { Component, OnInit } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {MessageService} from './../../services/messageServices/message.service';
import {User} from './../../model/user';
import {AuthService} from '../../auth/auth.service';
import {TypeRegisterService} from './../../services/typeRegisterService/typeRegister.service';
declare var $:any;

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  user :String
  userCurrent: User;
  idUser : String;
  typeRol: String;
  message:User;
  
  constructor(private router:Router,public messageService : MessageService,private typeRegisterService: TypeRegisterService,public auth: AuthService){

  }
  
  ngOnInit() {
    this.messageService.currentMessage.subscribe(message => this.message = message);
    this.user = this.message.name;
    this.idUser = this.message.id;
    this.typeRol= this.message.typeUser;
    this.showInformation(this.typeRol);
}

backToHome(){
  $('#loginOutModal').modal('hide');
  this.router.navigate(['home']);
}

showInformationClient(){
   $('#orders').show();
   $('#searchMenu').show();

}

showInformation(typeRol:String){
  $('#edit').show();
  $('#balance').show();
  $('#login').hide();
  $('#register').hide();
  $('#close').show();
  if(typeRol=="PROVIDER"){
    this.showInformationProvider()
  }else{
    this.showInformationClient();
  }
}

showInformationProvider(){
  $('#services').show();

}


}