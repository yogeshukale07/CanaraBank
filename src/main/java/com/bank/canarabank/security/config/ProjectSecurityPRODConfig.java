package com.bank.canarabank.security.config;

import com.bank.canarabank.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class ProjectSecurityPRODConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        http.csrf(hscc -> hscc.disable())
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests(req -> req.requestMatchers("/myAccount").hasAuthority("VIEWACCOUNTS")
                /*.requestMatchers("/myBalance").hasAuthority("VIEWBALANCE")
                .requestMatchers("/myLoans").hasAuthority("VIEWLOANS")
                .requestMatchers("/myCards").hasAuthority("VIEWCARDS")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/contact", "/notices", "/register").permitAll());*/
                .requestMatchers("/myBalance").hasRole("ADMIN")
                .requestMatchers("/myLoans").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/myCards").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/contact", "/notices", "/register").permitAll());

        http.formLogin(withDefaults());

        http.httpBasic(withDefaults());

        return http.build();
    }

    /* This for InMemoryUserDetailsService
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails defaultUserDetails = User.withUsername("canara").password("{noop}canara").authorities("read").build();
        UserDetails sonaliUserDetails = User.withUsername("Sonali").password("{bcrypt}$2a$12$cVsMMarsR/.sRe35Feluw.YOZhABn1rji5Z.FDCZQJKkZMZprCEGu").authorities("read").build();
        UserDetails yogeshUserDetails = User.withUsername("Yogesh").password("{bcrypt}$2a$12$cVauph61oWwtaQufaJPwousFaH/rss5Z.WLs.bZinmdxFlLhe0Mji").authorities("read").build();
        return new InMemoryUserDetailsManager(defaultUserDetails, sonaliUserDetails, yogeshUserDetails);
    }*/

    //@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //@Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    //This bean is require if we want to change default "ROLE_" then we can do as below
    //@Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("CNBROLE_");
    }
}
