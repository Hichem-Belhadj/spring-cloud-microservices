import { Component } from '@angular/core';
import {ApiService} from "../../core/services/api.service";

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.scss'
})
export class AccountsComponent {
  displayedColumns: string[] = ['id', 'balance', 'type', 'currency', 'customerName'];
  accounts: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getAccounts().subscribe({
      next: (accounts: any) => this.accounts = accounts,
      error: err => console.log(err)
    });
  }
}
