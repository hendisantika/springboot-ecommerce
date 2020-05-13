import {Component, OnInit} from '@angular/core';
import {ProductOrder} from "../models/product-order.model";
import {EcommerceService} from "../services/ecommerce.service";
import {Subscription} from "rxjs";
import {ProductOrders} from "../models/product-orders.model";
import {Product} from "../models/product.model";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productOrders: ProductOrder[] = [];
  products: Product[] = [];
  selectedProductOrder: ProductOrder;
  sub: Subscription;
  productSelected: boolean = false;
  private shoppingCartOrders: ProductOrders;

  constructor(private ecommerceService: EcommerceService) {
  }

  ngOnInit() {
    this.productOrders = [];
    this.loadProducts();
    this.loadOrders();
  }

  loadProducts() {
    this.ecommerceService.getAllProducts()
      .subscribe(
        (products: any[]) => {
          this.products = products;
          this.products.forEach(product => {
            this.productOrders.push(new ProductOrder(product, 0));
          })
        },
        (error) => console.log(error)
      );
  }

  loadOrders() {
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
      this.shoppingCartOrders = this.ecommerceService.ProductOrders;
    });
  }

}
