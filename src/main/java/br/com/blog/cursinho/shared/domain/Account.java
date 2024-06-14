package br.com.blog.cursinho.shared.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "tb_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private BigInteger id;

    @NotNull
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    @Column(name = "first_name", unique = true)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_account_role",
            joinColumns = {@JoinColumn(name = "tb_account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tb_role_name", referencedColumnName = "name")})
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
        return this.email;
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

    /**
     * Esse nome é meio grande para deixar claro o que faz.
     * Ele é utilizada no EncryptorFactory, umas classe que é usada em profile de teste
     **/
    public Account setPasswordEncodedAndReturnClassAccount(String password) {
        this.password = password;
        return this;
    }
}
