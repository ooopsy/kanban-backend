package com.example.kanban.util;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TokenUtil {
	public static AccessToken getAccessToken() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) authentication;
		@SuppressWarnings("unchecked")
		KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>)token.getPrincipal();
        KeycloakSecurityContext context = keycloakPrincipal.getKeycloakSecurityContext();
		return context.getToken();
	}
}
