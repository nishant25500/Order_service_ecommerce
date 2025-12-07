package com.mishri.order_service_ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderServiceEcommerceApplication {


    public static void main(String[] args) {

        //dotenv config
        Dotenv dotenv =Dotenv.configure().ignoreIfMissing().load();

        dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(),entry.getValue()));

        SpringApplication.run(OrderServiceEcommerceApplication.class, args);
    }

}
