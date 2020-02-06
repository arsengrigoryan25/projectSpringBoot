package com.shopping.cart.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.cart.model.domain.enums.ErrorMessageEnum;
import com.shopping.cart.exception.CustomRuntimeException;
import com.shopping.cart.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthTokenFilter extends OncePerRequestFilter {
// Выполняется один раз за запрос. Это базовый класс фильтра, который используется, чтобы гарантировать одно выполнение для каждой отправки запроса.
// Он предоставляет метод doFilterInternal с аргументами HttpServletRequest и HttpServletResponse
    @Autowired
    private  UserServiceImpl userService;
    @Autowired
    private  JwtProvider validateJwtToken;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwt(request);                                           // получить токен JWT из заголовка
            if (jwt != null && validateJwtToken.validateJwtToken(jwt)) {            // проверить JWT
                String email = validateJwtToken.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userService.loadUserByUsername(email);    // разобрать имя пользователя из проверенного JWT
                UsernamePasswordAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); // загрузить данные из таблицы пользователей, затем создать объект аутентификации

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);   // установите для объекта аутентификации значение Security Context
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
            throw new CustomRuntimeException(ErrorMessageEnum.USER_NOT_AUTH);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ","");
        }

        return null;
    }
}
