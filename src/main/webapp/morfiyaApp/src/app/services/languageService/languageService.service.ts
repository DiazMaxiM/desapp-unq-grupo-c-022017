import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
@Injectable()
export class LanguageService {
  
    private messageSource = new BehaviorSubject<String>("");
    currentMessage = this.messageSource.asObservable();
    constructor() { }
    changeMessage(message: string) {
      this.messageSource.next(message)
    }
}