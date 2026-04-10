package com.company.license_manager.service;

import com.company.license_manager.dto.ClientResponseDTO;
import com.company.license_manager.exceptions.ResourceNotFoundException;
import com.company.license_manager.models.ClientAccount;
import com.company.license_manager.repositories.ClientAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientAccountService {
    private final ClientAccountRepository clientAccountRepository;

    public ClientAccountService(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }

    public ClientResponseDTO getClientById(Integer id){
        ClientAccount clientAccount = clientAccountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find account with this id. Try again")
        );

        return convertToDTO(clientAccount);
    }

    private ClientResponseDTO convertToDTO(ClientAccount clientAccount){
        return new ClientResponseDTO(
            clientAccount.getAccountId(),
            clientAccount.getCompanyName(),
            clientAccount.isActive(),
            clientAccount.getDeveloperLicenses().size()
        );
    }
}
