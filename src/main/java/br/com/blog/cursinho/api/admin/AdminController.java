package br.com.blog.cursinho.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AdminController {

    @GetMapping("/app/admin")
    public ModelAndView getAdminView() {
        return new ModelAndView("admin/index");
    }

    @GetMapping("/app/posts")
    public ModelAndView getPostsView() {
        return new ModelAndView("admin/posts");
    }
}
