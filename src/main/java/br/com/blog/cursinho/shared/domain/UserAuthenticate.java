package br.com.blog.cursinho.shared.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;

@ToString
@EqualsAndHashCode
public class UserAuthenticate implements UserDetails, Principal {

    private Account account;

    public UserAuthenticate(Account account) {
        this.account = account;
    }

    @Override
    public String getName() {
        if (account.getLastName().isEmpty()) {
            return account.getFirstName();
        }
        return String.format("%s %s", account.getFirstName(), account.getLastName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return account.getAuthorities();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
