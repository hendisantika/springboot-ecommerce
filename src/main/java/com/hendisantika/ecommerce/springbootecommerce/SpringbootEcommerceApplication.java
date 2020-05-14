package com.hendisantika.ecommerce.springbootecommerce;

import com.hendisantika.ecommerce.springbootecommerce.model.Product;
import com.hendisantika.ecommerce.springbootecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Samsung TV Set", 300.00, "https://encrypted-tbn0.gstatic" +
                    ".com/images?q=tbn:ANd9GcSHs_Q_HmDxOPprg7CJHWYf_qMf3qUtubTQ8nsSoC4FRdhsaT5ffg&s"));
            productService.save(new Product(2L, "Game Console", 200.00, "https://images-na.ssl-images-amazon" +
                    ".com/images/I/71jN27mYlhL._AC_SL1500_.jpg"));
            productService.save(new Product(3L, "Sofa", 100.00, "https://media.4rgos.it/i/Argos/9182723_R_Z001A?w=750" +
                    "&h=440&qlt=70"));
            productService.save(new Product(4L, "Ice Cream", 5.00, "https://mmc.tirto.id/image/otf/500x0/2020/03/31" +
                    "/header-walls-vienetta_ratio-16x9.jpg"));
            productService.save(new Product(5L, "Marjan", 3.00, "https://ecs7.tokopedia" +
                    ".net/img/cache/700/product-1/2018/10/18/4395737/4395737_869adbbe-e65e-4491-82eb" +
                    "-7f66cce49488_394_394.jpg"));
            productService.save(new Product(6L, "iPhone 11X", 500.00, "https://www.concept-phones" +
                    ".com/wp-content/uploads/2019/08/iPhone-11X-concept-phone-Hasan-Kaymak-1.jpg"));
            productService.save(new Product(7L, "Watch", 30.00, "https://p.ipricegroup" +
                    ".com/uploaded_16689895db8e5bf4e35f115583693d64.jpg"));
            productService.save(new Product(8L, "MI TV Set", 300.00, "https://i01.appmifile" +
                    ".com/v1/MI_18455B3E4DA706226CF7535A58E875F0267/pms_1586239648.44731389.jpg"));
            productService.save(new Product(9L, "Brompton", 350.00, "https://www.brompton" +
                    ".com/~/media/images/core-site-content/interactive-bike-block/explore/bromptonexplore_740x600" +
                    ".png?h=600&la=en&w=740"));
        };
    }

}
