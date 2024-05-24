package c.d.a.b.e.e;

import c.d.a.b.e.e.p8;
import c.d.a.b.e.e.s8;
import java.io.IOException;

public class p8<MessageType extends s8<MessageType, BuilderType>, BuilderType extends p8<MessageType, BuilderType>> extends c7<MessageType, BuilderType> {
    private final s8 j;
    protected s8 k;

    protected p8(MessageType messagetype) {
        this.j = messagetype;
        if (!messagetype.y()) {
            this.k = messagetype.m();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void k(Object obj, Object obj2) {
        fa.a().b(obj.getClass()).c(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ c7 i(byte[] bArr, int i, int i2) {
        m(bArr, 0, i2, e8.f1626c);
        return this;
    }

    public final /* bridge */ /* synthetic */ c7 j(byte[] bArr, int i, int i2, e8 e8Var) {
        m(bArr, 0, i2, e8Var);
        return this;
    }

    public final p8 l(s8 s8Var) {
        if (!this.j.equals(s8Var)) {
            if (!this.k.y()) {
                q();
            }
            k(this.k, s8Var);
        }
        return this;
    }

    public final p8 m(byte[] bArr, int i, int i2, e8 e8Var) {
        if (!this.k.y()) {
            q();
        }
        try {
            fa.a().b(this.k.getClass()).h(this.k, bArr, 0, i2, new g7(e8Var));
            return this;
        } catch (a9 e2) {
            throw e2;
        } catch (IndexOutOfBoundsException unused) {
            throw a9.f();
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r3 != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType n() {
        /*
            r5 = this;
            c.d.a.b.e.e.s8 r0 = r5.f()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.D(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0013
            goto L_0x0030
        L_0x0013:
            if (r3 == 0) goto L_0x0031
            c.d.a.b.e.e.fa r3 = c.d.a.b.e.e.fa.a()
            java.lang.Class r4 = r0.getClass()
            c.d.a.b.e.e.ia r3 = r3.b(r4)
            boolean r3 = r3.g(r0)
            if (r1 == r3) goto L_0x0029
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r1 = r0
        L_0x002a:
            r4 = 2
            r0.D(r4, r1, r2)
            if (r3 == 0) goto L_0x0031
        L_0x0030:
            return r0
        L_0x0031:
            c.d.a.b.e.e.za r1 = new c.d.a.b.e.e.za
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.p8.n():c.d.a.b.e.e.s8");
    }

    /* renamed from: o */
    public MessageType f() {
        if (!this.k.y()) {
            return this.k;
        }
        this.k.u();
        return this.k;
    }

    /* access modifiers changed from: protected */
    public final void p() {
        if (!this.k.y()) {
            q();
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        s8 m = this.j.m();
        k(m, this.k);
        this.k = m;
    }

    /* renamed from: r */
    public final p8 clone() {
        p8 p8Var = (p8) this.j.D(5, (Object) null, (Object) null);
        p8Var.k = f();
        return p8Var;
    }
}
