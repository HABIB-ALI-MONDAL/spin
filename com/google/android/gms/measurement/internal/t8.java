package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.m.a;

public final class t8 implements ServiceConnection, c.a, c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2549a;

    /* renamed from: b  reason: collision with root package name */
    private volatile i3 f2550b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u8 f2551c;

    protected t8(u8 u8Var) {
        this.f2551c = u8Var;
    }

    public final void b(Intent intent) {
        this.f2551c.h();
        Context d2 = this.f2551c.f2527a.d();
        a b2 = a.b();
        synchronized (this) {
            if (this.f2549a) {
                this.f2551c.f2527a.f().v().a("Connection attempt already in progress");
                return;
            }
            this.f2551c.f2527a.f().v().a("Using local app measurement service");
            this.f2549a = true;
            b2.a(d2, intent, this.f2551c.f2567c, 129);
        }
    }

    public final void c() {
        this.f2551c.h();
        Context d2 = this.f2551c.f2527a.d();
        synchronized (this) {
            if (this.f2549a) {
                this.f2551c.f2527a.f().v().a("Connection attempt already in progress");
            } else if (this.f2550b == null || (!this.f2550b.b() && !this.f2550b.d())) {
                this.f2550b = new i3(d2, Looper.getMainLooper(), this, this);
                this.f2551c.f2527a.f().v().a("Connecting to remote service");
                this.f2549a = true;
                n.i(this.f2550b);
                this.f2550b.q();
            } else {
                this.f2551c.f2527a.f().v().a("Already awaiting connection attempt");
            }
        }
    }

    public final void d() {
        if (this.f2550b != null && (this.f2550b.d() || this.f2550b.b())) {
            this.f2550b.j();
        }
        this.f2550b = null;
    }

    public final void h(b bVar) {
        n.d("MeasurementServiceConnection.onConnectionFailed");
        m3 E = this.f2551c.f2527a.E();
        if (E != null) {
            E.w().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.f2549a = false;
            this.f2550b = null;
        }
        this.f2551c.f2527a.c().z(new s8(this));
    }

    public final void i(int i) {
        n.d("MeasurementServiceConnection.onConnectionSuspended");
        this.f2551c.f2527a.f().q().a("Service connection suspended");
        this.f2551c.f2527a.c().z(new r8(this));
    }

    public final void k(Bundle bundle) {
        n.d("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                n.i(this.f2550b);
                this.f2551c.f2527a.c().z(new q8(this, (b3) this.f2550b.D()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f2550b = null;
                this.f2549a = false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.f2551c.f2527a.f().r().a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.n.d(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001e
            r3.f2549a = r4     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.u8 r4 = r3.f2551c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x0063 }
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x001e:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0065 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.b3     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.internal.b3 r1 = (com.google.android.gms.measurement.internal.b3) r1     // Catch:{ RemoteException -> 0x0065 }
        L_0x0037:
            r0 = r1
            goto L_0x003f
        L_0x0039:
            com.google.android.gms.measurement.internal.z2 r1 = new com.google.android.gms.measurement.internal.z2     // Catch:{ RemoteException -> 0x0065 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0037
        L_0x003f:
            com.google.android.gms.measurement.internal.u8 r5 = r3.f2551c     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.v()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.a(r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0051:
            com.google.android.gms.measurement.internal.u8 r5 = r3.f2551c     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.b(r2, r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0063:
            r4 = move-exception
            goto L_0x00a2
        L_0x0065:
            com.google.android.gms.measurement.internal.u8 r5 = r3.f2551c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.a(r1)     // Catch:{ all -> 0x0063 }
        L_0x0076:
            if (r0 != 0) goto L_0x0090
            r3.f2549a = r4     // Catch:{ all -> 0x0063 }
            com.google.android.gms.common.m.a r4 = com.google.android.gms.common.m.a.b()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.u8 r5 = r3.f2551c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ IllegalArgumentException -> 0x00a0 }
            android.content.Context r5 = r5.d()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.u8 r0 = r3.f2551c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.t8 r0 = r0.f2567c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            r4.c(r5, r0)     // Catch:{ IllegalArgumentException -> 0x00a0 }
            goto L_0x00a0
        L_0x0090:
            com.google.android.gms.measurement.internal.u8 r4 = r3.f2551c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.u4 r4 = r4.c()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.o8 r5 = new com.google.android.gms.measurement.internal.o8     // Catch:{ all -> 0x0063 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0063 }
            r4.z(r5)     // Catch:{ all -> 0x0063 }
        L_0x00a0:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x00a2:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            goto L_0x00a5
        L_0x00a4:
            throw r4
        L_0x00a5:
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t8.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        n.d("MeasurementServiceConnection.onServiceDisconnected");
        this.f2551c.f2527a.f().q().a("Service disconnected");
        this.f2551c.f2527a.c().z(new p8(this, componentName));
    }
}
