package fr.slickteam.springbootdevservices.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);
        http.authorizeHttpRequests(authorizeHttpRequestsConfigurer())
            .cors(httpSecurityCorsConfigurer())
            .csrf(csrfConfigurer())
            .oauth2ResourceServer(oAuth2ResourceServerConfigurer())
            .sessionManagement(httpSecuritySessionManagementConfigurer());
        return http.build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authorizeHttpRequestsConfigurer() {
        return authorize ->
                authorize.requestMatchers(HttpMethod.GET, "/shelves/**").permitAll()
                         .requestMatchers(HttpMethod.GET, "/books/**").permitAll()
                         .anyRequest().authenticated();
    }

    private static Customizer<CsrfConfigurer<HttpSecurity>> csrfConfigurer() {
        return AbstractHttpConfigurer::disable;
    }

    private Customizer<OAuth2ResourceServerConfigurer<HttpSecurity>> oAuth2ResourceServerConfigurer() {
        return oAuth2 -> oAuth2.jwt(jwtConfigurer());
    }

    private Customizer<OAuth2ResourceServerConfigurer<HttpSecurity>.JwtConfigurer> jwtConfigurer() {
        return jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter);
    }

    private static Customizer<SessionManagementConfigurer<HttpSecurity>> httpSecuritySessionManagementConfigurer() {
        return sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private static Customizer<CorsConfigurer<HttpSecurity>> httpSecurityCorsConfigurer() {
        return cors -> {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.addAllowedOriginPattern(CorsConfiguration.ALL);
            config.addAllowedHeader(CorsConfiguration.ALL);
            config.addAllowedMethod(CorsConfiguration.ALL);
            source.registerCorsConfiguration("/**", config);
            cors.configurationSource(source);
        };
    }

}