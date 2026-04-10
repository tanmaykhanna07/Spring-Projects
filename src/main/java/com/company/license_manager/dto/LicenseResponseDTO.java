package com.company.license_manager.dto;

public class LicenseResponseDTO {
    private Integer licenseId;
    private String developerName;
    private String deviceMacAddress;
    private String companyName;

    public LicenseResponseDTO(Integer licenseId, String developerName, String deviceMacAddress, String companyName) {
        this.developerName = developerName;
        this.companyName = companyName;
        this.deviceMacAddress = deviceMacAddress;
        this.licenseId = licenseId;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
