package br.com.blog.cursinho.account.service;

import br.com.blog.cursinho.account.dto.AccountRequestDTO;
import br.com.blog.cursinho.account.repository.AccountRepository;
import br.com.blog.cursinho.account.service.impl.RegisterAccountServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountService {

    private final AccountRepository accountRepository;

    public RegisterAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void saveAccount(AccountRequestDTO accountDto) {

    }
}
