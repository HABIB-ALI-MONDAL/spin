package com.google.firebase.installations;

import com.google.firebase.i;

public class j extends i {

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public j(a aVar) {
    }

    public j(String str, a aVar) {
        super(str);
    }
}
