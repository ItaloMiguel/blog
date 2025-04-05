package br.com.blog.site.api.account.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.site.api.account.AccountLoginForm;

@Slf4j
@Service
@AllArgsConstructor
public class AccountLoginService {

    private final UserDetailsServiceImpl userDetailsService;

    public ModelAndView execute(AccountLoginForm accountLoginForm) {
        userDetailsService.loadUserByUsername(accountLoginForm.getEmail());
        return new ModelAndView("redirect:/");
    }
}
