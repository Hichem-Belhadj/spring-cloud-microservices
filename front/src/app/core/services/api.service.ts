import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private gatewayUrl = 'http://localhost:8888'

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<any> {
    return this.http.get<any>(this.getCustomersApi());
  }

  getAccounts(): Observable<any> {
    return this.http.get<any>(this.getAccountsApi());
  }

  private getCustomersApi() {
    return this.gatewayUrl + '/CUSTOMER-SERVICE/api/v1/customers';
  }

  private getAccountsApi() {
    return this.gatewayUrl + '/ACCOUNT-SERVICE/api/v1/accounts';
  }
}
