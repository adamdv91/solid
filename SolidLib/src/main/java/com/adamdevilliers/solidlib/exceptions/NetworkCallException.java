package com.adamdevilliers.solidlib.exceptions;
/*
    Solid sdk NetworkCallException is used to display a message with a network issue happens
    while in communication with the Solid sdk.
 */
public class NetworkCallException extends SolidException {

    public NetworkCallException(String message) {
        super(message);
    }

    public NetworkCallException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
