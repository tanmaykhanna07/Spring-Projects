package com.company.license_manager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client-account")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "company-name", nullable = false)
    private String companyName;

    @Column(name = "max-licenses")
    private Integer maxLicenses;

    @Column(name = "is-active")
    private boolean isActive;

    @OneToMany(mappedBy = "licenseId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DeveloperLicense> developerLicenses;

    public ClientAccount(){};

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

    public Integer getMaxLicenses() {
        return maxLicenses;
    }

    public void setMaxLicenses(Integer maxLicenses) {
        this.maxLicenses = maxLicenses;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<DeveloperLicense> getDeveloperLicenses() {
        return developerLicenses;
    }

    public void setDeveloperLicenses(List<DeveloperLicense> developerLicenses) {
        this.developerLicenses = developerLicenses;
    }
}
