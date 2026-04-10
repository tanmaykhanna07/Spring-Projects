package com.company.license_manager.repositories;

import com.company.license_manager.models.DeveloperLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperLicenseRepository extends JpaRepository<DeveloperLicense,Integer> {
}
