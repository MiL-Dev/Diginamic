package fr.diginamic.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import fr.diginamic.hello.repositories.UserAccountRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return username -> userAccountRepository.findByUsername(username).asUserDetails();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/", "/login").permitAll()
                .requestMatchers("/logout").authenticated()
                .requestMatchers("/cityList", "/deleteCity/**").authenticated()
                .requestMatchers("/h2-console", "/h2-console/**").hasRole("ADMIN")
                .anyRequest().denyAll())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
//        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build();
//        System.out.println(admin.getPassword());
//        
//        userDetailsManager.createUser(user);
//        userDetailsManager.createUser(admin);
//        
//        return userDetailsManager;
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable());
//        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
//
//        http.authorizeHttpRequests(request -> request
//                .requestMatchers("/", "/login").permitAll()
//                .requestMatchers("/logout").authenticated()
//                .requestMatchers("/cityList", "/deleteCity/**").authenticated()
//                .requestMatchers("/h2-console", "/h2-console/**").hasRole("ADMIN")
//                .anyRequest().denyAll())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//
//        return http.build();
//    }
}