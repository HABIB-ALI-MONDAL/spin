package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f328a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f329b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f330c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    static Bundle b(g.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", aVar.e());
        bundle.putCharSequence("title", aVar.j());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", e(aVar.g()));
        bundle.putBoolean("showsUserInterface", aVar.i());
        bundle.putInt("semanticAction", aVar.h());
        return bundle;
    }

    public static Bundle c(Notification notification) {
        String str;
        String str2;
        synchronized (f328a) {
            if (f330c) {
                return null;
            }
            try {
                if (f329b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f330c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f329b = declaredField;
                }
                Bundle bundle = (Bundle) f329b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f329b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f330c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                e = e3;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f330c = true;
                return null;
            }
        }
    }

    private static Bundle d(j jVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", jVar.i());
        bundle.putCharSequence("label", jVar.h());
        bundle.putCharSequenceArray("choices", jVar.e());
        bundle.putBoolean("allowFreeFormInput", jVar.c());
        bundle.putBundle("extras", jVar.g());
        Set<String> d2 = jVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList arrayList = new ArrayList(d2.size());
            for (String add : d2) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] e(j[] jVarArr) {
        if (jVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[jVarArr.length];
        for (int i = 0; i < jVarArr.length; i++) {
            bundleArr[i] = d(jVarArr[i]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, g.a aVar) {
        builder.addAction(aVar.e(), aVar.j(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.g()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
