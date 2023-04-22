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
public class AccountRegisterForm {
    @NotBlank(message = "O campo email é obrigatório")
    @NotNull(message = "O campo email é obrigatório")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório")
    @NotNull(message = "O campo senha é obrigatório")
    private String password;

    @NotBlank(message = "O campo confirma a senha é obrigatório")
    @NotNull(message = "O campo confirma a senha é obrigatório")
    private String confirmPassword;

    @NotBlank(message = "O campo primeiro nome é obrigatório")
    @NotNull(message = "O campo primeiro nome é obrigatório")
    private String firstName;

    private String lastName;
}
