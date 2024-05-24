package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private final a f1967a;

    /* renamed from: b  reason: collision with root package name */
    private final i f1968b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, m> f1969c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1970a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f1971b = null;

        a(Context context) {
            this.f1970a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d2 = d(context);
            if (d2 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d2.keySet()) {
                Object obj = d2.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f1971b == null) {
                this.f1971b = a(this.f1970a);
            }
            return this.f1971b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public d b(String str) {
            String str2;
            String str3;
            String str4 = c().get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str4).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                e = e2;
                str2 = String.format("Class %s is not found.", new Object[]{str4});
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (IllegalAccessException e3) {
                e = e3;
                str2 = String.format("Could not instantiate %s.", new Object[]{str4});
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (InstantiationException e4) {
                e = e4;
                str2 = String.format("Could not instantiate %s.", new Object[]{str4});
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                str3 = String.format("Could not instantiate %s", new Object[]{str4});
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (InvocationTargetException e6) {
                e = e6;
                str3 = String.format("Could not instantiate %s", new Object[]{str4});
                Log.w("BackendRegistry", str3, e);
                return null;
            }
        }
    }

    k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    k(a aVar, i iVar) {
        this.f1969c = new HashMap();
        this.f1967a = aVar;
        this.f1968b = iVar;
    }

    public synchronized m a(String str) {
        if (this.f1969c.containsKey(str)) {
            return this.f1969c.get(str);
        }
        d b2 = this.f1967a.b(str);
        if (b2 == null) {
            return null;
        }
        m create = b2.create(this.f1968b.a(str));
        this.f1969c.put(str, create);
        return create;
    }
}
