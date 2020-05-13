import {Component, OnInit} from '@angular/core';
import {EcommerceService} from "../services/ecommerce.service";
import {Subscription} from "rxjs";
import {ProductOrders} from "../models/product-orders.model";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: ProductOrders;
  total: number;
  paid: boolean;
  sub: Subscription;

  constructor(private ecommerceService: EcommerceService) {
    this.orders = this.ecommerceService.ProductOrders;
  }

  ngOnInit() {
    this.paid = false;
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
      this.orders = this.ecommerceService.ProductOrders;
    });
    this.loadTotal();
  }

  pay() {
    this.paid = true;
    this.ecommerceService.saveOrder(this.orders).subscribe();
  }

}
