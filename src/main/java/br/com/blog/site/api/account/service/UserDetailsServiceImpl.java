package br.com.blog.site.api.account.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.blog.site.api.account.AccountRepository;
import br.com.blog.site.shared.domain.Account;
import br.com.blog.site.shared.domain.UserAuthenticate;

@Component("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
        return new UserAuthenticate(account);
    }

}
