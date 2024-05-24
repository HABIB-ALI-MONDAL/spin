package f.a.a.d;

import java.util.ArrayList;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<h> f3113a;

    /* renamed from: b  reason: collision with root package name */
    private h f3114b;

    private j(ArrayList<h> arrayList) {
        this.f3113a = arrayList;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f3114b = arrayList.get(0);
        }
    }

    public static j c(ArrayList<h> arrayList) {
        return new j(arrayList);
    }

    public static j d(h hVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(hVar);
        return new j(arrayList);
    }

    public h a() {
        return this.f3114b;
    }

    public ArrayList<h> b() {
        return this.f3113a;
    }
}
