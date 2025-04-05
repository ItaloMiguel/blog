package br.com.blog.site.shared.configs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.blog.site.api.account.AccountRepository;
import br.com.blog.site.api.role.RoleRepository;
import br.com.blog.site.shared.configs.password.DefaultPasswordSetter;
import br.com.blog.site.shared.domain.Account;
import br.com.blog.site.shared.domain.Role;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;

@Slf4j
@Profile("test")
@AllArgsConstructor
@Configuration
public class EncryptorTestFactory {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final DefaultPasswordSetter defaultPasswordSetter;

    @Bean
    public void exec() {
        List<Account> accountList = accountRepository.findAll();
        @SuppressWarnings("unused")
        List<Role> roles = roleRepository.findAll();

        passwordEncryptor(accountList);
    }

    private void passwordEncryptor(List<Account> accountList) {
        if (!accountList.isEmpty()) {
            log.info("TEST CODE :: Password encryptor code running normally.");

            List<Account> listOfEncodedAccounts = accountList.stream().map(this::encoderMap).toList();
            accountRepository.saveAll(listOfEncodedAccounts);
        } else {
            log.info("TEST CODE :: There is a problem in the test code or password encryptor");
        }
    }

    private Account encoderMap(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        return defaultPasswordSetter.setPassword(account, encodedPassword);
    }
}
