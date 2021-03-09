package ru.metelev.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailService = new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();

//        User.UserBuilder builder = User.withUsername("user2");
//
//        UserDetails u2 = builder
//                .password("12345")
//                .authorities("read", "write")
//                .passwordEncoder(p -> passwordEncoder().encode(p))
//                .accountExpired(false)
//                .disabled(true)
//                .build();

        userDetailService.createUser(user);
        return userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
