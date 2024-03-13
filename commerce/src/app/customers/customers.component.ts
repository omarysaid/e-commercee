import { Component } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent {
  customersLists: any[] = [];

  constructor(private service: CustomerService) { }

  ngOnInit() {
    this.getAllCustomers();

  }


  getAllCustomers() {
    this.service.getAllCustomers().subscribe((res) => {
      this.customersLists = res;
    });
  }
  deleteCustomer(id: number) {
    this.service.deleteCustomer(id).subscribe(() => {
      this.getAllCustomers();
    });
  }

}
