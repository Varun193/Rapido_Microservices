package com.rapido.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "system_users")
public class SystemUser {
    @Id
    @Column(name = "system_user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int systemUserId;
    @Column(name = "email_address")
    protected String emailAddress;
    @Column(name = "mobile_no")
    protected String mobileNo;
    @Column(name = "first_nm")
    protected String first_name;
    @Column(name = "last_nm")
    protected String last_name;

    protected Date dob;
    protected String password;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    protected Role userRole;

    @OneToOne(mappedBy = "systemUser")
    protected SystemUserKyc systemUserKyc;
    protected String status;

    public int getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(int systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
