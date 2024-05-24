package c.b.a;

import c.b.a.k;
import c.b.a.r.j.a;
import c.b.a.r.j.c;

public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private c<? super TranscodeType> j = a.b();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final c<? super TranscodeType> b() {
        return this.j;
    }
}
