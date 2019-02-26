package com.adamdevilliers.solidlib.errorhandling;

/*
    Solid sdk SolidException is the parent class from exception handling done throughout the sdk
 */

public class SolidException extends Exception {

    SolidException(String message) {
        super(message);
    }

    SolidException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
