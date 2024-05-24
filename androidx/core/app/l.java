package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class l implements Iterable<Intent> {
    private final ArrayList<Intent> j = new ArrayList<>();
    private final Context k;

    public interface a {
        Intent e();
    }

    private l(Context context) {
        this.k = context;
    }

    public static l j(Context context) {
        return new l(context);
    }

    public l d(Intent intent) {
        this.j.add(intent);
        return this;
    }

    public l g(Activity activity) {
        Intent e2 = activity instanceof a ? ((a) activity).e() : null;
        if (e2 == null) {
            e2 = e.a(activity);
        }
        if (e2 != null) {
            ComponentName component = e2.getComponent();
            if (component == null) {
                component = e2.resolveActivity(this.k.getPackageManager());
            }
            i(component);
            d(e2);
        }
        return this;
    }

    public l i(ComponentName componentName) {
        int size = this.j.size();
        try {
            Context context = this.k;
            while (true) {
                Intent b2 = e.b(context, componentName);
                if (b2 == null) {
                    return this;
                }
                this.j.add(size, b2);
                context = this.k;
                componentName = b2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.j.iterator();
    }

    public void k() {
        l((Bundle) null);
    }

    public void l(Bundle bundle) {
        if (!this.j.isEmpty()) {
            ArrayList<Intent> arrayList = this.j;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.j(this.k, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.k.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
