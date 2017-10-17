import { Injectable } from '@angular/core';
 
@Injectable()
export class MessageService {
    private message:any;
 
    sendMessage(message: any) {
        this.message = message;
    }
 
    getMessage() {
       return this.message;
    }
}
