package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import com.google.android.gms.common.internal.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class n0 implements Closeable {
    private final URL j;
    private volatile Future<?> k;
    private i<Bitmap> l;

    private n0(URL url) {
        this.j = url;
    }

    private byte[] f() {
        URLConnection openConnection = this.j.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] d2 = e0.d(e0.b(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    Log.v("FirebaseMessaging", "Downloaded " + d2.length + " bytes from " + this.j);
                }
                if (d2.length <= 1048576) {
                    return d2;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public static n0 h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new n0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(j jVar) {
        try {
            jVar.c(c());
        } catch (Exception e2) {
            jVar.b(e2);
        }
    }

    public Bitmap c() {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.j);
        }
        byte[] f2 = f();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(f2, 0, f2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.j);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.j);
    }

    public void close() {
        this.k.cancel(true);
    }

    public i<Bitmap> i() {
        i<Bitmap> iVar = this.l;
        n.i(iVar);
        return iVar;
    }

    public void p(ExecutorService executorService) {
        j jVar = new j();
        this.k = executorService.submit(new t(this, jVar));
        this.l = jVar.a();
    }
}
