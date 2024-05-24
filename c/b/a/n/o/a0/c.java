package c.b.a.n.o.a0;

import c.b.a.t.h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f905a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f906b = new b();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f907a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f908b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f909a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f909a) {
                poll = this.f909a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* access modifiers changed from: package-private */
        public void b(a aVar) {
            synchronized (this.f909a) {
                if (this.f909a.size() < 10) {
                    this.f909a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f905a.get(str);
            if (aVar == null) {
                aVar = this.f906b.a();
                this.f905a.put(str, aVar);
            }
            aVar.f908b++;
        }
        aVar.f907a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.f905a.get(str);
            h.d(aVar2);
            aVar = aVar2;
            int i = aVar.f908b;
            if (i >= 1) {
                int i2 = i - 1;
                aVar.f908b = i2;
                if (i2 == 0) {
                    a remove = this.f905a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f906b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f908b);
            }
        }
        aVar.f907a.unlock();
    }
}
