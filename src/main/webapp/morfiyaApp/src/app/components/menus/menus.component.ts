import { Component } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})
export class MenusComponent {
  @ViewChild('closeBtn') closeBtn: ElementRef;
  
  constructor(private router:Router){}

}