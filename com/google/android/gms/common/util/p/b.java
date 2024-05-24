package com.google.android.gms.common.util.p;

import android.os.Process;

final class b implements Runnable {
    private final Runnable j;

    public b(Runnable runnable, int i) {
        this.j = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.j.run();
    }
}
