package com.shopping.cart.model.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomRuntimeException.class)
    public String errorHandler(CustomRuntimeException ex, Model model) {
        model.addAttribute("msg", ex.getMessage());
        return "/common/error";
    }

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception ex, Model model) {
        model.addAttribute("msg", "Unknown Error!");
        return "/common/error";
    }
}
