package br.com.blog.cursinho.api.account.service;

import br.com.blog.cursinho.api.account.AccountFactory;
import br.com.blog.cursinho.api.account.AccountRegisterForm;
import br.com.blog.cursinho.api.account.AccountRepository;
import br.com.blog.cursinho.api.role.RoleRepository;
import br.com.blog.cursinho.shared.domain.Account;
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


    public ModelAndView execute(AccountRegisterForm accountRegisterForm, BindingResult bindingResult) {
        this.bindingResultHaveErrors(bindingResult);
        this.passwordIsEquals(accountRegisterForm);

        if (!errorMessages.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("redirect:/authenticate");

            modelAndView.addObject("errorMessages", errorMessages);
            modelAndView.addObject("account", accountRegisterForm);

            return modelAndView;
        }

        this.saveAccount(accountRegisterForm);

        return new ModelAndView("redirect:/");
    }

    private void saveAccount(AccountRegisterForm accountDTO) {
        log.info("Save account in the database");

        Account account = new AccountFactory(accountDTO)
                .setPasswordEncoder()
                .makeUser(roleRepository)
                .build();

        successMessages.add("Cadastro realizado com sucesso.");

        accountRepository.save(account);
    }

    private void bindingResultHaveErrors(BindingResult bindingResult) {
        log.info("Checking the registration request");

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                errorMessages.add(objectError.getDefaultMessage());
            }
        }
    }

    private void passwordIsEquals(AccountRegisterForm accountDto) {
        log.info("Checking if password and confirmPassword is equals");

        var password = accountDto.getPassword();
        var confirmPassword = accountDto.getConfirmPassword();

        if(!password.equals(confirmPassword)) {
            errorMessages.add("Senhas não são parecidas.");
        }
    }
}
