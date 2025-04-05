package br.com.blog.site.api.account;

import org.springframework.stereotype.Component;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Builder
public class AccountAdminInfo {
    private String email;
    private String firstName;
    private String lastName;
}
