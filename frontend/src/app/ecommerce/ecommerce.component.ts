import {Component, OnInit, ViewChild} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductsComponent} from "./products/products.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {OrdersComponent} from "./orders/orders.component";

@Component({
  selector: 'app-ecommerce',
  imports: [CommonModule, ProductsComponent, ShoppingCartComponent, OrdersComponent],
  templateUrl: './ecommerce.component.html',
  styleUrls: ['./ecommerce.component.css']
})
export class EcommerceComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  orderFinished = false;
  @ViewChild('productsC')
  productsC!: ProductsComponent;
  @ViewChild('shoppingCartC')
  shoppingCartC!: ShoppingCartComponent;
  @ViewChild('ordersC')
  ordersC!: OrdersComponent;
  protected collapsed = true;

  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }

  finishOrder(orderFinished: boolean) {
    this.orderFinished = orderFinished;
  }

  reset() {
    this.orderFinished = false;
    this.productsC.reset();
    this.shoppingCartC.reset();
    this.ordersC.paid = false;
  }

}
