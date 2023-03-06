package com.rapido.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "system_user_kyc")
public class SystemUserKyc {

    @Id
    @GeneratedValue(generator = "foreign_gen")
    @GenericGenerator(name = "foreign_gen", strategy = "foreign", parameters = {
            @org.hibernate.annotations.Parameter(name = "property", value = "systemUser")
    })
    protected int systemUserId;
    protected Date kycDate;
    protected String identificationType;
    protected String identificationNo;

    @OneToOne
    @PrimaryKeyJoinColumn
    protected SystemUser systemUser;

    public int getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(int systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Date getKycDate() {
        return kycDate;
    }

    public void setKycDate(Date kycDate) {
        this.kycDate = kycDate;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
