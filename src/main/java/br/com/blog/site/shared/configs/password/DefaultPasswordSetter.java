package br.com.blog.site.shared.configs.password;

import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.blog.site.shared.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Profile("!test")
@Component
@Builder
@AllArgsConstructor
public class DefaultPasswordSetter implements PasswordSetter {

    private final PasswordEncoder encoder;

    public Account setPassword(Account account, String password) {
        account.setPassword(encoder.encode(password));
        return account;
    }
    
}
