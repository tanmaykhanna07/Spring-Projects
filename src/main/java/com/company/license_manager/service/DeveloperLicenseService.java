package com.company.license_manager.service;

import com.company.license_manager.dto.LicenseRequestDTO;
import com.company.license_manager.dto.LicenseResponseDTO;
import com.company.license_manager.exceptions.AccountSuspendedException;
import com.company.license_manager.exceptions.LicenseLimitExceededException;
import com.company.license_manager.exceptions.ResourceNotFoundException;
import com.company.license_manager.models.ClientAccount;
import com.company.license_manager.models.DeveloperLicense;
import com.company.license_manager.repositories.ClientAccountRepository;
import com.company.license_manager.repositories.DeveloperLicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class DeveloperLicenseService {
    private final DeveloperLicenseRepository developerLicenseRepository;
    private final ClientAccountRepository clientAccountRepository;

    public DeveloperLicenseService(DeveloperLicenseRepository developerLicenseRepository, ClientAccountRepository clientAccountRepository) {
        this.developerLicenseRepository = developerLicenseRepository;
        this.clientAccountRepository = clientAccountRepository;
    }

    public LicenseResponseDTO registerLicense(LicenseRequestDTO requestDTO){
        ClientAccount clientAccount = clientAccountRepository.findById(requestDTO.getClientAccountId()).orElseThrow(
                () -> new ResourceNotFoundException(requestDTO.getClientAccountId() + " not found. Try again")
        );
        if(requestDTO.getClientAccountId() == null){
            throw new IllegalArgumentException("A license cannot exist without an account");
        }
        if(!clientAccount.isActive()){
            throw new AccountSuspendedException("Your license ran out, subscribe again to continue");
        }
        if(requestDTO.getDeviceMacAddress().length() != 17){
            throw new IllegalArgumentException("Mac address incorrect");
        }
        int licenseCount = clientAccount.getDeveloperLicenses().size();
        if(licenseCount >= clientAccount.getMaxLicenses()){
            throw new LicenseLimitExceededException("You have more licenses than your account permits. Upgrade your account nigga");
        }
        DeveloperLicense newDeveloperLicense = new DeveloperLicense();
        newDeveloperLicense.setDeveloperName(requestDTO.getDeveloperName());
        newDeveloperLicense.setClientAccount(clientAccount);
        newDeveloperLicense.setDeviceMacAddress(requestDTO.getDeviceMacAddress());
        DeveloperLicense savedLicense = developerLicenseRepository.save(newDeveloperLicense);
        return convertToDTO(savedLicense);
    }

    private LicenseResponseDTO convertToDTO(DeveloperLicense newLicense){
        return new LicenseResponseDTO(
                newLicense.getLicenseId(),
                newLicense.getDeveloperName(),
                newLicense.getDeviceMacAddress(),
                newLicense.getClientAccount().getCompanyName()
        );
    }

}
