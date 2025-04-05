
package br.com.blog.site.shared.configs.password;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.blog.site.shared.domain.Account;

@Profile("test")
@Component
public class TestPasswordSetter implements PasswordSetter {

    public Account setPassword(Account account, String password) {
        account.setPassword(password);
        return account;
    }
}