package br.com.blog.cursinho.account.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountLoginRequestDTO {
    private String email;
    private String password;
}
