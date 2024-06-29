package br.com.blog.cursinho.shared.configs;

import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.shared.domain.Account;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Slf4j
@Profile("test")
@AllArgsConstructor
public class EncryptorTestFactory {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void exec() {
        List<Account> accountList = accountRepository.findAll();
        if (!accountList.isEmpty()) {
            log.info("Test code running normally.");

            List<Account> listOfEncodedAccounts = accountList.stream().map(this::encoderMap).toList();
            accountRepository.saveAll(listOfEncodedAccounts);
        } else {
            log.info("There is a problem in the test code.");
        }
    }

    private Account encoderMap(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        return account.setPasswordEncodedAndReturnClassAccount(encodedPassword);
    }
}
