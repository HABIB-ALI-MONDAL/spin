package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;

public final class j {

    /* renamed from: b  reason: collision with root package name */
    public static final j f2414b = new j((Boolean) null, (Boolean) null);

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f2415a;

    public j(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(i.class);
        this.f2415a = enumMap;
        enumMap.put(i.AD_STORAGE, bool);
        enumMap.put(i.ANALYTICS_STORAGE, bool2);
    }

    public j(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(i.class);
        this.f2415a = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static j a(Bundle bundle) {
        if (bundle == null) {
            return f2414b;
        }
        EnumMap enumMap = new EnumMap(i.class);
        for (i iVar : i.values()) {
            enumMap.put(iVar, n(bundle.getString(iVar.j)));
        }
        return new j(enumMap);
    }

    public static j b(String str) {
        EnumMap enumMap = new EnumMap(i.class);
        if (str != null) {
            int i = 0;
            while (true) {
                i[] iVarArr = i.m;
                int length = iVarArr.length;
                if (i >= 2) {
                    break;
                }
                i iVar = iVarArr[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(iVar, bool);
                }
                i++;
            }
        }
        return new j(enumMap);
    }

    public static String g(Bundle bundle) {
        String string;
        for (i iVar : i.values()) {
            if (bundle.containsKey(iVar.j) && (string = bundle.getString(iVar.j)) != null && n(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean j(int i, int i2) {
        return i <= i2;
    }

    static final int m(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean n(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final j c(j jVar) {
        EnumMap enumMap = new EnumMap(i.class);
        for (i iVar : i.values()) {
            Boolean bool = (Boolean) this.f2415a.get(iVar);
            Boolean bool2 = (Boolean) jVar.f2415a.get(iVar);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put(iVar, bool);
        }
        return new j(enumMap);
    }

    public final j d(j jVar) {
        EnumMap enumMap = new EnumMap(i.class);
        for (i iVar : i.values()) {
            Boolean bool = (Boolean) this.f2415a.get(iVar);
            if (bool == null) {
                bool = (Boolean) jVar.f2415a.get(iVar);
            }
            enumMap.put(iVar, bool);
        }
        return new j(enumMap);
    }

    public final Boolean e() {
        return (Boolean) this.f2415a.get(i.AD_STORAGE);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        for (i iVar : i.values()) {
            if (m((Boolean) this.f2415a.get(iVar)) != m((Boolean) jVar.f2415a.get(iVar))) {
                return false;
            }
        }
        return true;
    }

    public final Boolean f() {
        return (Boolean) this.f2415a.get(i.ANALYTICS_STORAGE);
    }

    public final String h() {
        StringBuilder sb = new StringBuilder("G1");
        i[] iVarArr = i.m;
        int length = iVarArr.length;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.f2415a.get(iVarArr[i]);
            sb.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        }
        return sb.toString();
    }

    public final int hashCode() {
        int i = 17;
        for (Boolean m : this.f2415a.values()) {
            i = (i * 31) + m(m);
        }
        return i;
    }

    public final boolean i(i iVar) {
        Boolean bool = (Boolean) this.f2415a.get(iVar);
        return bool == null || bool.booleanValue();
    }

    public final boolean k(j jVar) {
        return l(jVar, (i[]) this.f2415a.keySet().toArray(new i[0]));
    }

    public final boolean l(j jVar, i... iVarArr) {
        for (i iVar : iVarArr) {
            Boolean bool = (Boolean) this.f2415a.get(iVar);
            Boolean bool2 = (Boolean) jVar.f2415a.get(iVar);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        i[] values = i.values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            i iVar = values[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(iVar.name());
            sb.append("=");
            Boolean bool = (Boolean) this.f2415a.get(iVar);
            sb.append(bool == null ? "uninitialized" : true != bool.booleanValue() ? "denied" : "granted");
        }
        return sb.toString();
    }
}
