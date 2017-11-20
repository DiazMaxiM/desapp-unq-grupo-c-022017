import { Component,OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {MessageService} from './../../services/messageServices/message.service';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {User} from './../../model/user';
import { CurrencyPipe } from '@angular/common';
import { CurrencyFormat } from './../../pipes/currencyFormat.pipe';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { MenusService} from './../../services/menusServices/menus.service';
import { LanguageService} from './../../services/languageService/languageService.service';
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
declare var $:any;
declare var currency: string;
@Component({
  selector: 'menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})

export class MenusComponent implements OnInit {
  p: number = 1;
  menus;
  currency:String;
  constructor(public languague:LanguageService ,public listMenuService: ListMenusService,private router:Router,private menusService: MenusService,private translate: TranslateService,private utilsServices: UtilsService){
  }

  

  ngOnInit(){
    this.listMenuService.currentMessage.subscribe(data=>this.menus=data);
    this.languague.currentMessage.subscribe(message =>this.currency=message);
  }

  viewMenu(){
    this.router.navigate(['menu']);
  }

  updateSearch(){
    this.router.navigate(['home']);
  }
}