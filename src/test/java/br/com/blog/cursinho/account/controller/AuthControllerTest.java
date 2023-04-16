package br.com.blog.cursinho.account.controller;

import br.com.blog.cursinho.account.dto.AccountRequestDTO;
import br.com.blog.cursinho.account.service.RegisterAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
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

    @BeforeEach
    void beforeEach() {
        authController = new AuthController(accountService);
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
                                .content(String.valueOf(new AccountRequestDTO(
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
                                .content(String.valueOf(new AccountRequestDTO(
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