package br.com.blog.cursinho.config;

import br.com.blog.cursinho.account.domain.Account;
import br.com.blog.cursinho.account.domain.Role;
import br.com.blog.cursinho.account.domain.RoleType;
import br.com.blog.cursinho.account.repository.AccountRepository;
import br.com.blog.cursinho.account.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Profile("dev")
@Configuration
public class DataloaderDev {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public DataloaderDev(RoleRepository roleRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public void onApplicationEvent() {
        System.out.println("\n\n+++++++++ DATA LOADER DEV RUNNING ++++++++++++++++\n\n");

        createRoleIfNotExist(RoleType.ROLE_ADMIN.name());
        createRoleIfNotExist(RoleType.ROLE_USER.name());

    }

    @Transactional
    private void createRoleIfNotExist(String roleName) {
        Optional<Role> optional = roleRepository.findByName(roleName);
        if(optional.isEmpty()) {
            roleRepository.save(new Role(roleName));
        }
    }

    @Transactional
    private void createNewTestIfNotExist(String roles) {
        Role roleModel = roleRepository.findByName(roles).get();

        Optional<Account> optional = accountRepository.findByEmail("admin.admin@email.com");
        if(optional.isEmpty()) {
            Account account = new Account("firstName", "lastName",
                    "admin.admin@email.com",
                    passwordEncoder.encode("password"), roleModel);

            accountRepository.save(account);
        }
    }
}
