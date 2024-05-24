package com.google.firebase.components;

public class y extends RuntimeException {
    public y(String str) {
        super(str);
    }

    public y(String str, Throwable th) {
        super(str, th);
    }
}
