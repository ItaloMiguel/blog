package br.com.blog.cursinho.api.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search/item")
public class SearchController {

    @GetMapping
    public ModelAndView findQueryInTheDatabase(@RequestParam("query") String query) {
        ModelAndView modelAndView = new ModelAndView("home/query_found");

        modelAndView.addObject("found", query);

        return modelAndView;
    }

}
