import { Component,OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {MessageService} from './../../services/messageServices/message.service';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {User} from './../../model/user';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { MenusService} from './../../services/menusServices/menus.service';
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
import { MenuService } from '../../services/menuService/menu.service';
declare var $:any;
@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {
  menu;
  currency:String;
  
  constructor(public menuService: MenuService, private router:Router){
  }

  ngOnInit(){
    $('#login').hide();
    $('#register').hide();
     this.menuService.currentMessage.subscribe(menu=>this.menu=menu);

  }
}