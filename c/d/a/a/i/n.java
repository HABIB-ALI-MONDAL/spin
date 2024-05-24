package c.d.a.a.i;

import java.util.concurrent.Executor;

class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1458a;

    static class a implements Runnable {
        private final Runnable j;

        a(Runnable runnable) {
            this.j = runnable;
        }

        public void run() {
            try {
                this.j.run();
            } catch (Exception e2) {
                c.d.a.a.i.y.a.d("Executor", "Background execution failure.", e2);
            }
        }
    }

    n(Executor executor) {
        this.f1458a = executor;
    }

    public void execute(Runnable runnable) {
        this.f1458a.execute(new a(runnable));
    }
}
