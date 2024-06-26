package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.api.role.RoleRepository;
import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import br.com.blog.cursinho.shared.enums.RoleType;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccountFactory {
    private final Account account = new Account();

    public AccountFactory(AccountRegisterForm accountDTO) {
        account.setFirstName(accountDTO.getFirstName());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());

        this.lastNameConfirm(accountDTO.getLastName());
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
