import { Component,OnInit } from '@angular/core';
import { UserService } from './../../services/userServices/user.service';
import {ViewChild, ElementRef} from '@angular/core';
import {MessageService} from './../../services/messageServices/message.service';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {User} from './../../model/user';
import { UtilsService} from './../../services/utilsServices/utils.service';
declare var $:any;
@Component({
  selector: 'servicesProvider',
  templateUrl: './servicesProvider.component.html',
  styleUrls: ['./servicesProvider.component.css']
})

export class ServicesProviderComponent implements OnInit {
  constructor(private router:Router,private translate: TranslateService,private utilsServices: UtilsService){
  }

  @ViewChild('closeBtn') closeBtn: ElementRef;
  selectedValue: String
  searchs
  categories = [{name: "name" }, {name: "locality"}, {name: "price"},{name: "category"}];
  cotegorySearch = this.categories[0];
  localities;
  locality;

  onChangeObj(typeSearch) {
    this.cotegorySearch = typeSearch;
    this.showTypeSearch(typeSearch);
  }

  showTypeSearch(typeSearch){
    if(typeSearch.name=="locality"){
      this.showLocalities();
    }else{
      this.hideLocalities();
    }

  }
  showLocalities(){
    $('#localities').show();
    $('#search').hide();  
  }

  hideLocalities(){
    $('#localities').hide();   
    $('#search').show();      
  }

  search(){
    console.log(this.selectedValue);
  }

  ngOnInit(){
    this.utilsServices.localities().subscribe(data =>this.resultLocalities(data));
  }

  resultLocalities(data){
    this.localities= JSON.parse(data._body);
    this.locality = this.localities[0];
  }
}