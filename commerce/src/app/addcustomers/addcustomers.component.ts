import { Component } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-addcustomers',
  templateUrl: './addcustomers.component.html',
  styleUrl: './addcustomers.component.css'
})
export class AddcustomersComponent {
  PostcustomersForm: FormGroup;

  constructor(private Service: CustomerService, private fb: FormBuilder, private router: Router) {
    this.PostcustomersForm = this.fb.group({
      firstname: [null, [Validators.required]],
      lastname: [null, [Validators.required]],
      gender: [null, [Validators.required]],
      region: [null, [Validators.required]],
      phone: [null, [Validators.required]],
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }


  addCustomer() {
    if (this.PostcustomersForm.valid) {
      console.log(this.PostcustomersForm.value);
      this.Service.addCustomer(this.PostcustomersForm.value).subscribe((res) => {
        console.log(res);
        this.router.navigateByUrl("/customers");
      });
    } else {
      console.log('Form is invalid. Please check the fields.');
    }
  }

}
