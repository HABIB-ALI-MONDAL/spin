package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule {

    /* renamed from: b  reason: collision with root package name */
    public static final b f2280b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final b f2281c = new g();
    @GuardedBy("DynamiteModule.class")

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f2282d = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: e  reason: collision with root package name */
    private static String f2283e = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2284f = false;
    @GuardedBy("DynamiteModule.class")
    private static int g = -1;
    @GuardedBy("DynamiteModule.class")
    private static Boolean h;
    private static final ThreadLocal i = new ThreadLocal();
    private static final ThreadLocal j = new d();
    private static final b.a k = new e();
    @GuardedBy("DynamiteModule.class")
    private static l l;
    @GuardedBy("DynamiteModule.class")
    private static m m;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2285a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        /* synthetic */ a(String str, k kVar) {
            super(str);
        }

        /* synthetic */ a(String str, Throwable th, k kVar) {
            super(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(Context context, String str);

            int b(Context context, String str, boolean z);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public static class C0072b {

            /* renamed from: a  reason: collision with root package name */
            public int f2286a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f2287b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f2288c = 0;
        }

        C0072b a(Context context, String str, a aVar);
    }

    private DynamiteModule(Context context) {
        n.i(context);
        this.f2285a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (m.a(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return e(context, str, false);
    }

    public static DynamiteModule d(Context context, b bVar, String str) {
        int i2;
        ThreadLocal threadLocal;
        Boolean bool;
        DynamiteModule dynamiteModule;
        c.d.a.b.d.a aVar;
        m mVar;
        Boolean valueOf;
        c.d.a.b.d.a aVar2;
        Context context2 = context;
        b bVar2 = bVar;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        ThreadLocal threadLocal2 = i;
        i iVar = (i) threadLocal2.get();
        i iVar2 = new i((h) null);
        threadLocal2.set(iVar2);
        ThreadLocal threadLocal3 = j;
        long longValue = ((Long) threadLocal3.get()).longValue();
        try {
            threadLocal3.set(Long.valueOf(SystemClock.elapsedRealtime()));
            b.C0072b a2 = bVar2.a(context2, str2, k);
            int i3 = a2.f2286a;
            int i4 = a2.f2287b;
            Log.i("DynamiteModule", "Considering local module " + str2 + ":" + i3 + " and remote module " + str2 + ":" + i4);
            int i5 = a2.f2288c;
            if (i5 != 0) {
                if (i5 == -1) {
                    if (a2.f2286a != 0) {
                        i5 = -1;
                    }
                }
                if (!(i5 == 1 && a2.f2287b == 0)) {
                    if (i5 == -1) {
                        DynamiteModule g2 = g(context2, str2);
                        if (longValue == 0) {
                            threadLocal3.remove();
                        } else {
                            threadLocal3.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = iVar2.f2291a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal2.set(iVar);
                        return g2;
                    } else if (i5 == 1) {
                        try {
                            int i6 = a2.f2287b;
                            try {
                                synchronized (cls) {
                                    if (j(context)) {
                                        bool = f2282d;
                                    } else {
                                        throw new a("Remote loading disabled", (k) null);
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i6);
                                        synchronized (cls) {
                                            mVar = m;
                                        }
                                        if (mVar != null) {
                                            i iVar3 = (i) threadLocal2.get();
                                            if (iVar3 == null || iVar3.f2291a == null) {
                                                throw new a("No result cursor", (k) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = iVar3.f2291a;
                                            c.d.a.b.d.b.b0(null);
                                            synchronized (cls) {
                                                valueOf = Boolean.valueOf(g >= 2);
                                            }
                                            if (valueOf.booleanValue()) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                aVar2 = mVar.b0(c.d.a.b.d.b.b0(applicationContext), str2, i6, c.d.a.b.d.b.b0(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                aVar2 = mVar.k(c.d.a.b.d.b.b0(applicationContext), str2, i6, c.d.a.b.d.b.b0(cursor2));
                                            }
                                            Context context3 = (Context) c.d.a.b.d.b.k(aVar2);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new a("Failed to get module context", (k) null);
                                            }
                                        } else {
                                            throw new a("DynamiteLoaderV2 was not cached.", (k) null);
                                        }
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i6);
                                        l k2 = k(context);
                                        if (k2 != null) {
                                            int k3 = k2.k();
                                            if (k3 >= 3) {
                                                i iVar4 = (i) threadLocal2.get();
                                                if (iVar4 != null) {
                                                    aVar = k2.e0(c.d.a.b.d.b.b0(context), str2, i6, c.d.a.b.d.b.b0(iVar4.f2291a));
                                                } else {
                                                    throw new a("No cached result cursor holder", (k) null);
                                                }
                                            } else if (k3 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                aVar = k2.f0(c.d.a.b.d.b.b0(context), str2, i6);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                aVar = k2.d0(c.d.a.b.d.b.b0(context), str2, i6);
                                            }
                                            Object k4 = c.d.a.b.d.b.k(aVar);
                                            if (k4 != null) {
                                                dynamiteModule = new DynamiteModule((Context) k4);
                                            } else {
                                                throw new a("Failed to load remote module.", (k) null);
                                            }
                                        } else {
                                            throw new a("Failed to create IDynamiteLoader.", (k) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal3.remove();
                                    } else {
                                        threadLocal3.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = iVar2.f2291a;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal2.set(iVar);
                                    return dynamiteModule;
                                }
                                throw new a("Failed to determine which loading route to use.", (k) null);
                            } catch (RemoteException e2) {
                                throw new a("Failed to load remote module.", e2, (k) null);
                            } catch (a e3) {
                                throw e3;
                            } catch (Throwable th) {
                                f.a(context2, th);
                                throw new a("Failed to load remote module.", th, (k) null);
                            }
                        } catch (a e4) {
                            String message = e4.getMessage();
                            Log.w("DynamiteModule", "Failed to load remote module: " + message);
                            int i7 = a2.f2286a;
                            if (i7 != 0) {
                                if (bVar.a(context2, str2, new j(i7, 0)).f2288c == -1) {
                                    DynamiteModule g3 = g(context2, str2);
                                    if (i2 != 0) {
                                        threadLocal.set(Long.valueOf(longValue));
                                    }
                                    return g3;
                                }
                            }
                            throw new a("Remote load failed. No local fallback found.", e4, (k) null);
                        }
                    } else {
                        throw new a("VersionPolicy returned invalid code:" + i5, (k) null);
                    }
                }
            }
            int i8 = a2.f2286a;
            int i9 = a2.f2287b;
            throw new a("No acceptable module " + str2 + " found. Local version is " + i8 + " and remote version is " + i9 + ".", (k) null);
        } finally {
            i2 = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
            threadLocal = j;
            if (i2 == 0) {
                threadLocal.remove();
            } else {
                threadLocal.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = iVar2.f2291a;
            if (cursor4 != null) {
                cursor4.close();
            }
            i.set(iVar);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static int e(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r2 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r2)     // Catch:{ all -> 0x01ba }
            java.lang.Boolean r3 = f2282d     // Catch:{ all -> 0x01b7 }
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x00d0
            android.content.Context r3 = r12.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r6 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r6 = r6.getName()     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.Class r3 = r3.loadClass(r6)     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.String r6 = "sClassLoader"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r6)     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.Class r6 = r3.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            monitor-enter(r6)     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
            java.lang.Object r7 = r3.get(r4)     // Catch:{ all -> 0x00ab }
            java.lang.ClassLoader r7 = (java.lang.ClassLoader) r7     // Catch:{ all -> 0x00ab }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00ab }
            if (r7 != r8) goto L_0x0039
        L_0x0036:
            r0 = r1
            goto L_0x00a8
        L_0x0039:
            if (r7 == 0) goto L_0x003f
            h(r7)     // Catch:{ a -> 0x00a8 }
            goto L_0x00a8
        L_0x003f:
            boolean r7 = j(r12)     // Catch:{ all -> 0x00ab }
            if (r7 != 0) goto L_0x0048
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            monitor-exit(r2)     // Catch:{ all -> 0x01b7 }
            return r5
        L_0x0048:
            boolean r7 = f2284f     // Catch:{ all -> 0x00ab }
            if (r7 != 0) goto L_0x00a3
            boolean r7 = r0.equals(r4)     // Catch:{ all -> 0x00ab }
            if (r7 == 0) goto L_0x0053
            goto L_0x00a3
        L_0x0053:
            r7 = 1
            int r7 = f(r12, r13, r14, r7)     // Catch:{ a -> 0x009b }
            java.lang.String r8 = f2283e     // Catch:{ a -> 0x009b }
            if (r8 == 0) goto L_0x0098
            boolean r8 = r8.isEmpty()     // Catch:{ a -> 0x009b }
            if (r8 == 0) goto L_0x0063
            goto L_0x0098
        L_0x0063:
            java.lang.ClassLoader r8 = com.google.android.gms.dynamite.b.a()     // Catch:{ a -> 0x009b }
            if (r8 == 0) goto L_0x006a
            goto L_0x008d
        L_0x006a:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x009b }
            r9 = 29
            if (r8 < r9) goto L_0x007f
            dalvik.system.DelegateLastClassLoader r8 = new dalvik.system.DelegateLastClassLoader     // Catch:{ a -> 0x009b }
            java.lang.String r9 = f2283e     // Catch:{ a -> 0x009b }
            com.google.android.gms.common.internal.n.i(r9)     // Catch:{ a -> 0x009b }
            java.lang.ClassLoader r10 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x009b }
            r8.<init>(r9, r10)     // Catch:{ a -> 0x009b }
            goto L_0x008d
        L_0x007f:
            com.google.android.gms.dynamite.c r8 = new com.google.android.gms.dynamite.c     // Catch:{ a -> 0x009b }
            java.lang.String r9 = f2283e     // Catch:{ a -> 0x009b }
            com.google.android.gms.common.internal.n.i(r9)     // Catch:{ a -> 0x009b }
            java.lang.ClassLoader r10 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x009b }
            r8.<init>(r9, r10)     // Catch:{ a -> 0x009b }
        L_0x008d:
            h(r8)     // Catch:{ a -> 0x009b }
            r3.set(r4, r8)     // Catch:{ a -> 0x009b }
            f2282d = r0     // Catch:{ a -> 0x009b }
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            monitor-exit(r2)     // Catch:{ all -> 0x01b7 }
            return r7
        L_0x0098:
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            monitor-exit(r2)     // Catch:{ all -> 0x01b7 }
            return r7
        L_0x009b:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00ab }
        L_0x009f:
            r3.set(r4, r0)     // Catch:{ all -> 0x00ab }
            goto L_0x0036
        L_0x00a3:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00ab }
            goto L_0x009f
        L_0x00a8:
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            r1 = r0
            goto L_0x00cd
        L_0x00ab:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ ClassNotFoundException -> 0x00b2, IllegalAccessException -> 0x00b0, NoSuchFieldException -> 0x00ae }
        L_0x00ae:
            r0 = move-exception
            goto L_0x00b3
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b3
        L_0x00b2:
            r0 = move-exception
        L_0x00b3:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b7 }
            r3.<init>()     // Catch:{ all -> 0x01b7 }
            java.lang.String r6 = "Failed to load module via V2: "
            r3.append(r6)     // Catch:{ all -> 0x01b7 }
            r3.append(r0)     // Catch:{ all -> 0x01b7 }
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01b7 }
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x01b7 }
        L_0x00cd:
            f2282d = r1     // Catch:{ all -> 0x01b7 }
            r3 = r1
        L_0x00d0:
            monitor-exit(r2)     // Catch:{ all -> 0x01b7 }
            boolean r0 = r3.booleanValue()     // Catch:{ all -> 0x01ba }
            if (r0 == 0) goto L_0x00f8
            int r12 = f(r12, r13, r14, r5)     // Catch:{ a -> 0x00dc }
            return r12
        L_0x00dc:
            r13 = move-exception
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x01ba }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ba }
            r14.<init>()     // Catch:{ all -> 0x01ba }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r14.append(r0)     // Catch:{ all -> 0x01ba }
            r14.append(r13)     // Catch:{ all -> 0x01ba }
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01ba }
            android.util.Log.w(r13, r14)     // Catch:{ all -> 0x01ba }
            return r5
        L_0x00f8:
            com.google.android.gms.dynamite.l r6 = k(r12)     // Catch:{ all -> 0x01ba }
            if (r6 != 0) goto L_0x0100
            goto L_0x01ae
        L_0x0100:
            int r0 = r6.k()     // Catch:{ RemoteException -> 0x018d }
            r1 = 3
            if (r0 < r1) goto L_0x0168
            java.lang.ThreadLocal r0 = i     // Catch:{ RemoteException -> 0x018d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x018d }
            com.google.android.gms.dynamite.i r0 = (com.google.android.gms.dynamite.i) r0     // Catch:{ RemoteException -> 0x018d }
            if (r0 == 0) goto L_0x011b
            android.database.Cursor r0 = r0.f2291a     // Catch:{ RemoteException -> 0x018d }
            if (r0 == 0) goto L_0x011b
            int r5 = r0.getInt(r5)     // Catch:{ RemoteException -> 0x018d }
            goto L_0x01ae
        L_0x011b:
            c.d.a.b.d.a r7 = c.d.a.b.d.b.b0(r12)     // Catch:{ RemoteException -> 0x018d }
            java.lang.ThreadLocal r0 = j     // Catch:{ RemoteException -> 0x018d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x018d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x018d }
            long r10 = r0.longValue()     // Catch:{ RemoteException -> 0x018d }
            r8 = r13
            r9 = r14
            c.d.a.b.d.a r13 = r6.g0(r7, r8, r9, r10)     // Catch:{ RemoteException -> 0x018d }
            java.lang.Object r13 = c.d.a.b.d.b.k(r13)     // Catch:{ RemoteException -> 0x018d }
            android.database.Cursor r13 = (android.database.Cursor) r13     // Catch:{ RemoteException -> 0x018d }
            if (r13 == 0) goto L_0x0155
            boolean r14 = r13.moveToFirst()     // Catch:{ RemoteException -> 0x0165, all -> 0x0162 }
            if (r14 != 0) goto L_0x0140
            goto L_0x0155
        L_0x0140:
            int r14 = r13.getInt(r5)     // Catch:{ RemoteException -> 0x0165, all -> 0x0162 }
            if (r14 <= 0) goto L_0x014d
            boolean r0 = i(r13)     // Catch:{ RemoteException -> 0x0165, all -> 0x0162 }
            if (r0 == 0) goto L_0x014d
            goto L_0x014e
        L_0x014d:
            r4 = r13
        L_0x014e:
            if (r4 == 0) goto L_0x0153
            r4.close()     // Catch:{ all -> 0x01ba }
        L_0x0153:
            r5 = r14
            goto L_0x01ae
        L_0x0155:
            java.lang.String r14 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r14, r0)     // Catch:{ RemoteException -> 0x0165, all -> 0x0162 }
            if (r13 == 0) goto L_0x01ae
            r13.close()     // Catch:{ all -> 0x01ba }
            goto L_0x01ae
        L_0x0162:
            r14 = move-exception
            r4 = r13
            goto L_0x01b1
        L_0x0165:
            r14 = move-exception
            r4 = r13
            goto L_0x018f
        L_0x0168:
            r1 = 2
            if (r0 != r1) goto L_0x017b
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x018d }
            c.d.a.b.d.a r0 = c.d.a.b.d.b.b0(r12)     // Catch:{ RemoteException -> 0x018d }
            int r5 = r6.c0(r0, r13, r14)     // Catch:{ RemoteException -> 0x018d }
            goto L_0x01ae
        L_0x017b:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x018d }
            c.d.a.b.d.a r0 = c.d.a.b.d.b.b0(r12)     // Catch:{ RemoteException -> 0x018d }
            int r5 = r6.b0(r0, r13, r14)     // Catch:{ RemoteException -> 0x018d }
            goto L_0x01ae
        L_0x018b:
            r14 = r13
            goto L_0x01b1
        L_0x018d:
            r13 = move-exception
            r14 = r13
        L_0x018f:
            java.lang.String r13 = r14.getMessage()     // Catch:{ all -> 0x01af }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01af }
            r14.<init>()     // Catch:{ all -> 0x01af }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r14.append(r0)     // Catch:{ all -> 0x01af }
            r14.append(r13)     // Catch:{ all -> 0x01af }
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01af }
            android.util.Log.w(r13, r14)     // Catch:{ all -> 0x01af }
            if (r4 == 0) goto L_0x01ae
            r4.close()     // Catch:{ all -> 0x01ba }
        L_0x01ae:
            return r5
        L_0x01af:
            r13 = move-exception
            goto L_0x018b
        L_0x01b1:
            if (r4 == 0) goto L_0x01b6
            r4.close()     // Catch:{ all -> 0x01ba }
        L_0x01b6:
            throw r14     // Catch:{ all -> 0x01ba }
        L_0x01b7:
            r13 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01b7 }
            throw r13     // Catch:{ all -> 0x01ba }
        L_0x01ba:
            r13 = move-exception
            com.google.android.gms.common.util.f.a(r12, r13)
            goto L_0x01c0
        L_0x01bf:
            throw r13
        L_0x01c0:
            goto L_0x01bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int f(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = j     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r12.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            f2283e = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            g = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            f2284f = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = i(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$a r11 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$a r11 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            goto L_0x00c7
        L_0x00b5:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b8:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch:{ all -> 0x00c5 }
            if (r12 == 0) goto L_0x00bd
            throw r11     // Catch:{ all -> 0x00c5 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$a r12 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x00c5 }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00c5 }
            throw r12     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r11 = move-exception
            r0 = r10
        L_0x00c7:
            if (r0 == 0) goto L_0x00cc
            r0.close()
        L_0x00cc:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule g(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    private static void h(ClassLoader classLoader) {
        m mVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                mVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                mVar = queryLocalInterface instanceof m ? (m) queryLocalInterface : new m(iBinder);
            }
            m = mVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, (k) null);
        }
    }

    private static boolean i(Cursor cursor) {
        i iVar = (i) i.get();
        if (iVar == null || iVar.f2291a != null) {
            return false;
        }
        iVar.f2291a = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    private static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(h)) {
            return true;
        }
        boolean z = false;
        if (h == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (com.google.android.gms.common.f.f().h(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            h = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f2284f = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static l k(Context context) {
        l lVar;
        synchronized (DynamiteModule.class) {
            l lVar2 = l;
            if (lVar2 != null) {
                return lVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    lVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    lVar = queryLocalInterface instanceof l ? (l) queryLocalInterface : new l(iBinder);
                }
                if (lVar != null) {
                    l = lVar;
                    return lVar;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
        }
        return null;
    }

    public IBinder c(String str) {
        try {
            return (IBinder) this.f2285a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e2, (k) null);
        }
    }
}
