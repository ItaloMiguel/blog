package br.com.blog.site.shared.configs.password;

import br.com.blog.site.shared.domain.Account;

public interface PasswordSetter {
    Account setPassword(Account account, String password);
}
