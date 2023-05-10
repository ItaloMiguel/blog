package br.com.blog.cursinho.shared.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")})
    private Set<Role> roles = new HashSet<>();

    public Account(String firstName, String lastName, String email, String password, Role roleModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles.add(roleModel);
    }


    public void addRoles(Role roleUser) {
        this.roles.add(roleUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.firstName + " " + this.lastName;
    }

    // always needs to be true if there are no business rules
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // always needs to be true if there are no business rules
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // always needs to be true if there are no business rules
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // always needs to be true if there are no business rules
    @Override
    public boolean isEnabled() {
        return true;
    }
}
