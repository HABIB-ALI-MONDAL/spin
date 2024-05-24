package f.a.a.d;

import android.app.Activity;
import android.net.Uri;
import f.a.a.d.h;
import f.a.a.f.e;
import f.a.a.f.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Uri> f3105a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Uri> f3106b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<h> f3107c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3108d;

    private d(ArrayList<Uri> arrayList, Activity activity, h.a aVar) {
        this.f3105a = arrayList;
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Uri.fromFile(e.d(activity, it.next())));
        }
        this.f3106b = arrayList2;
        this.f3107c = g.f(arrayList2, aVar);
    }

    public static d d(ArrayList<Uri> arrayList, Activity activity, h.a aVar) {
        return new d(arrayList, activity, aVar);
    }

    public ArrayList<Uri> a() {
        return this.f3106b;
    }

    public ArrayList<Uri> b() {
        return this.f3105a;
    }

    public ArrayList<h> c() {
        return this.f3107c;
    }

    public Map e(Uri uri, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.f3108d = true;
        }
        int indexOf = this.f3106b.indexOf(uri);
        this.f3107c.get(indexOf).h(z);
        HashMap hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(indexOf));
        if (indexOf != this.f3106b.size() - 1) {
            z2 = false;
        }
        hashMap.put("isLast", Boolean.valueOf(z2));
        return hashMap;
    }
}
