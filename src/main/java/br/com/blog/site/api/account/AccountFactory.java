package br.com.blog.site.api.account;

import org.springframework.context.annotation.Configuration;

import br.com.blog.site.api.role.RoleRepository;
import br.com.blog.site.shared.domain.Account;
import br.com.blog.site.shared.domain.Role;
import br.com.blog.site.shared.enums.RoleType;

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
