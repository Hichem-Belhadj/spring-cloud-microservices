import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./shared/home/home.component";

const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "accounts",
    loadChildren: () => import('./modules/accounts/accounts.module').then(m => m.AccountsModule)
  },
  {
    path: "customers",
    loadChildren: () => import('./modules/customers/customers.module').then(m => m.CustomersModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
