import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import {appRoutes} from './app.routes'
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { UserComponent } from './components/users/user.component';
import { EditUserComponent } from './components/editUser/editUser.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { CheckBalanceComponent } from './components/checkBalance/checkBalance.component';
import { UserService} from './services/userServices/user.service';
import { ProviderService} from './services/providerService/provider.service';
import { UtilsService} from './services/utilsServices/utils.service';
import { AlertComponent } from './alert/directives/index';
import { AlertService } from './alert/services/index';
import { HttpModule,JsonpModule} from '@angular/http';
import { MessageService} from './services/messageServices/message.service';
import { TypeRegisterService} from './services/typeRegisterService/typeRegister.service';
import { MenusComponent } from './components/menus/menus.component';
import { MenuComponent } from './components/menu/menu.component';
import {FieldErrorDisplayComponent} from './components/field-error-display/field-error-display.component';
import { ServicesProviderComponent } from './components/servicesProvider/servicesProvider.component';
import { AuthService } from './auth/auth.service';
import { CallbackComponent } from './callback/callback.component';


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
    MenusComponent,
    MenuComponent,
    FieldErrorDisplayComponent,
    RegisterComponent,
    HeaderComponent,
    ServicesProviderComponent   ,
    CallbackComponent     
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
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

  providers: [UserService,AlertService,MessageService,TypeRegisterService,ProviderService, UtilsService,AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
