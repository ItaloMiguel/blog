package br.com.blog.site.api.account.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.site.api.account.AccountLoginForm;
import br.com.blog.site.api.account.AccountRegisterForm;
import br.com.blog.site.api.account.AccountRepository;
import br.com.blog.site.api.role.RoleRepository;

import java.util.ArrayList;
import java.util.List;

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
