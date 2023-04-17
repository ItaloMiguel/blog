package br.com.blog.cursinho.factory;

import br.com.blog.cursinho.account.domain.Account;
import br.com.blog.cursinho.account.domain.Role;
import br.com.blog.cursinho.account.domain.RoleType;
import br.com.blog.cursinho.account.dto.AccountRegisterRequestDTO;
import br.com.blog.cursinho.account.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccountFactory {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final Account account = new Account();

    public AccountFactory(AccountRegisterRequestDTO accountDTO) {
        account.setFirstName(accountDTO.getFirstName());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());

        this.lastNameConfirm(accountDTO.getLastName());
    }

    public AccountFactory setPasswordEncoder() {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return this;
    }

    public AccountFactory makeUser(RoleRepository roleRepository) {
        Role role = roleRepository.findByName(RoleType.ROLE_USER.name()).get();
        account.addRoles(role);
        return this;
    }

    public Account build() {
        return this.account;
    }

    private void lastNameConfirm(String lastName) {
        if (lastName != null) {
            account.setLastName(lastName);
        }
    }
}
