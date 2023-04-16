package br.com.blog.cursinho.account.controller;

import br.com.blog.cursinho.account.dto.AccountRequestDTO;
import br.com.blog.cursinho.account.service.RegisterAccountService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AuthController {

    private final RegisterAccountService accountService;

    public AuthController(RegisterAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public ModelAndView getLoginView() {
        return new ModelAndView("auth/login");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterView() {
        ModelAndView modelAndView = new ModelAndView("auth/register");

        AccountRequestDTO account = new AccountRequestDTO();
        modelAndView.addObject("account", account);

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView sendRegisterView(@ModelAttribute @Valid AccountRequestDTO accountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("auth/register");
        }

        accountService.saveAccount(accountDto);
        return new ModelAndView("redirect:/");
    }

}
