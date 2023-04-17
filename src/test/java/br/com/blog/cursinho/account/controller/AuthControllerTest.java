package br.com.blog.cursinho.account.controller;

import br.com.blog.cursinho.account.dto.AccountRegisterRequestDTO;
import br.com.blog.cursinho.account.service.RegisterAccountService;
import br.com.blog.cursinho.account.service.impl.CheckRegisterParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class AuthControllerTest {

    private MockMvc mockMvc;

    private AuthController authController;

    @InjectMocks
    private RegisterAccountService accountService;

    @InjectMocks
    private CheckRegisterParameters checkRegisterParameters;

    @BeforeEach
    void beforeEach() {
        authController = new AuthController(accountService, checkRegisterParameters, userDetailsService);
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }


    @Test
    public void testGetLoginView() throws Exception {
        Assertions.assertNotNull(authController);

        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("auth/login"));
    }

    @Test
    public void testGetRegisterView() throws Exception {
        Assertions.assertNotNull(authController);

        this.mockMvc.perform(get("/register"))
                .andDo(print())
                .andExpect(redirectedUrl(null))
                .andExpect(status().is(200))
                .andExpect(view().name("auth/register"));
    }

    @Test
    public void testSendRegisterView() throws Exception {
        Assertions.assertNotNull(authController);

        this.mockMvc.perform(
                        post("/register")
                                .content(String.valueOf(new AccountRegisterRequestDTO(
                                        "emailcomum@gmail.com",
                                        "password",
                                        "password",
                                        "fistName",
                                        "lastName")
                                ))
                ).andDo(print())
                .andExpect(status().is(200))
                .andExpect(view().name("auth/register"));
    }

    @Test
    public void testSendRegisterViewWithoutEmail() throws Exception {
        Assertions.assertNotNull(authController);

        this.mockMvc.perform(
                        post("/register")
                                .content(String.valueOf(new AccountRegisterRequestDTO(
                                        null,
                                        "password",
                                        "password",
                                        "fistName",
                                        "lastName")
                                ))
                ).andDo(print())
                .andExpect(status().is(200))
                .andExpect(view().name("auth/register"));
    }


}