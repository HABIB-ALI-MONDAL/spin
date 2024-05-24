package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    boolean f2038a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f2039b = new LinkedBlockingQueue();

    public IBinder a(long j, TimeUnit timeUnit) {
        n.h("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f2038a) {
            this.f2038a = true;
            IBinder iBinder = (IBinder) this.f2039b.poll(j, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2039b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
