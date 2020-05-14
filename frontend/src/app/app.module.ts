import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {EcommerceComponent} from './ecommerce/ecommerce.component';
import {ProductsComponent} from './ecommerce/products/products.component';
import {OrdersComponent} from './ecommerce/orders/orders.component';
import {ShoppingCartComponent} from './ecommerce/shopping-cart/shopping-cart.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {EcommerceService} from "./ecommerce/services/ecommerce.service";

@NgModule({
  declarations: [
    AppComponent,
    EcommerceComponent,
    ProductsComponent,
    OrdersComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [EcommerceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
