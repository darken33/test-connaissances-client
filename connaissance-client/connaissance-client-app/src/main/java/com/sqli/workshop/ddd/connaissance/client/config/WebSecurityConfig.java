package com.sqli.workshop.ddd.connaissance.client.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@OpenAPIDefinition(info = @Info(title = "Connaissance CLient", version = "v1"), security = { @SecurityRequirement(name = "Authorization") })
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class WebSecurityConfig {

    private static String urlPublicKey = "http://0.0.0.0:8090/realms/master/protocol/openid-connect/certs";

    @Bean
    public JwtIssuerAuthenticationManagerResolver authenticationManagerResolver() {
        return new JwtIssuerAuthenticationManagerResolver(s -> {
                JwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(urlPublicKey).build();
                var var10000 = new JwtAuthenticationProvider(jwtDecoder);

                return var10000::authenticate;
        });
    }

    /**
     * {@inheritDoc}
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .authorizeRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver()));

		/*
		 * Ajout du header CSP pour éviter le chargement de ressources autre qu'en provenance de l'application
		 * Exceptions (pour affichage par swagger) :
		 *      - Autorisation des styles inline:
		 *      - Autorisation des images data:
		 */
		httpSecurity.headers().addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", "default-src 'self'; style-src 'self' 'unsafe-inline'; img-src 'self' data:;"));
		return httpSecurity.build();
    }

}
