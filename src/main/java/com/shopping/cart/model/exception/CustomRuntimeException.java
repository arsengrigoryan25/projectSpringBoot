package com.shopping.cart.model.exception;

import com.shopping.cart.model.domain.enums.ErrorMessageEnum;

public class CustomRuntimeException extends RuntimeException{

    private Integer code;
    public CustomRuntimeException(ErrorMessageEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public CustomRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
