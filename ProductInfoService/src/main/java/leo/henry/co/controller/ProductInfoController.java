package leo.henry.co.controller;

import leo.henry.co.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/info")
public class ProductInfoController {

    @GetMapping("/{productId}")
    public Product getProductInfo(@PathVariable("productId") Long id){
        return new Product(id,"LG Tv");
    }
}
