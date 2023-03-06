package com.rapido.user.repo;

import com.rapido.user.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SystemUserRepo extends JpaRepository<SystemUser, Integer> {

//    String ROLE_CUSTOMER = "CUSTOMER";

    //    @Query("from SystemUser su where su.userRole.roleName=CUSTOMER")
    @Query("from SystemUser su where su.userRole.roleName = 'CUSTOMER' and su.status='A'")
    List<SystemUser> getCustomers();

//    List<SystemUser> findAll();

    //    @Query("from SystemUser su where su.emailAddress like : email_address")
    @Query("from SystemUser su where su.emailAddress = ?1")
    SystemUser getSystemUserByEmailAddress(@Param("email_Address") String emailAddress);
}
