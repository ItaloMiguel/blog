package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.api.account.service.AccountRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountRegisterService accountRegisterService;

    @GetMapping("/signin")
    public ModelAndView getSingninView() {
        log.info("[GET] Get singnin view.");

        AccountLoginForm accountLoginForm = new AccountLoginForm();

        ModelAndView modelAndView = new ModelAndView("auth/signin");
        modelAndView.addObject("accountLoginForm", accountLoginForm);

        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView getSignupView() {
        log.info("[GET] Get signup view.");

        ModelAndView modelAndView = new ModelAndView("auth/signup");
        AccountRegisterForm accountRegister = new AccountRegisterForm();
        modelAndView.addObject("accountRegister", accountRegister);

        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView sendRegisterView(@ModelAttribute @Valid AccountRegisterForm accountDTO, BindingResult bindingResult) {
        log.info("[POST] Receiving registration request.");
        return accountRegisterService.execute(accountDTO, bindingResult);
    }

}
