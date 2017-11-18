import { Component,OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {MessageService} from './../../services/messageServices/message.service';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {User} from './../../model/user';
import { UtilsService} from './../../services/utilsServices/utils.service';
import { MenusService} from './../../services/menusServices/menus.service';
declare var $:any;
@Component({
  selector: 'menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})

export class MenusComponent implements OnInit {
  constructor(private router:Router,private menusService: MenusService,private translate: TranslateService,private utilsServices: UtilsService){
  }

  selectedValue: String
  searchs
  categories = [{name: "name" }, {name: "locality"}, {name: "price"},{name: "category"}];
  cotegorySearch = this.categories[0];
  listOfElements;
  searchValueOfList='';
  localities;
  categoriesJson;

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
        this.hideList();
      }
    }

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

  search(){
    console.log(this.selectedValue);
    this.menusService.getMenus().subscribe(menus =>console.log(menus));
  }

  ngOnInit(){
    this.utilsServices.localities().subscribe(data =>this.resultLocalities(data))
    this.utilsServices.categories().subscribe(data =>this.resultCategories(data))
  }

  resultLocalities(data){
    console.log(data._body);
    this.localities= JSON.parse(data._body);
  }

  resultCategories(data){
    console.log(data._body);
    this.categoriesJson= JSON.parse(data._body);
  }
}