package com.rapido.mobile.dto;

import lombok.Data;

@Data
public class Customer {
    protected int systemUserId;
    protected String emailAddress;
    protected String mobileNo;
    protected String first_name;
    protected String status;
    protected String password;
}
