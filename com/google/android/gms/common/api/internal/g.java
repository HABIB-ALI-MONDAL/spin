package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

public interface g {
    void b(String str, LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T d(String str, Class<T> cls);

    Activity e();

    void startActivityForResult(Intent intent, int i);
}
