package c.b.a.o;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import c.b.a.c;
import c.b.a.j;
import java.util.HashSet;
import java.util.Set;

public class k extends Fragment {
    private final a j;
    private final m k;
    private final Set<k> l;
    private j m;
    private k n;
    private Fragment o;

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    k(a aVar) {
        this.k = new a();
        this.l = new HashSet();
        this.j = aVar;
    }

    private void a(k kVar) {
        this.l.add(kVar);
    }

    @TargetApi(17)
    private Fragment c() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.o;
    }

    private void f(Activity activity) {
        j();
        k g = c.c(activity).k().g(activity.getFragmentManager(), (Fragment) null);
        this.n = g;
        if (!equals(g)) {
            this.n.a(this);
        }
    }

    private void g(k kVar) {
        this.l.remove(kVar);
    }

    private void j() {
        k kVar = this.n;
        if (kVar != null) {
            kVar.g(this);
            this.n = null;
        }
    }

    /* access modifiers changed from: package-private */
    public a b() {
        return this.j;
    }

    public j d() {
        return this.m;
    }

    public m e() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        this.o = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            f(fragment.getActivity());
        }
    }

    public void i(j jVar) {
        this.m = jVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            f(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.j.c();
        j();
    }

    public void onDetach() {
        super.onDetach();
        j();
    }

    public void onStart() {
        super.onStart();
        this.j.d();
    }

    public void onStop() {
        super.onStop();
        this.j.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + c() + "}";
    }
}
