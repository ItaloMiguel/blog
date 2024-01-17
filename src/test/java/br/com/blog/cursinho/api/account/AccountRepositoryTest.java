package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository repository;

    private Role ROLE_USER;

    private Account FELIZARDO;

    @BeforeEach
    void setupBefore() {
        // Arrange
        ROLE_USER = Role.builder()
                .id(1L)
                .name("ROLE_USER")
                .build();

        FELIZARDO = Account.builder()
                .email("joaquim@email.com")
                .roles(
                        Set.of(ROLE_USER)
                ).lastName("Felizardo")
                .firstName("da Silva")
                .password("password")
                .build();
    }

//    @Test
//    void saveAccount_ReturnAccountSaved() {
//        Account accountReturn = repository.save(FELIZARDO);
//
//        Assertions.assertThat(accountReturn).isNotNull();
//        Assertions.assertThat(accountReturn.getId()).isGreaterThanOrEqualTo(1);
//    }
//
//    @Test
//    void shouldntSaveAccount_BecauseAlreadyExists_ReturnError() {
//        repository.save(FELIZARDO);
//
//        try {
//            repository.save(FELIZARDO);
//        } catch (Exception exception) {
//            org.junit.jupiter.api.Assertions.assertNotNull(exception);
//            org.junit.jupiter.api.Assertions.assertNull(exception.getMessage());
//        }
//    }
//
//    @Test
//    void findByEmail_ReturnAccount() {
//        repository.save(FELIZARDO);
//        Optional<Account> accountReturn = repository.findByEmail(FELIZARDO.getEmail());
//
//        Assertions.assertThat(accountReturn).isNotNull();
//        Assertions.assertThat(accountReturn.get().getId()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getEmail()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getPassword()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getLastName()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getFirstName()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getRoles()).isNotNull();
//        Assertions.assertThat(accountReturn.get().getAuthorities()).isNotNull();
//
//        Assertions.assertThat(accountReturn.get().getUsername()).isEqualTo(FELIZARDO.getUsername());
//        Assertions.assertThat(accountReturn.get().getEmail()).isEqualTo(FELIZARDO.getEmail());
//        Assertions.assertThat(accountReturn.get().getPassword()).isEqualTo(FELIZARDO.getPassword());
//        Assertions.assertThat(accountReturn.get().getAuthorities()).isEqualTo(FELIZARDO.getAuthorities());
//        Assertions.assertThat(accountReturn.get().getRoles()).isEqualTo(FELIZARDO.getRoles());
//        Assertions.assertThat(accountReturn.get().getFirstName()).isEqualTo(FELIZARDO.getFirstName());
//        Assertions.assertThat(accountReturn.get().getLastName()).isEqualTo(FELIZARDO.getLastName());
//    }
//
//    @Test
//    void findByEmail_ReturnEmpty() {
//        Optional<Account> accountReturn = repository.findByEmail(FELIZARDO.getEmail());
//
//        Assertions.assertThat(accountReturn).isEmpty();
//    }
}