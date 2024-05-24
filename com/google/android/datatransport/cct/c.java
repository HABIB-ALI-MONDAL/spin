package com.google.android.datatransport.cct;

import c.d.a.a.b;
import c.d.a.a.i.h;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class c implements h {

    /* renamed from: c  reason: collision with root package name */
    static final String f1860c = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d  reason: collision with root package name */
    static final String f1861d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f1862e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<b> f1863f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b[]{b.b("proto"), b.b("json")})));
    public static final c g;

    /* renamed from: a  reason: collision with root package name */
    private final String f1864a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1865b;

    static {
        String a2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f1861d = a2;
        String a3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f1862e = a3;
        g = new c(a2, a3);
    }

    public c(String str, String str2) {
        this.f1864a = str;
        this.f1865b = str2;
    }

    public static c e(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new c(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public byte[] a() {
        return d();
    }

    public Set<b> b() {
        return f1863f;
    }

    public String c() {
        return "cct";
    }

    public byte[] d() {
        String str = this.f1865b;
        if (str == null && this.f1864a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f1864a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String f() {
        return this.f1865b;
    }

    public String g() {
        return this.f1864a;
    }
}
