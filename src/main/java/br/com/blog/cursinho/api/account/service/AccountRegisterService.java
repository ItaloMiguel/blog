package br.com.blog.cursinho.api.account.service;

import br.com.blog.cursinho.api.account.AccountFactory;
import br.com.blog.cursinho.api.account.AccountLoginForm;
import br.com.blog.cursinho.api.account.AccountRegisterForm;
import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.api.role.RoleRepository;
import br.com.blog.cursinho.shared.domain.Account;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AccountRegisterService {

    private final List<String> errorMessages = new ArrayList<>();
    private final List<String> successMessages = new ArrayList<>();

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AccountLoginService accountLoginService;


    public ModelAndView execute(AccountRegisterForm accountRegisterForm, BindingResult bindingResult) {
        this.passwordIsEquals(accountRegisterForm, bindingResult);
        this.verifyBindingResult(accountRegisterForm, bindingResult);

        Account account = this.saveAccount(accountRegisterForm);
        AccountLoginForm accountLoginForm = new AccountLoginForm(account.getEmail(), account.getPassword());

        return new ModelAndView("auth/signin").addObject("accountLoginForm", accountLoginForm);
    }

    @Transactional
    private Account saveAccount(AccountRegisterForm accountDTO) {
        log.info("Save account in the database");

        Account account = new AccountFactory(accountDTO)
                .makeUser(roleRepository)
                .build();

        return accountRepository.save(account);
    }

    private void passwordIsEquals(AccountRegisterForm accountRegisterForm, BindingResult bindingResult) {
        log.info("Checking if password and confirmPassword is equals");

        String password = accountRegisterForm.getPassword();
        String confirmPassword = accountRegisterForm.getConfirmPassword();

        if(!password.equals(confirmPassword)) {
            ObjectError error = new ObjectError("password", "As senhas não são parecidas.");
            bindingResult.addError(error);
        }
    }

    private ModelAndView verifyBindingResult(AccountRegisterForm accountRegisterForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Validation errors: " + bindingResult.getAllErrors());
            return new ModelAndView("auth/signup")
                    .addObject("accountRegisterForm", accountRegisterForm)
                    .addObject("errors", bindingResult.getAllErrors());
        }
        return null;
    }
}
