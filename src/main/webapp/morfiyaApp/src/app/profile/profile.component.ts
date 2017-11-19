import { Component, OnInit } from '@angular/core';
import { AuthService } from './../auth/auth.service';
import { UserService } from './../services/userServices/user.service';
import {MessageService} from './../services/messageServices/message.service';
import {Router} from '@angular/router';
import {User} from './../model/user';
import {TranslateService} from '@ngx-translate/core';
import {TypeRegisterService} from './../services/typeRegisterService/typeRegister.service';
declare var $:any;

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile: any;
  user:any;

  constructor(public translate:TranslateService,public typeRegisterService: TypeRegisterService,public router:Router,public messageService: MessageService,public auth: AuthService,public userService: UserService) { }

  ngOnInit() {
    $('#login').hide();
    $('#register').hide();
    if (this.auth.userProfile) {
      this.profile = this.auth.userProfile;
      this.showDataOrRegisterUser();
     
    } else {
      this.auth.getProfile((err, profile) => {
        this.profile = profile;
        this.showDataOrRegisterUser();
      });
    }
  }

  showDataOrRegisterUser(){
    this.userService.loginAuth0(this.profile.nickname+'@gmail.com').subscribe(data => 
      {this.result(data)},
      err => {
        this.showRegisterUser();
     });

  }

  showRegisterUser(){
      $("#profileUser").show();

  }

  result(data){
       this.user= Object.assign(new User,JSON.parse(data._body));
       this.sendData();
       this.auth.logout();
       this.router.navigate(['users']);
  }

  private sendData(): void {
    this.messageService.changeMessage(this.user);
 } 
}
