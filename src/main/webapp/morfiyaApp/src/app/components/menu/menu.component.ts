import { Component,OnInit } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { ListMenusService} from './../../services/listMenusService/listMenus.service';
import { MenuService } from '../../services/menuService/menu.service';

@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  menu;
  constructor(public menuService: MenuService, private router:Router){
  }

  ngOnInit(){
     this.menuService.currentMessage.subscribe(menu=>this.menu=menu);

  }

}