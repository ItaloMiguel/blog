package br.com.blog.cursinho.account.dto;

import jakarta.validation.constraints.Min;
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
public class AccountRegisterRequestDTO {
    @NotBlank(message = "The 'email' field cannot be blank")
    @NotNull(message = "The 'email' field cannot be null")
    private String email;

    @NotBlank(message = "The 'password' field cannot be blank")
    @NotNull(message = "The 'password' field cannot be null")
    private String password;

    @NotBlank(message = "The 'confirm password' field cannot be blank")
    @NotNull(message = "The 'confirm password' field cannot be null")
    private String confirmPassword;

    @NotBlank(message = "The 'first name' field cannot be blank")
    @NotNull(message = "The 'first name' field cannot be null")
    private String firstName;

    private String lastName;
}
