package leo.henry.co.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {
    @Bean
    public RestTemplate getRestemplate(){
        return new RestTemplate();
    }
//    @Bean
//    public  WebClient.Builder getWebClientBuilder(){
//        return WebClient.builder();
//    }
}
