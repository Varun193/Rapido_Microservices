package com.rapido.user.service;

import com.rapido.user.dto.SystemUserDto;
import com.rapido.user.entity.SystemUser;
import com.rapido.user.repo.SystemUserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserManagementService {

    @Autowired
    private SystemUserRepo systemUserRepo;


    public SystemUserDto getUsersByEmailAddress(String emailAddress) {
        SystemUser systemUser = null;
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUser = systemUserRepo.getSystemUserByEmailAddress(emailAddress);
        BeanUtils.copyProperties(systemUser,systemUserDto);
        return systemUserDto;
    }

    public List<SystemUserDto> getAllSystemCustomers() {
        SystemUser systemUser = null;
        SystemUserDto systemUserDto = null;
//        List<SystemUser> customers = systemUserRepo.getCustomers();
        List<SystemUser> customers = systemUserRepo.getCustomers();
        return mapSystemUserToSystemUserDto(customers);
    }

    private List<SystemUserDto> mapSystemUserToSystemUserDto(List<SystemUser> systemUsers) {
        return systemUsers.stream().map(systemUser -> {
            SystemUserDto systemUserDto = new SystemUserDto();
            BeanUtils.copyProperties(systemUser, systemUserDto);
            return systemUserDto;
        }).collect(Collectors.toList());
    }
}
