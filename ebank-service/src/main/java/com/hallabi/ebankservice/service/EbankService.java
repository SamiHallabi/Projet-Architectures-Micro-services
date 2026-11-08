package com.hallabi.ebankservice.service;

import com.hallabi.ebankservice.entities.BankAccount;
import com.hallabi.ebankservice.feign.CustomerRestClient;
import com.hallabi.ebankservice.model.Customer;
import com.hallabi.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository bankAccountRepository,  CustomerRestClient customerRestClient) {
        this.accountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> GetAllBankAccounts() {

        return  accountRepository.findAll();
    }

    public BankAccount GetBankAccountById(String id) {
        BankAccount bankAccount= accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Account Not Found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount save(BankAccount bankAccount) {
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
