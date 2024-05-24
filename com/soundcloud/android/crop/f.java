package com.soundcloud.android.crop;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

abstract class f extends Activity {
    private final ArrayList<b> j = new ArrayList<>();

    public static class a implements b {
        public void c(f fVar) {
        }
    }

    public interface b {
        void a(f fVar);

        void b(f fVar);

        void c(f fVar);

        void d(f fVar);
    }

    f() {
    }

    public void a(b bVar) {
        if (!this.j.contains(bVar)) {
            this.j.add(bVar);
        }
    }

    public void b(b bVar) {
        this.j.remove(bVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<b> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Iterator<b> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Iterator<b> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Iterator<b> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }
}
