package br.com.blog.site.api.account;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class AccountLoginForm {
    private String email;
    private String password;

    public AccountLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
