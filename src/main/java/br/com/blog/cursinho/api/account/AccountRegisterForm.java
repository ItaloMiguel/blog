package br.com.blog.cursinho.api.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Builder
public class AccountRegisterForm {
    @NotBlank(message = "O campo email e obrigatorio")
    @NotNull(message = "O campo email e obrigatorio")
    private String email;

    @NotBlank(message = "O campo senha e obrigatorio")
    @NotNull(message = "O campo senha e obrigatorio")
    private String password;

    @NotBlank(message = "O campo confirma a senha e obrigatorio")
    @NotNull(message = "O campo confirma a senha e obrigatorio")
    private String confirmPassword;

    @NotBlank(message = "O campo primeiro nome e obrigatorio")
    @NotNull(message = "O campo primeiro nome e obrigatorio")
    private String firstName;

    private String lastName;
}
