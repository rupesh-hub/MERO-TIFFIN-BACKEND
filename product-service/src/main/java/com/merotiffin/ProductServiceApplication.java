package com.merotiffin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "PRODUCT MANAGEMENT",
                version = "1.0",
                description = "PRODUCT MANAGEMENT APPLICATION"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8282/product-api/v1.0/products",
                        description = "product management api"
                )
        }
)
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}