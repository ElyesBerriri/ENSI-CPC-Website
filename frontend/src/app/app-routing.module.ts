import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { ProblemsComponent } from './problems/problems.component';
import { ProblemComponent } from './problem/problem.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'home', component: HomeComponent},
  {path:'admin', component: AdminComponent},
  {path: 'user', component: UserComponent},
  {path:'problems',component:ProblemsComponent},
  {path:'problem/:id' ,component:ProblemComponent},
  {path: '**',  redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
