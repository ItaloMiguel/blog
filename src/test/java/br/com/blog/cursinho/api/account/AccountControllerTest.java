package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import br.com.blog.cursinho.shared.security.WebSecurityConfiguration;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(properties = {"DB_NAME=cursinho_test","spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureMockMvc
//@Import(WebSecurityConfiguration.class)
//@WebMvcTest(AccountController.class)
@AutoConfigureTestEntityManager
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

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
         mockMvc.perform(get("/authenticate"))
                 .andExpect(status().isOk())
                 .andExpect(view().name("auth/authenticate"))
                 .andExpect(model().attributeExists("accountRegister"));
    }

    @Test
    void shouldRegisterAccountInSystem() throws Exception {
        var account = new AccountRegisterForm(
                "email@email.com",
                "password",
                "firstName",
                "lastName",
                "lastName"
        );

        mockMvc.perform(post("/signup")
                        .param("firstName", account.getFirstName())
                        .param("lastName", account.getLastName())
                        .param("email", account.getEmail())
                        .param("password", account.getPassword())
                        .param("confirmPassword", account.getConfirmPassword())
                        .with(csrf())
                ).andExpect(status().is3xxRedirection());
    }
}