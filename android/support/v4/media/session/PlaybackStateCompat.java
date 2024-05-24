package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    final int j;
    final long k;
    final long l;
    final float m;
    final long n;
    final int o;
    final CharSequence p;
    final long q;
    List<CustomAction> r;
    final long s;
    final Bundle t;
    private Object u;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();
        private final String j;
        private final CharSequence k;
        private final int l;
        private final Bundle m;
        private Object n;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(Parcel parcel) {
            this.j = parcel.readString();
            this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.l = parcel.readInt();
            this.m = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.j = str;
            this.k = charSequence;
            this.l = i;
            this.m = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.n = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.k + ", mIcon=" + this.l + ", mExtras=" + this.m;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.j);
            TextUtils.writeToParcel(this.k, parcel, i);
            parcel.writeInt(this.l);
            parcel.writeBundle(this.m);
        }
    }

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    PlaybackStateCompat(int i, long j2, long j3, float f2, long j4, int i2, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.j = i;
        this.k = j2;
        this.l = j3;
        this.m = f2;
        this.n = j4;
        this.o = i2;
        this.p = charSequence;
        this.q = j5;
        this.r = new ArrayList(list);
        this.s = j6;
        this.t = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.m = parcel.readFloat();
        this.q = parcel.readLong();
        this.l = parcel.readLong();
        this.n = parcel.readLong();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.r = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.s = parcel.readLong();
        this.t = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.o = parcel.readInt();
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        int i = Build.VERSION.SDK_INT;
        Bundle bundle = null;
        if (obj2 == null || i < 21) {
            return null;
        }
        List<Object> d2 = g.d(obj);
        if (d2 != null) {
            ArrayList arrayList2 = new ArrayList(d2.size());
            for (Object a2 : d2) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (i >= 22) {
            bundle = h.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), bundle);
        playbackStateCompat.u = obj2;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.j + ", position=" + this.k + ", buffered position=" + this.l + ", speed=" + this.m + ", updated=" + this.q + ", actions=" + this.n + ", error code=" + this.o + ", error message=" + this.p + ", custom actions=" + this.r + ", active item id=" + this.s + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeFloat(this.m);
        parcel.writeLong(this.q);
        parcel.writeLong(this.l);
        parcel.writeLong(this.n);
        TextUtils.writeToParcel(this.p, parcel, i);
        parcel.writeTypedList(this.r);
        parcel.writeLong(this.s);
        parcel.writeBundle(this.t);
        parcel.writeInt(this.o);
    }
}
