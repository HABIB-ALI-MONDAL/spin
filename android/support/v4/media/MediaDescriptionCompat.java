package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();
    private final String j;
    private final CharSequence k;
    private final CharSequence l;
    private final CharSequence m;
    private final Bitmap n;
    private final Uri o;
    private final Bundle p;
    private final Uri q;
    private Object r;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(d.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f2a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f3b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f4c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f5d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f6e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f7f;
        private Bundle g;
        private Uri h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f2a, this.f3b, this.f4c, this.f5d, this.f6e, this.f7f, this.g, this.h);
        }

        public b b(CharSequence charSequence) {
            this.f5d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f6e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f7f = uri;
            return this;
        }

        public b f(String str) {
            this.f2a = str;
            return this;
        }

        public b g(Uri uri) {
            this.h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f4c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f3b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.j = parcel.readString();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.n = (Bitmap) parcel.readParcelable(classLoader);
        this.o = (Uri) parcel.readParcelable(classLoader);
        this.p = parcel.readBundle(classLoader);
        this.q = (Uri) parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.j = str;
        this.k = charSequence;
        this.l = charSequence2;
        this.m = charSequence3;
        this.n = bitmap;
        this.o = uri;
        this.p = bundle;
        this.q = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x007e
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x007e
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            java.lang.String r3 = android.support.v4.media.d.f(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.d.h(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.d.g(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.d.b(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.d.d(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.d.e(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.d.c(r9)
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x004a
            android.support.v4.media.session.MediaSessionCompat.a(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x004b
        L_0x004a:
            r5 = r0
        L_0x004b:
            if (r5 == 0) goto L_0x0063
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x005d
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            r3.remove(r4)
            r3.remove(r6)
        L_0x0063:
            r0 = r3
        L_0x0064:
            r2.c(r0)
            if (r5 == 0) goto L_0x006d
            r2.g(r5)
            goto L_0x0078
        L_0x006d:
            r0 = 23
            if (r1 < r0) goto L_0x0078
            android.net.Uri r0 = android.support.v4.media.e.a(r9)
            r2.g(r0)
        L_0x0078:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.r = r9
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object b() {
        int i;
        Object obj = this.r;
        if (obj != null || (i = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object b2 = d.a.b();
        d.a.g(b2, this.j);
        d.a.i(b2, this.k);
        d.a.h(b2, this.l);
        d.a.c(b2, this.m);
        d.a.e(b2, this.n);
        d.a.f(b2, this.o);
        Bundle bundle = this.p;
        if (i < 23 && this.q != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.q);
        }
        d.a.d(b2, bundle);
        if (i >= 23) {
            e.a.a(b2, this.q);
        }
        Object a2 = d.a.a(b2);
        this.r = a2;
        return a2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.k + ", " + this.l + ", " + this.m;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.j);
            TextUtils.writeToParcel(this.k, parcel, i);
            TextUtils.writeToParcel(this.l, parcel, i);
            TextUtils.writeToParcel(this.m, parcel, i);
            parcel.writeParcelable(this.n, i);
            parcel.writeParcelable(this.o, i);
            parcel.writeBundle(this.p);
            parcel.writeParcelable(this.q, i);
            return;
        }
        d.i(b(), parcel, i);
    }
}
