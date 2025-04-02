package br.com.blog.site.shared.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfiguration {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final String[] WHITELIST = {
            "/app/signup",
            "/about",
            "/app/search/**",
            "/app/home",
            "/",
    };

    private static final String[] ADMIN_PAGES = {
            "/app/admin",
            "/app/admin/**",
    };

    private static final String[] PATH = {
            "resources/**",
            "templates/**",
            "/css/**",
            "/js/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /*
                * Essa parte é utilizada para liberar novos cominhos de requisição.
                * Tenha cuidado para mexer aqui!
                * */
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(PATH).permitAll()
                        .requestMatchers(WHITELIST).permitAll()
                        .requestMatchers(ADMIN_PAGES).hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((loginConfigurer) -> loginConfigurer
                        .loginPage("/app/signin")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/app/signin?error").permitAll()
                )
                .logout((logoutConfigurer) -> logoutConfigurer
                        .logoutUrl("/app/logout")
                        .logoutSuccessUrl("/app/signin?logout")
                )
                .httpBasic();

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
