package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class z0 {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f3020a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3021b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3022c;

    /* renamed from: d  reason: collision with root package name */
    final ArrayDeque<String> f3023d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final Executor f3024e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3025f = false;

    private z0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f3020a = sharedPreferences;
        this.f3021b = str;
        this.f3022c = str2;
        this.f3024e = executor;
    }

    private boolean b(boolean z) {
        if (z && !this.f3025f) {
            j();
        }
        return z;
    }

    static z0 c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        z0 z0Var = new z0(sharedPreferences, str, str2, executor);
        z0Var.d();
        return z0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            java.util.ArrayDeque<java.lang.String> r0 = r6.f3023d
            monitor-enter(r0)
            java.util.ArrayDeque<java.lang.String> r1 = r6.f3023d     // Catch:{ all -> 0x004a }
            r1.clear()     // Catch:{ all -> 0x004a }
            android.content.SharedPreferences r1 = r6.f3020a     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r6.f3021b     // Catch:{ all -> 0x004a }
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x004a }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0048
            java.lang.String r2 = r6.f3022c     // Catch:{ all -> 0x004a }
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0021
            goto L_0x0048
        L_0x0021:
            java.lang.String r2 = r6.f3022c     // Catch:{ all -> 0x004a }
            r3 = -1
            java.lang.String[] r1 = r1.split(r2, r3)     // Catch:{ all -> 0x004a }
            int r2 = r1.length     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0032
            java.lang.String r2 = "FirebaseMessaging"
            java.lang.String r3 = "Corrupted queue. Please check the queue contents and item separator provided"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x004a }
        L_0x0032:
            int r2 = r1.length     // Catch:{ all -> 0x004a }
            r3 = 0
        L_0x0034:
            if (r3 >= r2) goto L_0x0046
            r4 = r1[r3]     // Catch:{ all -> 0x004a }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004a }
            if (r5 != 0) goto L_0x0043
            java.util.ArrayDeque<java.lang.String> r5 = r6.f3023d     // Catch:{ all -> 0x004a }
            r5.add(r4)     // Catch:{ all -> 0x004a }
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            goto L_0x004e
        L_0x004d:
            throw r1
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.z0.d():void");
    }

    /* access modifiers changed from: private */
    public void i() {
        synchronized (this.f3023d) {
            this.f3020a.edit().putString(this.f3021b, h()).commit();
        }
    }

    private void j() {
        this.f3024e.execute(new x(this));
    }

    public boolean a(String str) {
        boolean add;
        if (TextUtils.isEmpty(str) || str.contains(this.f3022c)) {
            return false;
        }
        synchronized (this.f3023d) {
            add = this.f3023d.add(str);
            b(add);
        }
        return add;
    }

    public String f() {
        String peek;
        synchronized (this.f3023d) {
            peek = this.f3023d.peek();
        }
        return peek;
    }

    public boolean g(Object obj) {
        boolean remove;
        synchronized (this.f3023d) {
            remove = this.f3023d.remove(obj);
            b(remove);
        }
        return remove;
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f3023d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(this.f3022c);
        }
        return sb.toString();
    }
}
