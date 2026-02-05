package com.bank.canarabank.event;


import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        System.out.println("Login Successful for user : " + authenticationSuccessEvent.getAuthentication().getName());
    }
    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent authenticationFailureEvent) {
        System.out.println("Login Failed for user : " + authenticationFailureEvent.getAuthentication().getName());
    }
}
