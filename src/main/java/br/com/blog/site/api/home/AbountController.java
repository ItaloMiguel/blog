package br.com.blog.site.api.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AbountController {

    @GetMapping("/about-page")
    public ModelAndView getAboutPageView() {
        return new ModelAndView("about/about_page");
    }

    @GetMapping("/abount-me")
    public ModelAndView getAboutMeView() {
        return new ModelAndView("about/about_me");
    }
}
