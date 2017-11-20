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
declare var $:any;
@Component({
  selector: 'menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})

export class MenusComponent implements OnInit {
  constructor(public listMenuService: ListMenusService,private router:Router,private menusService: MenusService,private translate: TranslateService,private utilsServices: UtilsService){
  }

  menus;

  ngOnInit(){
    this.listMenuService.currentMessage.subscribe(data=>this.menus=data);
  }

  viewMenu(){
    this.router.navigate(['menu']);
  }

  updateSearch(){
    this.router.navigate(['home']);
  }
}