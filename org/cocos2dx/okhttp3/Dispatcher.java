package org.cocos2dx.okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.a;
import org.cocos2dx.okhttp3.internal.Util;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @Nullable
    private ExecutorService executorService;
    @Nullable
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<a.b> readyAsyncCalls = new ArrayDeque();
    private final Deque<a.b> runningAsyncCalls = new ArrayDeque();
    private final Deque<a> runningSyncCalls = new ArrayDeque();

    public Dispatcher() {
    }

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    private <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    private boolean promoteAndExecute() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<a.b> it = this.readyAsyncCalls.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.b next = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                } else if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            z = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((a.b) arrayList.get(i)).k(executorService());
        }
        return z;
    }

    private int runningCallsForHost(a.b bVar) {
        int i = 0;
        for (a.b next : this.runningAsyncCalls) {
            if (!next.l().o && next.m().equals(bVar.m())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void cancelAll() {
        for (a.b l : this.readyAsyncCalls) {
            l.l().cancel();
        }
        for (a.b l2 : this.runningAsyncCalls) {
            l2.l().cancel();
        }
        for (a cancel : this.runningSyncCalls) {
            cancel.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueue(a.b bVar) {
        synchronized (this) {
            this.readyAsyncCalls.add(bVar);
        }
        promoteAndExecute();
    }

    /* access modifiers changed from: package-private */
    public synchronized void executed(a aVar) {
        this.runningSyncCalls.add(aVar);
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    /* access modifiers changed from: package-private */
    public void finished(a.b bVar) {
        finished(this.runningAsyncCalls, bVar);
    }

    /* access modifiers changed from: package-private */
    public void finished(a aVar) {
        finished(this.runningSyncCalls, aVar);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (a.b l : this.readyAsyncCalls) {
            arrayList.add(l.l());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        for (a.b l : this.runningAsyncCalls) {
            arrayList.add(l.l());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequests = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }
}
