package com.shopping.cart.exception;

import com.shopping.cart.enums.ErrorMessageEnum;

public class MyException extends RuntimeException{

    private Integer code;
    public MyException(ErrorMessageEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
