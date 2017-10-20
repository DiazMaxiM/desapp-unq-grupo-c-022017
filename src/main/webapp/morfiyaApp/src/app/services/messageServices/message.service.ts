import { Injectable } from '@angular/core';
import {User} from './../../model/user';
@Injectable()
export class MessageService {
    private message:User;
 
    sendMessage(message: User) {
        this.message = message;
    }
 
    getMessage() {
       return this.message;
    }
}
