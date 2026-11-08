package com.hallabi.ebankservice.controllers;

import com.hallabi.ebankservice.entities.BankAccount;
import com.hallabi.ebankservice.service.EbankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EbankRestController {

    private EbankService ebankService;

    public EbankRestController(EbankService ebankService) {
        this.ebankService = ebankService;
    }


    @GetMapping("/accounts")
    public List<BankAccount> GetAllBankAccounts() {

        return  ebankService.GetAllBankAccounts();
    }


    @GetMapping("/accounts/{id}")
    public BankAccount GetBankAccountById(@PathVariable  String id) {
        return ebankService.GetBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount SaveBankAccount(@RequestBody BankAccount bankAccount) {
        return ebankService.save(bankAccount);
    }
}
