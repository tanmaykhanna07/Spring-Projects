package com.company.license_manager.dto;

public class LicenseRequestDTO {
    private String developerName;
    private String deviceMacAddress;
    private Integer clientAccountId;

    public LicenseRequestDTO(String developerName, String deviceMacAddress, Integer clientAccountId) {
        this.developerName = developerName;
        this.deviceMacAddress = deviceMacAddress;
        this.clientAccountId = clientAccountId;
    }

    public String getDeviceMacAddress() {
        return deviceMacAddress;
    }

    public void setDeviceMacAddress(String deviceMacAddress) {
        this.deviceMacAddress = deviceMacAddress;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getClientAccountId() {
        return clientAccountId;
    }

    public void setClientAccountId(Integer clientAccountId) {
        this.clientAccountId = clientAccountId;
    }
}
