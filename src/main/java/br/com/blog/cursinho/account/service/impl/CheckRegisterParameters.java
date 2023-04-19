package br.com.blog.cursinho.account.service.impl;

import br.com.blog.cursinho.account.dto.AccountRegisterRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CheckRegisterParameters {

    private final List<String> errorMessages = new ArrayList<>();

    public List<String> execute(AccountRegisterRequestDTO accountDTO, BindingResult bindingResult) {
        bindingResultHaveErrors(bindingResult);
        passwordIsEquals(accountDTO);

        return errorMessages;
    }

    private void bindingResultHaveErrors(BindingResult bindingResult) {
        log.info("Checking the registration request");

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                errorMessages.add(objectError.getDefaultMessage());
            }
        }
    }

    private void passwordIsEquals(AccountRegisterRequestDTO accountDto) {
        log.info("Checking if password and confirmPassword is equals");

        var password = accountDto.getPassword();
        var confirmPassword = accountDto.getConfirmPassword();

        if(!password.equals(confirmPassword)) {
            errorMessages.add("Passwords aren't equals");
        }
    }
}
