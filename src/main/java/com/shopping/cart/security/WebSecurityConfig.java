package com.shopping.cart.security;

import com.shopping.cart.service.impl.UserServiceImpl;
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
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("SELECT email, password " +
//                        "FROM user " +
//                        "WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT u.email, u.role " +
//                        "FROM user u " +
//                        "WHERE u.username=?");
    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }
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
                .antMatchers("/signup").permitAll()
                .antMatchers("/signin").permitAll()
                .antMatchers("/user/create").permitAll()
                .antMatchers("/product/getByFilter").permitAll()
                .antMatchers("/product/sortProducts").permitAll()
                .antMatchers("/product/getAll").permitAll()
                .antMatchers("/shopping-carts/addProductInUserCart").permitAll()
//                .antMatchers("/signup").hasAnyAuthority("ROLE_USER, ROLE_ADMIN")
//                .antMatchers("/signin").hasAnyAuthority("0, 1")
//                .antMatchers("/**").permitAll()


//                .antMatchers("/user/create").permitAll()
//                .antMatchers("/product/getByFilter").permitAll()
//                .antMatchers("/product/sortProducts").permitAll()
//                .antMatchers("/product/getAll").permitAll()
//                .antMatchers("/product/").hasAnyAuthority("0")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        http
//                .authorizeRequests()
//                .antMatchers("/").hasAnyAuthority("0, 1")
//                .antMatchers("/addProduct").hasAnyAuthority("0, 1")
//                .antMatchers("/createProduct").hasAnyAuthority("0, 1")
//                .antMatchers("/createProductType").hasAnyAuthority("0, 1")
//                .antMatchers("/createUser").hasAnyAuthority("0, 1")
//                .antMatchers("/searchProduct").hasAnyAuthority("0, 1")
//                .antMatchers("/updateProductType").hasAnyAuthority("0, 1")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }
}