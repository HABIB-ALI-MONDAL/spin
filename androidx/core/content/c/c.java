package androidx.core.content.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class c {

    public interface a {
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0013c[] f338a;

        public b(C0013c[] cVarArr) {
            this.f338a = cVarArr;
        }

        public C0013c[] a() {
            return this.f338a;
        }
    }

    /* renamed from: androidx.core.content.c.c$c  reason: collision with other inner class name */
    public static final class C0013c {

        /* renamed from: a  reason: collision with root package name */
        private final String f339a;

        /* renamed from: b  reason: collision with root package name */
        private int f340b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f341c;

        /* renamed from: d  reason: collision with root package name */
        private String f342d;

        /* renamed from: e  reason: collision with root package name */
        private int f343e;

        /* renamed from: f  reason: collision with root package name */
        private int f344f;

        public C0013c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f339a = str;
            this.f340b = i;
            this.f341c = z;
            this.f342d = str2;
            this.f343e = i2;
            this.f344f = i3;
        }

        public String a() {
            return this.f339a;
        }

        public int b() {
            return this.f344f;
        }

        public int c() {
            return this.f343e;
        }

        public String d() {
            return this.f342d;
        }

        public int e() {
            return this.f340b;
        }

        public boolean f() {
            return this.f341c;
        }
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b.d.h.a f345a;

        /* renamed from: b  reason: collision with root package name */
        private final int f346b;

        /* renamed from: c  reason: collision with root package name */
        private final int f347c;

        public d(b.d.h.a aVar, int i, int i2) {
            this.f345a = aVar;
            this.f347c = i;
            this.f346b = i2;
        }

        public int a() {
            return this.f347c;
        }

        public b.d.h.a b() {
            return this.f345a;
        }

        public int c() {
            return this.f346b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.c.c.a b(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.c.c$a r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            goto L_0x001b
        L_0x001a:
            throw r3
        L_0x001b:
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.c.c.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.c.c$a");
    }

    public static List<List<byte[]>> c(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.d.d.f550e);
        String string = obtainAttributes.getString(b.d.d.f551f);
        String string2 = obtainAttributes.getString(b.d.d.j);
        String string3 = obtainAttributes.getString(b.d.d.k);
        int resourceId = obtainAttributes.getResourceId(b.d.d.g, 0);
        int integer = obtainAttributes.getInteger(b.d.d.h, 1);
        int integer2 = obtainAttributes.getInteger(b.d.d.i, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0013c[]) arrayList.toArray(new C0013c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(new b.d.h.a(string, string2, string3, c(resources, resourceId)), integer, integer2);
    }

    private static C0013c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.d.d.l);
        int i = b.d.d.u;
        if (!obtainAttributes.hasValue(i)) {
            i = b.d.d.n;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = b.d.d.s;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = b.d.d.o;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = b.d.d.v;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = b.d.d.p;
        }
        int i5 = b.d.d.t;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = b.d.d.q;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = b.d.d.r;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = b.d.d.m;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0013c(string2, i2, z, string, i6, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
