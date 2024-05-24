package c.d.a.b.e.e;

import java.util.Collections;
import java.util.List;

final class g9 extends l9 {

    /* renamed from: c  reason: collision with root package name */
    private static final Class f1642c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* synthetic */ g9(f9 f9Var) {
        super((j9) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) kb.k(obj, j);
        if (list instanceof e9) {
            obj2 = ((e9) list).e();
        } else if (!f1642c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof ea) || !(list instanceof x8)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                x8 x8Var = (x8) list;
                if (x8Var.c()) {
                    x8Var.b();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        kb.x(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: c.d.a.b.e.e.d9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: c.d.a.b.e.e.d9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: c.d.a.b.e.e.d9} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = c.d.a.b.e.e.kb.k(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = c.d.a.b.e.e.kb.k(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0039
            boolean r2 = r1 instanceof c.d.a.b.e.e.e9
            if (r2 == 0) goto L_0x0020
            c.d.a.b.e.e.d9 r1 = new c.d.a.b.e.e.d9
            r1.<init>((int) r0)
            goto L_0x0035
        L_0x0020:
            boolean r2 = r1 instanceof c.d.a.b.e.e.ea
            if (r2 == 0) goto L_0x0030
            boolean r2 = r1 instanceof c.d.a.b.e.e.x8
            if (r2 == 0) goto L_0x0030
            c.d.a.b.e.e.x8 r1 = (c.d.a.b.e.e.x8) r1
            c.d.a.b.e.e.x8 r0 = r1.h(r0)
            r1 = r0
            goto L_0x0035
        L_0x0030:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0035:
            c.d.a.b.e.e.kb.x(r5, r7, r1)
            goto L_0x008a
        L_0x0039:
            java.lang.Class r2 = f1642c
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0057
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
        L_0x0052:
            c.d.a.b.e.e.kb.x(r5, r7, r2)
            r1 = r2
            goto L_0x008a
        L_0x0057:
            boolean r2 = r1 instanceof c.d.a.b.e.e.fb
            if (r2 == 0) goto L_0x006f
            c.d.a.b.e.e.d9 r2 = new c.d.a.b.e.e.d9
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            c.d.a.b.e.e.fb r1 = (c.d.a.b.e.e.fb) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            goto L_0x0052
        L_0x006f:
            boolean r2 = r1 instanceof c.d.a.b.e.e.ea
            if (r2 == 0) goto L_0x008a
            boolean r2 = r1 instanceof c.d.a.b.e.e.x8
            if (r2 == 0) goto L_0x008a
            r2 = r1
            c.d.a.b.e.e.x8 r2 = (c.d.a.b.e.e.x8) r2
            boolean r3 = r2.c()
            if (r3 != 0) goto L_0x008a
            int r1 = r1.size()
            int r1 = r1 + r0
            c.d.a.b.e.e.x8 r1 = r2.h(r1)
            goto L_0x0035
        L_0x008a:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0099
            if (r2 <= 0) goto L_0x0099
            r1.addAll(r6)
        L_0x0099:
            if (r0 > 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r6 = r1
        L_0x009d:
            c.d.a.b.e.e.kb.x(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.g9.b(java.lang.Object, java.lang.Object, long):void");
    }
}
