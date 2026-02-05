package com.bank.canarabank.event;

import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationEvents {
    @EventListener
    public void onFailure(AuthorizationDeniedEvent authorizationDeniedEvent) {
        System.out.println("Authorization Denied for user : " + authorizationDeniedEvent.getAuthentication().get().getName() + " AuthDecision-> " + authorizationDeniedEvent.getAuthorizationResult().toString());
    }
}
