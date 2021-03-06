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
import { ServiceProvider} from './services/serviceProvider/serviceProvider.service';
import { ListMenusService} from './services/listMenusService/listMenus.service';
import { ProviderService} from './services/providerService/provider.service';
import { PurchaseService} from './services/purchaseService/purchase.service';
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
import { MenuOfferdComponent } from './components/menuOfferd/menuOfferd.component';
import {FieldErrorDisplayComponent} from './components/field-error-display/field-error-display.component';
import { ServicesProviderComponent } from './components/servicesProvider/servicesProvider.component';
import { I18n,CustomDatepickerI18n } from './services/calendarLanguage/customDatepickerI18n.service';
import { AuthService } from './auth/auth.service';
import { Http, RequestOptions } from '@angular/http';
import { AuthHttp, AuthConfig } from 'angular2-jwt';
import { ProfileComponent } from './profile/profile.component';
import { ServiceComponent } from './components/service/service.component';
import { CallbackComponent } from './callback/callback.component';
import { CurrencyFormat } from './pipes/currencyFormat.pipe';
import { CurrencyPipe } from '@angular/common';
import {NgxPaginationModule} from 'ngx-pagination';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbDatepickerI18n} from '@ng-bootstrap/ng-bootstrap';
import { NgbDatepickerConfig, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateFRParserFormatter } from "./services/calendarLanguage/ngb-date-fr-parser-formatter"

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http);
}
export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig(), http, options);
}

@NgModule({
  declarations: [
    ServiceComponent,
    CurrencyFormat,
    AppComponent,
    HomeComponent,
    UserComponent,
    EditUserComponent,
    AlertComponent, 
    MenusComponent,
    MenuOfferdComponent,
    FieldErrorDisplayComponent,
    RegisterComponent,
    HeaderComponent,
    ServicesProviderComponent,
    CallbackComponent,
    SearchMenuComponent,
    OrderComponent,
    CheckBalanceComponent,
    ProfileComponent        
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserAnimationsModule,
    BrowserModule,
    NgxPaginationModule,
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

  providers: [ServiceProvider,PurchaseService,{provide: NgbDateParserFormatter, useClass: NgbDateFRParserFormatter},I18n,CustomDatepickerI18n,{provide: NgbDatepickerI18n, useClass: CustomDatepickerI18n},MenuService,ListMenusService,UserService,AlertService,MessageService,TypeRegisterService,ProviderService, UtilsService,LanguageService,AuthService,MenusService,NumberValidatorsService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
