import { Component } from '@angular/core';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addproducts',
  templateUrl: './addproducts.component.html',
  styleUrl: './addproducts.component.css'
})
export class AddproductsComponent {
  PostusersForm: FormGroup;

  constructor(private productsService: ProductsService, private fb: FormBuilder, private router: Router) {
    this.PostusersForm = this.fb.group({
      name: [null, [Validators.required]],
      description: [null, [Validators.required]],
      discountedPrice: [null, [Validators.required]],
      actualPrice: [null, [Validators.required]],

    });
  }

  addProduct() {
    if (this.PostusersForm.valid) {
      console.log(this.PostusersForm.value);
      this.productsService.addProduct(this.PostusersForm.value).subscribe((res) => {
        console.log(res);
        this.router.navigateByUrl("/product");
      });
    } else {
      console.log('Form is invalid. Please check the fields.');
    }
  }

}
