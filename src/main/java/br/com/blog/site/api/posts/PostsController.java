package br.com.blog.site.api.posts;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
@Slf4j
public class PostsController {
    @GetMapping("/new_post")
    public ModelAndView getPostView() {
        log.info("[GET] Get signup view.");
        
        PostForm postForm = new PostForm();

        return new ModelAndView("post/make_post")
                .addObject("postForm", postForm);
    }

    @PostMapping("/new_post")
    public ModelAndView postPostView(@ModelAttribute @Valid PostForm postForm,
                                       BindingResult bindingResult) {
        log.info("[POST] Post New Post.");

        if (bindingResult.hasErrors()) {
            log.error("Validation errors: " + bindingResult.getAllErrors());
            return new ModelAndView("app/new_post")
                    .addObject("postForm", postForm)
                    .addObject("errors", bindingResult.getAllErrors());
        }

        return new ModelAndView("home/index");
    }
}
