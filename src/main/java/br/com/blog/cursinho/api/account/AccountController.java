package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.api.account.service.AccountRegisterService;
import br.com.blog.cursinho.api.account.service.AccountLoginService;
import br.com.blog.cursinho.api.account.service.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final AccountLoginService accountLoginService;
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/signin")
    public ModelAndView getSigninView() {
        log.info("[GET] Get signin view.");

        System.out.println("CARALHO ISSO TA SENDO CHAMADOOOO 3 VEZES POR QUE CARALHOOOOOOOOOOOO??????????");


        AccountLoginForm accountLoginForm = new AccountLoginForm();

        return new ModelAndView("auth/signin")
                .addObject("accountLoginForm", accountLoginForm);
    }

    @PostMapping("/signin")
    public ModelAndView postSigninView(@ModelAttribute @Valid AccountLoginForm accountLoginForm,
                                       BindingResult bindingResult) {
        log.info("[POST] Post signin view.");

        return accountLoginService.execute(accountLoginForm, bindingResult);
    }

    @GetMapping("/signup")
    public ModelAndView getSignupView() {
        log.info("[GET] Get signup view.");

        AccountRegisterForm accountRegisterForm = new AccountRegisterForm();

        return new ModelAndView("auth/signup")
                .addObject("accountRegisterForm", accountRegisterForm);
    }

    @PostMapping("/signup")
    public ModelAndView sendRegisterView(@ModelAttribute @Valid AccountRegisterForm accountRegisterForm, BindingResult bindingResult) {
        log.info("[POST] Receiving registration request.");

        return accountRegisterService.execute(accountRegisterForm, bindingResult);
    }

}
