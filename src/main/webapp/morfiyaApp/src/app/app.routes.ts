import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/users/user.component';
import { EditUserComponent } from './components/editUser/editUser.component';
import { CheckBalanceComponent } from './components/checkBalance/checkBalance.component';
import { MenusComponent } from './components/menus/menus.component';
import { MenuComponent } from './components/menu/menu.component';
import { RegisterComponent } from './components/register/register.component';
import { ServicesProviderComponent } from './components/servicesProvider/servicesProvider.component';
import { ProfileComponent } from './profile/profile.component';
import { CallbackComponent } from './callback/callback.component';

export const appRoutes: Routes = [
    { path: '', redirectTo:'/home', pathMatch:'full'},
    { path: 'profile', component: ProfileComponent },
    { path: 'callback', component: CallbackComponent },
    { path: 'home', component: HomeComponent},
    { path: 'register', component: RegisterComponent},
    { path: 'menus', component: MenusComponent},
    { path: 'menu', component: MenuComponent},    
    { path: 'users', component: UserComponent,
    children: [
      {
        path: 'edit',
        component: EditUserComponent
      },
      {
        path: 'balance',
        component: CheckBalanceComponent
      },
      {
        path: 'services',
        component: ServicesProviderComponent
      },
    ]},
    // otherwise redirect to home
    { path: '**', redirectTo: '' },



];