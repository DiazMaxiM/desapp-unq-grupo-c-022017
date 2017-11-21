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
import { MenuService} from './../../services/menuService/menu.service';
import { LanguageService} from './../../services/languageService/languageService.service';
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
import {TypeRegisterService} from './../../services/typeRegisterService/typeRegister.service';
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
  user:User=null;
  constructor(public menuService: MenuService,public messageService:MessageService ,public languague:LanguageService ,public listMenuService: ListMenusService,private router:Router,private menusService: MenusService,private translate: TranslateService,private utilsServices: UtilsService){  
  }

  ngOnInit(){
          
    this.listMenuService.currentMessage.subscribe(data=>this.menus=data);
    this.languague.currentMessage.subscribe(message =>this.currency=message);
    this.messageService.currentMessage.subscribe(message => this.resultData(message));
  }
  
  resultData(data){
    this.user=data
    if(this.user.typeUser!=='USER'){
      $('#login').hide();
      $('#register').hide();
    }
  }

  viewMenu(menu){
    this.menuService.changeMessage(menu);

  }

  scrollTopPage(){
    window.scrollTo(0, 0);
  }

  editMenu(menu){

  }

  updateSearch(){
    if(this.user.typeUser=="CLIENT"){
      this.router.navigate(['users/search']);
    }else{
      this.router.navigate(['home']);
    }
  }
}