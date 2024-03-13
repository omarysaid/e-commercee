import { Component } from '@angular/core';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  ProductsLists: any[] = [];




  constructor(private service: ProductsService) { }

  ngOnInit() {
    this.getAllProducts();
  }


  getAllProducts() {
    this.service.getAllProducts().subscribe((res) => {
      this.ProductsLists = res;
    });
  }
  deleteProduct(id: number) {
    this.service.deleteProduct(id).subscribe(() => {
      this.getAllProducts();
    });
  }

}



