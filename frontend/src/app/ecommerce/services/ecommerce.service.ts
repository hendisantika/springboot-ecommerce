import {Injectable} from '@angular/core';
import {Subject} from "rxjs";
import {ProductOrders} from "../models/product-orders.model";
import {HttpClient} from "@angular/common/http";
import {ProductOrder} from "../models/product-order.model";
import {Product} from "../models/product.model";

@Injectable({providedIn: 'root'})
export class EcommerceService {
  private productsUrl = "/api/products";
  private ordersUrl = "/api/orders";

  private productOrder!: ProductOrder;
  private orders: ProductOrders = new ProductOrders();

  private productOrderSubject = new Subject<void>();
  private ordersSubject = new Subject<void>();
  private totalSubject = new Subject<void>();

  private total!: number;

  ProductOrderChanged = this.productOrderSubject.asObservable();
  OrdersChanged = this.ordersSubject.asObservable();
  TotalChanged = this.totalSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  getAllProducts() {
    return this.http.get<Product[]>(this.productsUrl);
  }

  saveOrder(order: ProductOrders) {
    return this.http.post(this.ordersUrl, order);
  }

  get SelectedProductOrder() {
    return this.productOrder;
  }

  set SelectedProductOrder(value: ProductOrder) {
    this.productOrder = value;
    this.productOrderSubject.next();
  }

  get ProductOrders() {
    return this.orders;
  }

  set ProductOrders(value: ProductOrders) {
    this.orders = value;
    this.ordersSubject.next();
  }

  get Total() {
    return this.total;
  }

  set Total(value: number) {
    this.total = value;
    this.totalSubject.next();
  }
}
