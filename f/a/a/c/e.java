package f.a.a.c;

import android.content.Context;
import e.a.a.a;
import f.a.a.c.b;
import f.a.a.d.c;
import f.a.a.d.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<h> f3096a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f3097b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3098c;

    /* renamed from: d  reason: collision with root package name */
    private c f3099d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<File> f3100e = new ArrayList<>();

    public e(Context context, a aVar, ArrayList<h> arrayList, b.a aVar2) {
        aVar.b();
        this.f3096a = arrayList;
        this.f3097b = aVar2;
        this.f3098c = context;
    }

    private void b() {
        a.b(this.f3098c, this.f3100e).e(4);
        this.f3099d.b();
        throw null;
    }

    private void c() {
        a.a(this.f3098c, this.f3100e.get(0)).e(4);
        this.f3099d.a();
        throw null;
    }

    public void a() {
        b.a aVar;
        ArrayList<h> arrayList;
        String str;
        ArrayList<h> arrayList2 = this.f3096a;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            aVar = this.f3097b;
            arrayList = this.f3096a;
            str = " images is null";
        } else {
            Iterator<h> it = this.f3096a.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next == null) {
                    aVar = this.f3097b;
                    arrayList = this.f3096a;
                    str = " There are pictures of compress  is null.";
                } else {
                    this.f3100e.add(new File(next.b()));
                }
            }
            if (this.f3096a.size() == 1) {
                c();
                throw null;
            } else {
                b();
                throw null;
            }
        }
        aVar.b(arrayList, str);
    }
}
