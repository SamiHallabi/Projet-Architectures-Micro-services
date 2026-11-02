package com.hallabi.ebankservice.service;

import com.hallabi.ebankservice.entities.BankAccount;
import com.hallabi.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbankService {
    private BankAccountRepository accountRepository;

    public EbankService(BankAccountRepository bankAccountRepository) {
        this.accountRepository = bankAccountRepository;
    }

    public List<BankAccount> GetAllBankAccounts() {
        return  accountRepository.findAll();
    }

    public BankAccount GetBankAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Bank Account Not Found"));
    }

    public BankAccount SaveBankAccount(BankAccount bankAccount) {
        return accountRepository.save(bankAccount);
    }


}
