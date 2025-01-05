package com.skypath.skypath.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Test için CSRF korumasını devre dışı bırakıyoruz
                .authorizeHttpRequests() // Yeni metot: authorizeHttpRequests()
                .requestMatchers("/locations/create").authenticated() // Sadece authenticated kullanıcılar erişebilir
                .anyRequest().permitAll() // Diğer tüm isteklere izin ver
                .and()
                .httpBasic(); // Basic Auth kullanımı
        return http.build();
    }
}
