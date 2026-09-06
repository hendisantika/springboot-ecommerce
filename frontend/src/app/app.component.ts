import {Component} from '@angular/core';
import {EcommerceComponent} from './ecommerce/ecommerce.component';

@Component({
  selector: 'app-root',
  imports: [EcommerceComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
}
