import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {User} from './../../model/user';
@Injectable()
export class MessageService {
    private messageSource = new BehaviorSubject<User>(new User);
    currentMessage = this.messageSource.asObservable();
    constructor() { }
    changeMessage(message: User) {
      this.messageSource.next(message)
    }
}
