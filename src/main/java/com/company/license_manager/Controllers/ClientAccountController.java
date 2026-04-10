package com.company.license_manager.Controllers;

import com.company.license_manager.dto.ClientResponseDTO;
import com.company.license_manager.models.ClientAccount;
import com.company.license_manager.service.ClientAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/puchi/account")
public class ClientAccountController {
    private final ClientAccountService clientAccountService;


    public ClientAccountController(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }
    @GetMapping("/puchi/account/{accountId}")
    public ClientResponseDTO getClientById(@PathVariable Integer accountId){
        return clientAccountService.getClientById(accountId);
    }
}
