package com.merotiffin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "USER MANAGEMENT",
                version = "1.0",
                description = "USER SERVICE MANAGEMENT APPLICATION"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8181/user-api/v1.0/users",
                        description = "user service api"
                )
        }
)
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
