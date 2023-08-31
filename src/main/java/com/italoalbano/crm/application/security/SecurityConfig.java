package com.italoalbano.crm.application.security;

import com.italoalbano.crm.application.views.list.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/api/auth/**")
                .permitAll()
                .and()
                .httpBasic();
        super.configure(http);
        setLoginView(http, LoginView.class);
    }

}
