import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
@Injectable()
export class MessageService {
    private messageSource = new BehaviorSubject<JSON>(null);
    currentMessage = this.messageSource.asObservable();
    constructor() { }
    changeMessage(message) {
      this.messageSource.next(message)
    }
}
