package com.study.Board.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll() // 全ページへのアクセスを認証なしで許可
        )
        // Spring Securityのデフォルトログアウト処理を無効化
        .logout(logout -> logout.disable())
        .headers(headers -> headers.frameOptions(options -> options.disable()));

        return http.build();
    }
}
