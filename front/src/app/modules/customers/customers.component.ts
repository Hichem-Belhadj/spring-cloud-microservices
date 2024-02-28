import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../core/services/api.service";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.scss'
})
export class CustomersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email'];
  customers: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getCustomers().subscribe({
      next: (customers: any) => this.customers = customers,
      error: err => console.log(err)
    });
  }

}
