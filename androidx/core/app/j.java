package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

public final class j {
    static RemoteInput a(j jVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(jVar.i()).setLabel(jVar.h()).setChoices(jVar.e()).setAllowFreeFormInput(jVar.c()).addExtras(jVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(jVar.f());
        }
        return addExtras.build();
    }

    static RemoteInput[] b(j[] jVarArr) {
        if (jVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[jVarArr.length];
        for (int i = 0; i < jVarArr.length; i++) {
            remoteInputArr[i] = a(jVarArr[i]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        throw null;
    }

    public Set<String> d() {
        throw null;
    }

    public CharSequence[] e() {
        throw null;
    }

    public int f() {
        throw null;
    }

    public Bundle g() {
        throw null;
    }

    public CharSequence h() {
        throw null;
    }

    public String i() {
        throw null;
    }
}
