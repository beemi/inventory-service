package com.jaitechltd.inventoryservice.exception;

public class InventoryExistsException extends RuntimeException {

    public InventoryExistsException(String message) {
        super(message);
    }
}
