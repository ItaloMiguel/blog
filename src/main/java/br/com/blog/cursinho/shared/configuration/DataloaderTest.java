package br.com.blog.cursinho.shared.configuration;

import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import br.com.blog.cursinho.shared.enums.RoleType;
import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.api.role.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Profile("test")
@Configuration
public class DataloaderTest {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public DataloaderTest(RoleRepository roleRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public void onApplicationEvent() {
        System.out.println("\n\n+++++++++ DATA LOADER TEST RUNNING ++++++++++++++++\n\n");

        createRoleIfNotExist(RoleType.ROLE_ADMIN.name());
        createRoleIfNotExist(RoleType.ROLE_USER.name());

        this.createNewTestIfNotExist("ROLE_ADMIN");
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
