package br.com.blog.site.api.account.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.blog.site.api.account.AccountAdminInfo;
import br.com.blog.site.api.account.AccountRepository;
import br.com.blog.site.shared.domain.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Collectors;


@Profile("test")
@Slf4j
@Service
@AllArgsConstructor
public class AccountGetUsers {
    
    private final AccountRepository accountRepository;

    public List<AccountAdminInfo> execute() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(account -> new AccountAdminInfo(account.getEmail(), account.getFirstName(), account.getLastName())).collect(Collectors.toList());
    }
}
