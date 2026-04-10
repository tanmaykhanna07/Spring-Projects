package com.company.license_manager.repositories;

import com.company.license_manager.models.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccount,Integer> {
}
