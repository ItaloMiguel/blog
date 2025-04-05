package br.com.blog.site.api.posts;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class PostForm {
    private String title;
    private String text_post;    

    public PostForm(String title, String text_post) {
        this.title = title;
        this.text_post = text_post;       
    }
}

