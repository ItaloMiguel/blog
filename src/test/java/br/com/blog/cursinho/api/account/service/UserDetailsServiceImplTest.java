package br.com.blog.cursinho.api.account.service;

import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl service;

    @Mock
    private AccountRepository repository;

    private Account ACCOUNT;

    private Role ROLE_USER;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repository = Mockito.mock(AccountRepository.class);
        service = new UserDetailsServiceImpl(repository);

        ROLE_USER = new Role(1L, "ROLE_USER");

        ACCOUNT = new Account(
                1L,
                "email@email.com",
                "password",
                "firstName",
                "lastName",
                Set.of(this.ROLE_USER)
        );

    }

    @Test
    void shouldReturnSuccessfullyAndLogin() {
        var OPTIONAL_ACCOUNT = Optional.of(ACCOUNT);

        Mockito.when(repository.findByEmail("email@email.com")).thenReturn(OPTIONAL_ACCOUNT);

        var response = service.loadUserByUsername("email@email.com");

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getAuthorities());

        // ALWAYS RETURNS TRUE.
        Assertions.assertTrue(response.isEnabled());
        Assertions.assertTrue(response.isAccountNonExpired());
        Assertions.assertTrue(response.isAccountNonLocked());
        Assertions.assertTrue(response.isCredentialsNonExpired());

        // USER INFORMATION
        Assertions.assertEquals(ACCOUNT.getAuthorities(), response.getAuthorities());
        Assertions.assertEquals(ACCOUNT.getUsername(), response.getUsername());
        Assertions.assertEquals(ACCOUNT.getPassword(), response.getPassword());

        Mockito.verify(repository, Mockito.times(1)).findByEmail("email@email.com");
    }

    @Test
    void shouldReturnErrorEmailNotFound() {
        Optional<Account> EMPTY = Optional.empty();

        Mockito.when(repository.findByEmail("email@email.com")).thenReturn(EMPTY);

        try {
            var response = service.loadUserByUsername("email@email.com");

        } catch (Exception exception) {
            Assertions.assertNotNull(exception);
            Assertions.assertEquals(UsernameNotFoundException.class, exception.getClass());
            Assertions.assertEquals("Email " + ACCOUNT.getEmail() + " not found", exception.getMessage());
        }

        Mockito.verify(repository, Mockito.times(1)).findByEmail("email@email.com");
    }
}