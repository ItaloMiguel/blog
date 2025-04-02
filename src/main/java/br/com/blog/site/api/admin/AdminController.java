package br.com.blog.site.api.admin;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.site.shared.domain.Account;
import br.com.blog.site.shared.domain.UserAuthenticate;

import java.security.Principal;

@Controller
@RequestMapping
public class AdminController {

    @GetMapping("/app/admin")
    public ModelAndView getAdminView(Principal principal) {
        return new ModelAndView("admin/index");
    }

    @GetMapping("/app/admin/posts")
    public ModelAndView getPostsView() {
        return new ModelAndView("admin/posts");
    }
}
