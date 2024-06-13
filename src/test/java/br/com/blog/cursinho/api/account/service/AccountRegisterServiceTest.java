package br.com.blog.cursinho.api.account.service;

import br.com.blog.cursinho.api.account.AccountRegisterForm;
import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.api.role.RoleRepository;
import br.com.blog.cursinho.shared.domain.Account;
import br.com.blog.cursinho.shared.domain.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountRegisterServiceTest {

    @InjectMocks
    private AccountRegisterService accountRegisterService;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BindingResult bindingResult;
    @Mock
    private AccountLoginService accountLoginService;

    private Account ACCOUNT;
    private Role ROLE_USER;

    @BeforeEach
    void setUp() {
        ROLE_USER = Role.builder()
                .id(BigInteger.valueOf(1))
                .name("ROLE_USER")
                .build();

        ACCOUNT = Account.builder()
                .id(BigInteger.valueOf(1))
                .email("email@email.com")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .roles(Set.of(ROLE_USER))
                .build();
    }

    @Test
    void createAccount_ReturnSuccess() {
        AccountRegisterForm ACCOUNT_REGISTER = AccountRegisterForm.builder()
                .email("email@email.com")
                .firstName("fistName")
                .lastName("lastName")
                .password("password")
                .confirmPassword("password")
                .build();
        Optional<Role> OPTIONAL_ROLE_USER = Optional.of(ROLE_USER);

        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(ACCOUNT);
        Mockito.when(roleRepository.findByName(Mockito.anyString())).thenReturn(OPTIONAL_ROLE_USER);

        ObjectError error = new ObjectError("senhas", "As senhas não são parecidas.");
        bindingResult.addError(error);

        ModelAndView response = accountRegisterService.execute(ACCOUNT_REGISTER, bindingResult);

        System.out.println(bindingResult.hasErrors());

        Assertions.assertNotNull(response);
        Assertions.assertEquals("auth/signin", response.getViewName());
        Assertions.assertEquals("{accountLoginForm=AccountLoginForm(email=email@email.com, password=password)}", response.getModel().toString());
    }
}