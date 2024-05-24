package com.google.firebase.components;

import com.google.firebase.o.b;
import java.util.Set;

abstract class m implements o {
    m() {
    }

    public <T> T a(Class<T> cls) {
        b<T> b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        return b2.get();
    }

    public <T> Set<T> c(Class<T> cls) {
        return d(cls).get();
    }
}
