package br.com.blog.site.api.account;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.site.api.account.service.AccountGetUsers;
import br.com.blog.site.api.account.service.AccountLoginService;
import br.com.blog.site.api.account.service.AccountRegisterService;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final AccountRegisterService accountRegisterService;
    private final AccountLoginService accountLoginService;
    private final AccountGetUsers accountGetUsers;

    @GetMapping("/signin")
    public ModelAndView getSigninView() {
        log.info("[GET] Get signin view.");
        
        List<AccountAdminInfo> accountAdminInfos = accountGetUsers.execute();

        System.out.println(accountAdminInfos);

        AccountLoginForm accountLoginForm = new AccountLoginForm();

        return new ModelAndView("auth/signin")
                .addObject("accountLoginForm", accountLoginForm);
    }

    @PostMapping("/signin")
    public ModelAndView postSigninView(@ModelAttribute @Valid AccountLoginForm accountLoginForm,
                                       BindingResult bindingResult) {
        log.info("[POST] Post signin view.");

        if (bindingResult.hasErrors()) {
            log.error("Validation errors: " + bindingResult.getAllErrors());
            return new ModelAndView("auth/signin")
                    .addObject("accountLoginForm", accountLoginForm)
                    .addObject("errors", bindingResult.getAllErrors());
        }

        log.info("INFO USER: " + accountLoginForm);

        return accountLoginService.execute(accountLoginForm);
    }

    @GetMapping("/signup")
    public ModelAndView getSignupView() {
        log.info("[GET] Get signup view.");

        AccountRegisterForm accountRegisterForm = new AccountRegisterForm();

        return new ModelAndView("auth/signup")
                .addObject("accountRegisterForm", accountRegisterForm);
    }

    @PostMapping("/signup")
    public ModelAndView sendRegisterView(@ModelAttribute @Valid AccountRegisterForm accountRegisterForm, @Valid BindingResult bindingResult) {
        log.info("[POST] Receiving registration request.");
        return accountRegisterService.execute(accountRegisterForm, bindingResult);
    }

}
