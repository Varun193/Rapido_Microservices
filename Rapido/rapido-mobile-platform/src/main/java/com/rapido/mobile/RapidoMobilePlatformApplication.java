package com.rapido.mobile;

import com.rapido.mobile.dto.Customer;
import com.rapido.mobile.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class RapidoMobilePlatformApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RapidoMobilePlatformApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        List<Customer> customers = userService.getCustomers();
        customers.forEach(System.out::println);
    }

}
