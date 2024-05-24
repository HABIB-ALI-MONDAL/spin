package com.google.firebase.m;

import java.util.concurrent.Executor;

public interface d {
    <T> void a(Class<T> cls, b<? super T> bVar);

    <T> void b(Class<T> cls, Executor executor, b<? super T> bVar);
}
