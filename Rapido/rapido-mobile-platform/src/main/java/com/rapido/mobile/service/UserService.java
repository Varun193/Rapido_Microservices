package com.rapido.mobile.service;

import com.rapido.mobile.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Customer> getCustomers() {
        ResponseEntity<Customer[]> responseEntity = null;
//        restTemplate.getForEntity("http://USER-SERVICE/api/customers",responseEntity);
        responseEntity = restTemplate.getForEntity("http://USER-SERVICE/api/customers", Customer[].class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(responseEntity.getBody());
        }
        throw new RuntimeException("error while fetching data");
    }

}
