package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f2034c = new ReentrantLock();
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    private static a f2035d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f2036a = new ReentrantLock();
    @GuardedBy("mLk")

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f2037b;

    a(Context context) {
        this.f2037b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        n.i(context);
        Lock lock = f2034c;
        lock.lock();
        try {
            if (f2035d == null) {
                f2035d = new a(context.getApplicationContext());
            }
            a aVar = f2035d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f2034c.unlock();
            throw th;
        }
    }

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount b() {
        String c2;
        String c3 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c3) || (c2 = c(d("googleSignInAccount", c3))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.w(c2);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        this.f2036a.lock();
        try {
            return this.f2037b.getString(str, (String) null);
        } finally {
            this.f2036a.unlock();
        }
    }
}
