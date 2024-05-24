package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {
    public GooglePlayServicesManifestException(int i, String str) {
        super(str);
    }
}
