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
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  constructor(public listMenuService: ListMenusService,private router:Router,private menusService: MenusService,private translate: TranslateService,private utilsServices: UtilsService){
  }

  selectedValue: String
  searchs
  categories = [{name: "name" }, {name: "locality"}, {name: "price"},{name: "category"},{name: "allMenus"}];
  cotegorySearch = this.categories[0];
  listOfElements;
  searchValueOfList='';
  localities;
  categoriesJson;
  menus;

  onChangeObj(typeSearch) {
    this.cotegorySearch = typeSearch;
    this.showTypeSearch(typeSearch);
  }

  showTypeSearch(typeSearch){
    if(typeSearch.name=="locality"){
      this.showList(this.localities);
    }else{
      if(typeSearch.name=='category'){
         this.showList(this.categoriesJson);
      }else{
         if(typeSearch.name=='allMenus'){
            $('#searchContainer').hide();
            this.showAllMenus();
         }else{
           this.hideList();
         }
      }
    }

  }

  showAllMenus(){
    this.menusService.getMenus().subscribe(menus =>this.resultMenus(menus));
  }

  resultMenus(data){
    this.menus= JSON.parse(data._body);
    if(this.menus.length>0){
      this.listMenuService.changeMessage(this.menus);
      this.router.navigate(['menus']);
    }else{
      this.showMenus();
    }
  }
  
  showMenus(){
    $('#nonResult').modal("show");
  }

  showList(list:any){
    $('#listToSelector').show();
    this.listOfElements=list;
    this.searchValueOfList=list[0];  
    $('#search').hide();  
  }

  hideList(){
    $('#listToSelector').hide();   
    $('#search').show();    
  }


  ngOnInit(){
    this.utilsServices.localities().subscribe(data =>this.resultLocalities(data))
    this.utilsServices.categories().subscribe(data =>this.resultCategories(data))
  }

  resultLocalities(data){
    this.localities= JSON.parse(data._body);
  }

  resultCategories(data){
    this.categoriesJson= JSON.parse(data._body);
  }


  


}