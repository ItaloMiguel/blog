package br.com.blog.cursinho.api.account;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountLoginForm {
    private String email;
    private String password;
}
