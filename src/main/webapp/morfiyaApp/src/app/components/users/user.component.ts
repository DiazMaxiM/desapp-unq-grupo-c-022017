import { Component } from '@angular/core';
import {ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  @ViewChild('closeBtn') closeBtn: ElementRef;
  
  constructor(private router:Router){}

  backToHome(){
    this.closeModal();
    this.router.navigate(['home']);
  }

  //call this wherever you want to close modal
    private closeModal(): void {
        this.closeBtn.nativeElement.click();
  }
}