package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.d;
import com.google.android.datatransport.runtime.backends.h;
import com.google.android.datatransport.runtime.backends.m;

@Keep
public class CctBackendFactory implements d {
    public m create(h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}
