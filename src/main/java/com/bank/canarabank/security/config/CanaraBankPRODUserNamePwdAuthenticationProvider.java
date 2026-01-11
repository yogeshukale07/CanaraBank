package com.bank.canarabank.security.config;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class CanaraBankPRODUserNamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CanaraBankUserDetailsService canaraBankUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String uname = authentication.getName();
        String pwd = (String) authentication.getCredentials();

        UserDetails userDetails = canaraBankUserDetailsService.loadUserByUsername(uname);
        if (passwordEncoder.matches(pwd, userDetails.getPassword())) {
            //Our Custom login for authentication we can write here.
            return new UsernamePasswordAuthenticationToken(uname, pwd, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("InValid Password");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
