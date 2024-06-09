package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.api.account.service.AccountRegisterService;
import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import br.com.blog.cursinho.shared.security.WebSecurityConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(properties = {"DB_NAME=myblog_test","spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureMockMvc
@Import(WebSecurityConfiguration.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRegisterService service;

    private Account USER_MODEL;

    private Role ROLE_USER;

    @BeforeEach
    void setup() {
        ROLE_USER = new Role(1L, "ROLE_USER");

        USER_MODEL = new Account(
                1L,
                "email@email.com",
                "password",
                "firstName",
                "lastName",
                Set.of(ROLE_USER)
        );
    }

    @Test
    void shouldReturn200AndSuccessfully() throws Exception {
        String fistNameParam = "firstName";
        String emailParam = "email";

        mockMvc.perform(get("/app/signin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("auth/signin"));
    }

    @Test
    void shouldRegisterAccountInSystem() throws Exception {
        var account = new AccountRegisterForm(
                "email@email.com",
                "password",
                "password",
                "lastName",
                "lastName"
        );

        var requestBuilder = post("/app/signup")
                .param("firstName", account.getFirstName())
                .param("lastName", account.getLastName())
                .param("email", account.getEmail())
                .param("password", account.getPassword())
                .param("confirmPassword", account.getConfirmPassword())
                .with(csrf());

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void shouldNotRegisterAccountInSystemBecausePasswordIsNotEquals() throws Exception {
        var account = new AccountRegisterForm(
                "email@email.com",
                "password",
                "password1",
                "lastName",
                "lastName"
        );


        var requestBuilder = post("/app/signup")
                .param("firstName", account.getFirstName())
                .param("lastName", account.getLastName())
                .param("email", account.getEmail())
                .param("password", account.getPassword())
                .param("confirmPassword", account.getConfirmPassword())
                .with(csrf());

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void shouldNotRegisterAccountInSystemBecauseEmailInstBeingSentAndPasswordNotEquals() throws Exception {
        var account = new AccountRegisterForm(
                null,
                "password",
                "password1",
                "lastName",
                "lastName"
        );


        var requestBuilder = post("/app/signup")
                .param("firstName", account.getFirstName())
                .param("lastName", account.getLastName())
                .param("email", account.getEmail())
                .param("password", account.getPassword())
                .param("confirmPassword", account.getConfirmPassword())
                .with(csrf());
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}