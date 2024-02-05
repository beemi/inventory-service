package com.jaitechltd.inventoryservice.exception;

import com.jaitechltd.inventoryservice.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InventoryExistsException.class)
    public ResponseEntity<ErrorResponse> handleInventoryExistsException(InventoryExistsException e) {
        log.error("InventoryExistsException: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorResponse.failure(e.getMessage()));
    }
}

