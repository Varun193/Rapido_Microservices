package com.rapido.user.controller;

import com.rapido.user.dto.SystemUserDto;
import com.rapido.user.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
@EntityScan(basePackages = "com.rapido.user.entity")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/customers")
    public List<SystemUserDto> getAllSystemUsers() {
        return userManagementService.getAllSystemCustomers();
    }

    @GetMapping("/user/{emailAddress}/details")
    public SystemUserDto getSystemUserByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        return userManagementService.getUsersByEmailAddress(emailAddress);
    }
}
