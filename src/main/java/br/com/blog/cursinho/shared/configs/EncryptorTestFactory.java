package br.com.blog.cursinho.shared.configs;

import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.shared.domain.Account;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Profile("test")
@Configuration
public class EncryptorTestFactory {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public EncryptorTestFactory(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Transactional
    public void exec() {
        List<Account> accountList = accountRepository.findAll();
        if (!accountList.isEmpty()) {
            List<Account> listOfEncodedAccounts = accountList.stream().map(this::encoderMap).toList();
            accountRepository.saveAll(listOfEncodedAccounts);
        }
    }

    private Account encoderMap(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        return account.setPasswordEncodedAndReturnClassAccount(encodedPassword);
    }
}
