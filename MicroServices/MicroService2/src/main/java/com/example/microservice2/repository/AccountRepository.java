package com.example.microservice2.repository;

import com.example.microservice2.model.Account;
import java.util.List;


public interface AccountRepository {

    List<Account> getAllAccounts();

    Account getAccount(String number);
}
