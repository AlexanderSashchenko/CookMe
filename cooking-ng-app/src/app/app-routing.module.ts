import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyProfileComponent} from "./components/my-profile/my-profile.component";
import {IngredientsComponent} from "./components/ingredients/ingredients.component";
import {RecipesComponent} from "./components/recipes/recipes.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'my-profile',
    component: MyProfileComponent
  },
  {
    path: 'ingredients',
    component: IngredientsComponent
  },
  {
    path: 'recipes',
    component: RecipesComponent
  },
  {
    path: '',
    component: MyProfileComponent,
    pathMatch: 'full'
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
