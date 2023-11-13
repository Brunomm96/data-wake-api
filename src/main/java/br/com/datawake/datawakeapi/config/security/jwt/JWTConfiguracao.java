package br.com.datawake.datawakeapi.config.security.jwt;

import br.com.datawake.datawakeapi.property.AppProperties;
import br.com.datawake.datawakeapi.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppProperties myAppProperties;

    private String originPermitida;

    @Autowired
    private AppUserDetailsService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors();
        http
            // remove csrf and state in session because in jwt we do not need them
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // add jwt filters (1. authentication, 2. authorization)
            .addFilter(new JWTAutenticarFilter(authenticationManager(), usuarioService))
            .addFilter(new JWTValidarFilter(authenticationManager()))
            .authorizeRequests()
            // configure access rules
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/api/swagger-ui", "/api/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs",  "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll()
            .anyRequest().authenticated();

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        List<String> allowedOrigins = new ArrayList<String>();
        List<String> allowedHeaders = new ArrayList<String>();
        List<String> allowedMethods = new ArrayList<String>();
        originPermitida = myAppProperties.getCorsAllowOrigin();
        List<String> originsAllow = new ArrayList<String>();
        originsAllow.addAll( Arrays.asList(originPermitida.split(";")) );

        for ( String origin : originsAllow ) {
            allowedOrigins.add(origin);
        }

        allowedHeaders.add("*");
        allowedMethods.add("POST");
        allowedMethods.add("DELETE");
        allowedMethods.add("PUT");
        allowedMethods.add("GET");
        allowedMethods.add("HEAD");
        allowedMethods.add("OPTIONS");
        allowedMethods.add("PATCH");

        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(allowedOrigins);
        corsConfiguration.setAllowedHeaders(allowedHeaders);
        corsConfiguration.setAllowedMethods(allowedMethods);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
