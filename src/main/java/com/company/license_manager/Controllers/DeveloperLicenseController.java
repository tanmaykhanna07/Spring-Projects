package com.company.license_manager.Controllers;

import com.company.license_manager.dto.LicenseRequestDTO;
import com.company.license_manager.dto.LicenseResponseDTO;
import com.company.license_manager.service.DeveloperLicenseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puchi/license")
public class DeveloperLicenseController {
    private final DeveloperLicenseService developerLicenseService;

    public DeveloperLicenseController(DeveloperLicenseService developerLicenseService) {
        this.developerLicenseService = developerLicenseService;
    }

    @PostMapping
    public LicenseResponseDTO registerLicense(@RequestBody LicenseRequestDTO requestDTO){
        return developerLicenseService.registerLicense(requestDTO);
    }

}
