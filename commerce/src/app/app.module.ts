import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { ProductComponent } from './product/product.component';
import { CustomersComponent } from './customers/customers.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddusersComponent } from './addusers/addusers.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddproductsComponent } from './addproducts/addproducts.component';
import { AddcustomersComponent } from './addcustomers/addcustomers.component';
import { UpdateProductsComponent } from './update-products/update-products.component';




@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ProductComponent,
    CustomersComponent,
    AddusersComponent,
    AddproductsComponent,
    AddcustomersComponent,
    UpdateProductsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }


// app.module.ts


