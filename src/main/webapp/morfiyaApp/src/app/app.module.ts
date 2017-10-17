import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import {appRoutes} from './app.routes'
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { UserComponent } from './components/users/user.component';
import { EditUserComponent } from './components/editUser/editUser.component';
import { CheckBalanceComponent } from './components/checkBalance/checkBalance.component';
import { UserService} from './services/userServices/user.service';
import { AlertComponent } from './alert/directives/index';
import { AlertService } from './alert/services/index';

import { HttpModule,JsonpModule} from '@angular/http';
import { MessageService} from './services/messageServices/message.service';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    EditUserComponent,
    CheckBalanceComponent,
    AlertComponent,    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      }}),
      RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
      ],

  providers: [UserService,AlertService,MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
