package com.google.firebase.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class l {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f3040a;

    public l(Context context, String str) {
        this.f3040a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        long j = this.f3040a.getLong("fire-count", 0);
        String str = null;
        String str2 = "";
        for (Map.Entry next : this.f3040a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String str3 : (Set) next.getValue()) {
                    if (str == null || str.compareTo(str3) > 0) {
                        str2 = (String) next.getKey();
                        str = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f3040a.getStringSet(str2, new HashSet()));
        hashSet.remove(str);
        this.f3040a.edit().putStringSet(str2, hashSet).putLong("fire-count", j - 1).commit();
    }

    private synchronized String d(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    private synchronized String e(String str) {
        for (Map.Entry next : this.f3040a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return (String) next.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private synchronized void h(String str) {
        String e2 = e(str);
        if (e2 != null) {
            HashSet hashSet = new HashSet(this.f3040a.getStringSet(e2, new HashSet()));
            hashSet.remove(str);
            (hashSet.isEmpty() ? this.f3040a.edit().remove(e2) : this.f3040a.edit().putStringSet(e2, hashSet)).commit();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        SharedPreferences.Editor edit = this.f3040a.edit();
        for (Map.Entry next : this.f3040a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                edit.remove((String) next.getKey());
            }
        }
        edit.remove("fire-count");
        edit.commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized List<m> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry next : this.f3040a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                arrayList.add(m.a((String) next.getKey(), new ArrayList((Set) next.getValue())));
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean f(long j, long j2) {
        return d(j).equals(d(j2));
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        String d2 = d(System.currentTimeMillis());
        this.f3040a.edit().putString("last-used-date", d2).commit();
        h(d2);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i(long j) {
        return j("fire-global", j);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean j(String str, long j) {
        if (!this.f3040a.contains(str)) {
            this.f3040a.edit().putLong(str, j).commit();
            return true;
        } else if (f(this.f3040a.getLong(str, -1), j)) {
            return false;
        } else {
            this.f3040a.edit().putLong(str, j).commit();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(long j, String str) {
        String d2 = d(j);
        if (!this.f3040a.getString("last-used-date", "").equals(d2)) {
            long j2 = this.f3040a.getLong("fire-count", 0);
            if (j2 + 1 == 30) {
                a();
                j2 = this.f3040a.getLong("fire-count", 0);
            }
            HashSet hashSet = new HashSet(this.f3040a.getStringSet(str, new HashSet()));
            hashSet.add(d2);
            this.f3040a.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", d2).commit();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void l(long j) {
        this.f3040a.edit().putLong("fire-global", j).commit();
    }
}
