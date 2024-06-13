package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.CursinhoApplication;
import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

@SpringBootTest(classes = CursinhoApplication.class)
@AutoConfigureMockMvc
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private Role ROLE_USER;

    private Account FELIZARDO;


    @BeforeEach
    void setupBefore() {
        // Arrange
        ROLE_USER = Role.builder()
                .id(BigInteger.valueOf(1))
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

    @Test
    void saveAccount_ReturnAccountSaved() {
        Account accountReturn = accountRepository.save(FELIZARDO);

        Assertions.assertThat(accountReturn).isNotNull();
        Assertions.assertThat(accountReturn.getId()).isGreaterThanOrEqualTo(BigInteger.valueOf(1));
    }

    @Test
    public void testFindByEmail() {
        Optional<Account> account = accountRepository.findByEmail("user1@example.com");
        Assert.isTrue(account.isPresent(), "Account should be found");
    }

    @Test
    void shouldntSaveAccount_BecauseAlreadyExists_ReturnError() {
        accountRepository.save(FELIZARDO);

        try {
            accountRepository.save(FELIZARDO);
        } catch (Exception exception) {
            org.junit.jupiter.api.Assertions.assertNotNull(exception);
            org.junit.jupiter.api.Assertions.assertNull(exception.getMessage());
        }
    }

    @Test
    void findByEmail_ReturnAccount() {
        accountRepository.save(FELIZARDO);
        Optional<Account> accountReturn = accountRepository.findByEmail(FELIZARDO.getEmail());

        Assertions.assertThat(accountReturn).isNotNull();
        Assertions.assertThat(accountReturn.get().getId()).isNotNull();
        Assertions.assertThat(accountReturn.get().getEmail()).isNotNull();
        Assertions.assertThat(accountReturn.get().getPassword()).isNotNull();
        Assertions.assertThat(accountReturn.get().getLastName()).isNotNull();
        Assertions.assertThat(accountReturn.get().getFirstName()).isNotNull();
        Assertions.assertThat(accountReturn.get().getRoles()).isNotNull();
        Assertions.assertThat(accountReturn.get().getAuthorities()).isNotNull();

        Assertions.assertThat(accountReturn.get().getUsername()).isEqualTo(FELIZARDO.getUsername());
        Assertions.assertThat(accountReturn.get().getEmail()).isEqualTo(FELIZARDO.getEmail());
        Assertions.assertThat(accountReturn.get().getPassword()).isEqualTo(FELIZARDO.getPassword());
        Assertions.assertThat(accountReturn.get().getAuthorities()).isEqualTo(FELIZARDO.getAuthorities());
        Assertions.assertThat(accountReturn.get().getRoles()).isEqualTo(FELIZARDO.getRoles());
        Assertions.assertThat(accountReturn.get().getFirstName()).isEqualTo(FELIZARDO.getFirstName());
        Assertions.assertThat(accountReturn.get().getLastName()).isEqualTo(FELIZARDO.getLastName());
    }

    @Test
    void findByEmail_ReturnEmpty() {
        Optional<Account> accountReturn = accountRepository.findByEmail(FELIZARDO.getEmail());

        Assertions.assertThat(accountReturn).isEmpty();
    }
}