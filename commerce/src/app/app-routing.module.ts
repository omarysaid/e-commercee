import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers/customers.component';
import { ProductComponent } from './product/product.component';
import { UsersComponent } from './users/users.component';
import { AddusersComponent } from './addusers/addusers.component';
import { AddproductsComponent } from './addproducts/addproducts.component';
import { AddcustomersComponent } from './addcustomers/addcustomers.component';
import { UpdateProductsComponent } from './update-products/update-products.component';


const routes: Routes = [
  { path: 'customers', component: CustomersComponent },
  { path: 'product', component: ProductComponent },
  { path: 'users', component: UsersComponent },
  { path: 'addusers', component: AddusersComponent },
  { path: 'addproducts', component: AddproductsComponent },
  { path: 'addcustomers', component: AddcustomersComponent },
  { path: 'update-products', component: UpdateProductsComponent },
  { path: 'product/:id', component: UpdateProductsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
