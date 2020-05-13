import {Injectable} from '@angular/core';
import {Subject} from "rxjs";
import {ProductOrders} from "../models/product-orders.model";
import {HttpClient} from "@angular/common/http";
import {ProductOrder} from "../models/product-order.model";

@Injectable()
export class EcommerceService {
  private productsUrl = "/api/products";
  private ordersUrl = "/api/orders";

  private productOrder: ProductOrder;
  private orders: ProductOrders = new ProductOrders();

  private productOrderSubject = new Subject();
  ProductOrderChanged = this.productOrderSubject.asObservable();
  private ordersSubject = new Subject();
  OrdersChanged = this.ordersSubject.asObservable();
  private totalSubject = new Subject();
  TotalChanged = this.totalSubject.asObservable();
  private total: number;

  constructor(private http: HttpClient) {
  }

  getAllProducts() {
    return this.http.get(this.productsUrl);
  }

  saveOrder(order: ProductOrders) {
    return this.http.post(this.ordersUrl, order);
  }

}
