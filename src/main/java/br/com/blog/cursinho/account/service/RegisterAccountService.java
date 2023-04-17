package br.com.blog.cursinho.account.service;

import br.com.blog.cursinho.account.domain.Account;
import br.com.blog.cursinho.account.dto.AccountRegisterRequestDTO;
import br.com.blog.cursinho.account.repository.AccountRepository;
import br.com.blog.cursinho.account.repository.RoleRepository;
import br.com.blog.cursinho.factory.AccountFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    public RegisterAccountService(AccountRepository accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    public void createAccount(AccountRegisterRequestDTO accountDTO) {
        Account account = new AccountFactory(accountDTO)
                .setPasswordEncoder()
                .makeUser(roleRepository)
                .build();
        System.out.println("\n\nACCOUNT REGISTRATION: " + account + "++++++\n\n");

        accountRepository.save(account);
    }
}
