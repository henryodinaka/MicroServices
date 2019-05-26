package leo.henry.co.productservice.controller;

import leo.henry.co.productservice.apiResponse.Product;
import leo.henry.co.productservice.apiResponse.Rating;
import leo.henry.co.productservice.apiResponse.UserRating;
import leo.henry.co.productservice.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

//    @Qualifier("getWebClientBuilder")
    @Autowired
    private WebClient.Builder builder;

    @GetMapping("/{userId}")
    List<CatalogItem> getItems(@PathVariable("userId") Long userId){


        UserRating ratings = restTemplate.getForObject("http://localhost:8082/rating/user/"+userId,UserRating.class);
        return ratings.getRatings().stream().map(rating -> {
//            Product p = restTemplate.getForObject("http://localhost:8081/product/info/"+rating.getItemId(), Product.class);
            Product p = builder.build()
                    .get()
                    .uri("http://localhost:8081/product/info/"+rating.getItemId())
                    .retrieve()
                    .bodyToMono(Product.class)
                    .block();
            return new CatalogItem(p.getName(),"DSC",rating.getRating());
        })
                .collect(Collectors.toList());
//        return Collections.singletonList(
//                new CatalogItem("LG tv","This is a smart tv",4)
////                new CatalogItem("LG Cd","This is a set of cd player",3),
////                new CatalogItem("Cup","Love garden",2),
////                new CatalogItem("Spoon","For eating rice",4),
////                new CatalogItem("Knife","Likely",5),
////                new CatalogItem("Ball","balling",3)
//        );
    }
}
