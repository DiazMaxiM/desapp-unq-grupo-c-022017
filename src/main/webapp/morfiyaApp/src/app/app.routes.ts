import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/users/user.component';

export const appRoutes: Routes = [
    { path: '', redirectTo:'/home', pathMatch:'full'},
    { path: 'home', component: HomeComponent},
    { path: 'users', component: UserComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];