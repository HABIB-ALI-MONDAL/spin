package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public class g {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f303a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f304b;

        /* renamed from: c  reason: collision with root package name */
        private final j[] f305c;

        /* renamed from: d  reason: collision with root package name */
        private final j[] f306d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f307e;

        /* renamed from: f  reason: collision with root package name */
        boolean f308f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.b((Resources) null, "", i2) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (j[]) null, (j[]) null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, j[] jVarArr, j[] jVarArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f308f = true;
            this.f304b = iconCompat;
            if (iconCompat != null && iconCompat.g() == 2) {
                this.i = iconCompat.c();
            }
            this.j = e.d(charSequence);
            this.k = pendingIntent;
            this.f303a = bundle == null ? new Bundle() : bundle;
            this.f305c = jVarArr;
            this.f306d = jVarArr2;
            this.f307e = z;
            this.g = i2;
            this.f308f = z2;
            this.h = z3;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.f307e;
        }

        public j[] c() {
            return this.f306d;
        }

        public Bundle d() {
            return this.f303a;
        }

        @Deprecated
        public int e() {
            return this.i;
        }

        public IconCompat f() {
            int i2;
            if (this.f304b == null && (i2 = this.i) != 0) {
                this.f304b = IconCompat.b((Resources) null, "", i2);
            }
            return this.f304b;
        }

        public j[] g() {
            return this.f305c;
        }

        public int h() {
            return this.g;
        }

        public boolean i() {
            return this.f308f;
        }

        public CharSequence j() {
            return this.j;
        }

        public boolean k() {
            return this.h;
        }
    }

    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f309e;

        /* renamed from: f  reason: collision with root package name */
        private Bitmap f310f;
        private boolean g;

        public void b(f fVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(fVar.a()).setBigContentTitle(this.f319b).bigPicture(this.f309e);
                if (this.g) {
                    bigPicture.bigLargeIcon(this.f310f);
                }
                if (this.f321d) {
                    bigPicture.setSummaryText(this.f320c);
                }
            }
        }

        public b g(Bitmap bitmap) {
            this.f310f = bitmap;
            this.g = true;
            return this;
        }

        public b h(Bitmap bitmap) {
            this.f309e = bitmap;
            return this;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f311e;

        public void b(f fVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(fVar.a()).setBigContentTitle(this.f319b).bigText(this.f311e);
                if (this.f321d) {
                    bigText.setSummaryText(this.f320c);
                }
            }
        }

        public c g(CharSequence charSequence) {
            this.f311e = e.d(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata b(d dVar) {
            if (dVar == null) {
                return null;
            }
            new Notification.BubbleMetadata.Builder();
            dVar.a();
            throw null;
        }

        public boolean a() {
            throw null;
        }
    }

    public static class e {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        d O;
        Notification P;
        @Deprecated
        public ArrayList<String> Q;

        /* renamed from: a  reason: collision with root package name */
        public Context f312a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f313b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f314c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f315d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f316e;

        /* renamed from: f  reason: collision with root package name */
        PendingIntent f317f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        f o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        @Deprecated
        public e(Context context) {
            this(context, (String) null);
        }

        public e(Context context, String str) {
            this.f313b = new ArrayList<>();
            this.f314c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            Notification notification = new Notification();
            this.P = notification;
            this.f312a = context;
            this.I = str;
            notification.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.Q = new ArrayList<>();
            this.N = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap e(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f312a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(b.d.b.f539b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(b.d.b.f538a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        private void n(int i2, boolean z2) {
            Notification notification;
            int i3;
            if (z2) {
                notification = this.P;
                i3 = i2 | notification.flags;
            } else {
                notification = this.P;
                i3 = (i2 ^ -1) & notification.flags;
            }
            notification.flags = i3;
        }

        public e A(long j2) {
            this.P.when = j2;
            return this;
        }

        public e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f313b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new h(this).c();
        }

        public Bundle c() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public e f(boolean z2) {
            n(16, z2);
            return this;
        }

        public e g(String str) {
            this.I = str;
            return this;
        }

        public e h(int i2) {
            this.C = i2;
            return this;
        }

        public e i(PendingIntent pendingIntent) {
            this.f317f = pendingIntent;
            return this;
        }

        public e j(CharSequence charSequence) {
            this.f316e = d(charSequence);
            return this;
        }

        public e k(CharSequence charSequence) {
            this.f315d = d(charSequence);
            return this;
        }

        public e l(int i2) {
            Notification notification = this.P;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public e o(Bitmap bitmap) {
            this.i = e(bitmap);
            return this;
        }

        public e p(int i2, int i3, int i4) {
            Notification notification = this.P;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public e q(boolean z2) {
            this.x = z2;
            return this;
        }

        public e r(int i2) {
            this.k = i2;
            return this;
        }

        public e s(int i2) {
            this.l = i2;
            return this;
        }

        public e t(boolean z2) {
            this.m = z2;
            return this;
        }

        public e u(int i2) {
            this.P.icon = i2;
            return this;
        }

        public e v(Uri uri) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e w(f fVar) {
            if (this.o != fVar) {
                this.o = fVar;
                if (fVar != null) {
                    fVar.f(this);
                }
            }
            return this;
        }

        public e x(CharSequence charSequence) {
            this.P.tickerText = d(charSequence);
            return this;
        }

        public e y(long[] jArr) {
            this.P.vibrate = jArr;
            return this;
        }

        public e z(int i2) {
            this.D = i2;
            return this;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected e f318a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f319b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f320c;

        /* renamed from: d  reason: collision with root package name */
        boolean f321d = false;

        public void a(Bundle bundle) {
        }

        public abstract void b(f fVar);

        public RemoteViews c(f fVar) {
            return null;
        }

        public RemoteViews d(f fVar) {
            return null;
        }

        public RemoteViews e(f fVar) {
            return null;
        }

        public void f(e eVar) {
            if (this.f318a != eVar) {
                this.f318a = eVar;
                if (eVar != null) {
                    eVar.w(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return i.c(notification);
        }
        return null;
    }
}
