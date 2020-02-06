package com.shopping.cart.security;

import com.shopping.cart.model.domain.enums.RoleName;
import com.shopping.cart.model.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;
    private final JwtAuthEntryPoint unauthorizedHandler;

    @Autowired
    public WebSecurityConfig(UserServiceImpl userService, JwtAuthEntryPoint unauthorizedHandler) {
        this.userService = userService;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
//                .antMatchers("/**").permitAll()
                .antMatchers("/user/create").permitAll()
                .antMatchers("/user/signin").permitAll()
                .antMatchers("/user/find").hasAuthority("ROLE_ADMIN")
                .antMatchers("/user/delete").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/create").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/update").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/delete/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/getAll").permitAll()
                .antMatchers("/product/getByFilter").permitAll()
                .antMatchers("/product/sortProducts").permitAll()
                .antMatchers("/shopping-carts/getItemsByUserId/**").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .antMatchers("/shopping-carts/createCart").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .antMatchers("/shopping-carts/deleteItems/**").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .antMatchers("/cart-item/create").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .antMatchers("/cart-item/getItemsById").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .antMatchers("/cart-item/getAllPendingItems").hasAuthority("ROLE_ADMIN")
                .antMatchers("/cart-item/approvedItems").hasAuthority("ROLE_ADMIN")
                .antMatchers("/cart-item/deleteItem").hasAnyAuthority("ROLE_USER" , "ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}