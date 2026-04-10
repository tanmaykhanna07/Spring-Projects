package com.company.license_manager.models;

import jakarta.persistence.*;

@Entity
@Table(name = "developer-license")
public class DeveloperLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer licenseId;

    @Column(name = "developer-name")
    private String developerName;

    @Column(name = "device-macaddress")
    private String deviceMacAddress;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private ClientAccount clientAccount;

    public DeveloperLicense(){};

    public Integer getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeviceMacAddress() {
        return deviceMacAddress;
    }

    public void setDeviceMacAddress(String deviceMacAddress) {
        this.deviceMacAddress = deviceMacAddress;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }
}
