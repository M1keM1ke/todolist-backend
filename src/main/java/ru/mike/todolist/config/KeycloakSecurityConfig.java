package ru.mike.todolist.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakSecurityConfig {
    private static final String SERVER_URL = "http://localhost:9990/auth";
    private static final String REALM = "MOBILE_PROJECT";
    private static final String CLIENT_ID = "test-admin";
    private static final String USERNAME = "mike";
    private static final String PASSWORD = "12345";

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .clientId(CLIENT_ID)
                .grantType(OAuth2Constants.PASSWORD)
                .username(USERNAME)
                .password(PASSWORD)
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10)
                                .build()
                )
                .build();
    }
}
