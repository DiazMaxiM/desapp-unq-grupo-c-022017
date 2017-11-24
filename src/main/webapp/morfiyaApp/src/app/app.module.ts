import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SearchMenuComponent } from './components/searchMenu/searchMenu.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import {appRoutes} from './app.routes'
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { UserComponent } from './components/users/user.component';
import { EditUserComponent } from './components/editUser/editUser.component';
import { OrderComponent } from './components/order/order.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { CheckBalanceComponent } from './components/checkBalance/checkBalance.component';
import { UserService} from './services/userServices/user.service';
import { ListMenusService} from './services/listMenusService/listMenus.service';
import { ProviderService} from './services/providerService/provider.service';
import { LanguageService} from './services/languageService/languageService.service';
import { UtilsService} from './services/utilsServices/utils.service';
import { MenusService} from './services/menusServices/menus.service';
import { MenuService} from './services/menuService/menu.service';
import { NumberValidatorsService} from './services/numberValidatorsService/numberValidators.service';
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
import { Http, RequestOptions } from '@angular/http';
import { AuthHttp, AuthConfig } from 'angular2-jwt';
import { ProfileComponent } from './profile/profile.component';
import { CallbackComponent } from './callback/callback.component';
//import { CurrencyFormat } from './pipes/currencyFormat.pipe';
import {NgxPaginationModule} from 'ngx-pagination';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http);
}
export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig(), http, options);
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    EditUserComponent,
    //CheckBalanceComponent,
    AlertComponent, 
    MenusComponent,
    MenuComponent,
    FieldErrorDisplayComponent,
    RegisterComponent,
    HeaderComponent,
    ServicesProviderComponent   ,
    CallbackComponent,
    //CurrencyFormat,
    SearchMenuComponent,
    OrderComponent,
    ProfileComponent        
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    FormsModule,
    CheckBalanceComponent,
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

  providers: [MenuService,ListMenusService,UserService,AlertService,MessageService,TypeRegisterService,ProviderService, UtilsService,LanguageService,AuthService,MenusService,NumberValidatorsService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
