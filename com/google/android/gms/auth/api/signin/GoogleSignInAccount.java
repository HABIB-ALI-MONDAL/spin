package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    final int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private Uri o;
    private String p;
    private long q;
    private String r;
    List s;
    private String t;
    private String u;
    private Set v = new HashSet();

    static {
        g.d();
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List list, String str7, String str8) {
        this.j = i;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.o = uri;
        this.p = str5;
        this.q = j2;
        this.r = str6;
        this.s = list;
        this.t = str7;
        this.u = str8;
    }

    public static GoogleSignInAccount v(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set set) {
        long longValue = l2.longValue();
        n.e(str7);
        n.i(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public static GoogleSignInAccount w(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount v2 = v(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        v2.p = str2;
        return v2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.r.equals(this.r) && googleSignInAccount.t().equals(t());
    }

    public Account g() {
        String str = this.m;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public int hashCode() {
        return ((this.r.hashCode() + 527) * 31) + t().hashCode();
    }

    public String i() {
        return this.n;
    }

    public String j() {
        return this.m;
    }

    public String k() {
        return this.u;
    }

    public String l() {
        return this.t;
    }

    public String p() {
        return this.k;
    }

    public String r() {
        return this.l;
    }

    public Uri s() {
        return this.o;
    }

    public Set<Scope> t() {
        HashSet hashSet = new HashSet(this.s);
        hashSet.addAll(this.v);
        return hashSet;
    }

    public String u() {
        return this.p;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.n(parcel, 2, p(), false);
        c.n(parcel, 3, r(), false);
        c.n(parcel, 4, j(), false);
        c.n(parcel, 5, i(), false);
        c.m(parcel, 6, s(), i, false);
        c.n(parcel, 7, u(), false);
        c.k(parcel, 8, this.q);
        c.n(parcel, 9, this.r, false);
        c.q(parcel, 10, this.s, false);
        c.n(parcel, 11, l(), false);
        c.n(parcel, 12, k(), false);
        c.b(parcel, a2);
    }
}
