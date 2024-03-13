import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router'; // Import Router
import { ProductsService } from '../products.service';

@Component({
    selector: 'app-update-products',
    templateUrl: './update-products.component.html',
    styleUrls: ['./update-products.component.css']
})
export class UpdateProductsComponent implements OnInit {
    updateForm!: FormGroup; // Add ! to indicate non-null
    id: number = this.activatedRoute.snapshot.params["id"];


    constructor(
        private formBuilder: FormBuilder,
        private productService: ProductsService,
        private activatedRoute: ActivatedRoute,
        private router: Router // Inject Router
    ) { }

    ngOnInit() {
        this.updateForm = this.formBuilder.group({
            name: [null, [Validators.required]],
            description: [null, [Validators.required]],
            discountedPrice: [null, [Validators.required]],
            actualPrice: [null, [Validators.required]]

        });
        this.getProductById();

    }

    getProductById() {
        this.productService.getProductById(this.id).subscribe((res) => {
            console.log(res);
            this.updateForm.patchValue(res);
        });
    }


    initForm() {
        this.updateForm = this.formBuilder.group({
            name: ['', Validators.required],
            description: ['', Validators.required],
            discountedPrice: ['', Validators.required],
            actualPrice: ['', Validators.required]
        });
    }

    updateProduct() {
        this.productService.updateProduct(this.id, this.updateForm.value).subscribe((res) => {
            console.log(res);
            if (res) {  // Check if a truthy value is returned (indicating a successful update)
                this.router.navigateByUrl("/product");
            }
        })
    }

}
