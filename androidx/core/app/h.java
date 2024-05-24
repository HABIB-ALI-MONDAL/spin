package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.g;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f322a;

    /* renamed from: b  reason: collision with root package name */
    private final g.e f323b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f324c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f325d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f326e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f327f = new Bundle();
    private int g;
    private RemoteViews h;

    h(g.e eVar) {
        Notification.Builder builder;
        ArrayList<String> arrayList;
        String str;
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        this.f323b = eVar;
        Context context = eVar.f312a;
        if (i >= 26) {
            String str2 = eVar.I;
        } else {
            builder = new Notification.Builder(context);
        }
        this.f322a = builder;
        Notification notification = eVar.P;
        this.f322a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f315d).setContentText(eVar.f316e).setContentInfo(eVar.j).setContentIntent(eVar.f317f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.g, (notification.flags & 128) != 0).setLargeIcon(eVar.i).setNumber(eVar.k).setProgress(eVar.r, eVar.s, eVar.t);
        if (i < 21) {
            this.f322a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i >= 16) {
            this.f322a.setSubText(eVar.p).setUsesChronometer(eVar.n).setPriority(eVar.l);
            Iterator<g.a> it = eVar.f313b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle2 = eVar.B;
            if (bundle2 != null) {
                this.f327f.putAll(bundle2);
            }
            if (i < 20) {
                if (eVar.x) {
                    this.f327f.putBoolean("android.support.localOnly", true);
                }
                String str3 = eVar.u;
                if (str3 != null) {
                    this.f327f.putString("android.support.groupKey", str3);
                    if (eVar.v) {
                        bundle = this.f327f;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f327f;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str4 = eVar.w;
                if (str4 != null) {
                    this.f327f.putString("android.support.sortKey", str4);
                }
            }
            this.f324c = eVar.F;
            this.f325d = eVar.G;
        }
        if (i >= 19) {
            this.f322a.setShowWhen(eVar.m);
            if (i < 21 && (arrayList = eVar.Q) != null && !arrayList.isEmpty()) {
                Bundle bundle3 = this.f327f;
                ArrayList<String> arrayList2 = eVar.Q;
                bundle3.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (i >= 20) {
            this.f322a.setLocalOnly(eVar.x).setGroup(eVar.u).setGroupSummary(eVar.v).setSortKey(eVar.w);
            this.g = eVar.M;
        }
        if (i >= 21) {
            this.f322a.setCategory(eVar.A).setColor(eVar.C).setVisibility(eVar.D).setPublicVersion(eVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = eVar.Q.iterator();
            while (it2.hasNext()) {
                this.f322a.addPerson(it2.next());
            }
            this.h = eVar.H;
            if (eVar.f314c.size() > 0) {
                Bundle bundle4 = eVar.c().getBundle("android.car.EXTENSIONS");
                bundle4 = bundle4 == null ? new Bundle() : bundle4;
                Bundle bundle5 = new Bundle();
                for (int i2 = 0; i2 < eVar.f314c.size(); i2++) {
                    bundle5.putBundle(Integer.toString(i2), i.b(eVar.f314c.get(i2)));
                }
                bundle4.putBundle("invisible_actions", bundle5);
                eVar.c().putBundle("android.car.EXTENSIONS", bundle4);
                this.f327f.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        if (i >= 24) {
            this.f322a.setExtras(eVar.B).setRemoteInputHistory(eVar.q);
            RemoteViews remoteViews = eVar.F;
            if (remoteViews != null) {
                this.f322a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.G;
            if (remoteViews2 != null) {
                this.f322a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.H;
            if (remoteViews3 != null) {
                this.f322a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i >= 26) {
            this.f322a.setBadgeIconType(eVar.J).setShortcutId(eVar.K).setTimeoutAfter(eVar.L).setGroupAlertBehavior(eVar.M);
            if (eVar.z) {
                this.f322a.setColorized(eVar.y);
            }
            if (!TextUtils.isEmpty(eVar.I)) {
                this.f322a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i >= 29) {
            this.f322a.setAllowSystemGeneratedContextualActions(eVar.N);
            this.f322a.setBubbleMetadata(g.d.b(eVar.O));
        }
    }

    private void b(g.a aVar) {
        Notification.Action.Builder builder;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            if (i >= 23) {
                IconCompat f2 = aVar.f();
                builder = new Notification.Action.Builder(f2 == null ? null : f2.k(), aVar.j(), aVar.a());
            } else {
                builder = new Notification.Action.Builder(aVar.e(), aVar.j(), aVar.a());
            }
            if (aVar.g() != null) {
                for (RemoteInput addRemoteInput : j.b(aVar.g())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            if (i >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.h());
            if (i >= 28) {
                builder.setSemanticAction(aVar.h());
            }
            if (i >= 29) {
                builder.setContextual(aVar.k());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
            builder.addExtras(bundle);
            this.f322a.addAction(builder.build());
        } else if (i >= 16) {
            this.f326e.add(i.f(this.f322a, aVar));
        }
    }

    private void e(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }

    public Notification.Builder a() {
        return this.f322a;
    }

    public Notification c() {
        Bundle a2;
        RemoteViews e2;
        RemoteViews c2;
        g.f fVar = this.f323b.o;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews d2 = fVar != null ? fVar.d(this) : null;
        Notification d3 = d();
        if (!(d2 == null && (d2 = this.f323b.F) == null)) {
            d3.contentView = d2;
        }
        int i = Build.VERSION.SDK_INT;
        if (!(i < 16 || fVar == null || (c2 = fVar.c(this)) == null)) {
            d3.bigContentView = c2;
        }
        if (!(i < 21 || fVar == null || (e2 = this.f323b.o.e(this)) == null)) {
            d3.headsUpContentView = e2;
        }
        if (!(i < 16 || fVar == null || (a2 = g.a(d3)) == null)) {
            fVar.a(a2);
        }
        return d3;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f322a.build();
        }
        if (i >= 24) {
            Notification build = this.f322a.build();
            if (this.g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                    e(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    e(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f322a.setExtras(this.f327f);
            Notification build2 = this.f322a.build();
            RemoteViews remoteViews = this.f324c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f325d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.g != 2)) {
                    e(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    e(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f322a.setExtras(this.f327f);
            Notification build3 = this.f322a.build();
            RemoteViews remoteViews4 = this.f324c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f325d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.g != 2)) {
                    e(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    e(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a2 = i.a(this.f326e);
            if (a2 != null) {
                this.f327f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f322a.setExtras(this.f327f);
            Notification build4 = this.f322a.build();
            RemoteViews remoteViews6 = this.f324c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f325d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i < 16) {
            return this.f322a.getNotification();
        } else {
            Notification build5 = this.f322a.build();
            Bundle a3 = g.a(build5);
            Bundle bundle = new Bundle(this.f327f);
            for (String str : this.f327f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = i.a(this.f326e);
            if (a4 != null) {
                g.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f324c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f325d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
