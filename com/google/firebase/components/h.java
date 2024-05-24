package com.google.firebase.components;

import com.google.firebase.m.a;
import com.google.firebase.m.b;
import java.util.Map;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Map.Entry j;
    public final /* synthetic */ a k;

    public /* synthetic */ h(Map.Entry entry, a aVar) {
        this.j = entry;
        this.k = aVar;
    }

    public final void run() {
        ((b) this.j.getKey()).a(this.k);
    }
}
