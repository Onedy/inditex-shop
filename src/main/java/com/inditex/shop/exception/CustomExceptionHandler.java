package com.inditex.shop.exception;

import com.inditex.shop.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> priceNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ApiError.builder()
            .description(e.getMessage())
            .build(), HttpStatus.NOT_FOUND);
    }
}
