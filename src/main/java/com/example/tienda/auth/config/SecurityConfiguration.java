package com.example.tienda.auth.config;

import com.example.tienda.auth.filter.JwtRequestFilter;
import com.example.tienda.auth.service.UserDetailsCustomService;
import com.example.tienda.enums.RoleName;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsCustomService).passwordEncoder(this.passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers(
                        //Auth:
                        Url.AUTH + "/login", Url.AUTH + "/register",
                        //Documentation:
                        "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**"
                ).permitAll()


                //Users:
                .antMatchers(Url.USERS, Url.USERS + "/*").hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                //Categories:
                .antMatchers(HttpMethod.POST, Url.CATEGORIES).hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.PUT, Url.CATEGORIES).hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, Url.CATEGORIES + "/{id}").hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.GET, Url.CATEGORIES).permitAll()
                .antMatchers(HttpMethod.GET, Url.CATEGORIES + "/{id}").permitAll()
                //Products:
                .antMatchers(HttpMethod.POST, Url.PRODUCTS).hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.PUT, Url.PRODUCTS).hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, Url.PRODUCTS + "/{id}").hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.GET, Url.PRODUCTS).permitAll()
                .antMatchers(HttpMethod.GET, Url.PRODUCTS + "/{id}").permitAll()
                //Orders:
                .antMatchers(HttpMethod.POST, Url.ORDERS).hasAnyAuthority(RoleName.ROLE_ADMIN.toString(), RoleName.ROLE_USER.toString())
                .antMatchers(HttpMethod.GET, Url.ORDERS).hasAnyAuthority(RoleName.ROLE_ADMIN.toString())
                .antMatchers(HttpMethod.GET, Url.ORDERS + "/{id}").hasAnyAuthority(RoleName.ROLE_ADMIN.toString(), RoleName.ROLE_USER.toString())

                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
