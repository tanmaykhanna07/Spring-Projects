package com.company.license_manager.dto;

public class ClientResponseDTO {
    private Integer accountId;
    private String companyName;
    private boolean isActive;
    private Integer currentActiveLicenses;

    public ClientResponseDTO(Integer accountId, String companyName, boolean isActive, Integer currentActiveLicenses) {
        this.accountId = accountId;
        this.companyName = companyName;
        this.isActive = isActive;
        this.currentActiveLicenses = currentActiveLicenses;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getCurrentActiveLicenses() {
        return currentActiveLicenses;
    }

    public void setCurrentActiveLicenses(Integer currentActiveLicenses) {
        this.currentActiveLicenses = currentActiveLicenses;
    }
}
