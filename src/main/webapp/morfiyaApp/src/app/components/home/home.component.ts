import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent  {
  public model:any = {};
  private idUser: number;
   @ViewChild('closeBtn') closeBtn: ElementRef;
  
  changeLang(lang: string) {
    this.translate.use(lang);
  }
  constructor(public userService: UserService,private router:Router,private translate: TranslateService){
    translate.addLangs(['en', 'es','it']);
    translate.setDefaultLang('es');
    translate.use('es');
  }

  async logginUser(){
    this.idUser = await this.userService.loggingUser(this.model.email,this.model.password);
    this.closeModal();
    this.router.navigate(['users']);
  }

  //call this wherever you want to close modal
    private closeModal(): void {
        this.closeBtn.nativeElement.click();
  }
}