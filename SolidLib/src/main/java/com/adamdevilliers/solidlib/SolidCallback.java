package com.adamdevilliers.solidlib;

public interface SolidCallback<T> {
    void onSuccess(T data);
    void onFailure(Throwable t);
}
