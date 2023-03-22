package com.example.service3;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r->r.path("/service1/**")
                        .uri("http://localhost:9000/"))

                .route(r-> r.path("/service2/**")
                        .uri("http://localhost:7000/"))

                .build();

    }
}
