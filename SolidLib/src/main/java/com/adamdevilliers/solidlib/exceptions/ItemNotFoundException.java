package com.adamdevilliers.solidlib.exceptions;

/*
    Solid sdk ItemNotFoundException is used to display a message with human error created by
    trying to grab an item that doesn't exist; i.e. cityId - 100 where it doesn't exist
 */

public class ItemNotFoundException extends SolidException {

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
