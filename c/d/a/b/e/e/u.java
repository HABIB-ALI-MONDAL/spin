package c.d.a.b.e.e;

import java.util.Iterator;

public final class u implements Iterable, q {
    /* access modifiers changed from: private */
    public final String j;

    public u(String str) {
        if (str != null) {
            this.j = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final q d() {
        return new u(this.j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return this.j.equals(((u) obj).j);
    }

    public final Double f() {
        double d2;
        if (this.j.isEmpty()) {
            d2 = 0.0d;
        } else {
            try {
                return Double.valueOf(this.j);
            } catch (NumberFormatException unused) {
                d2 = Double.NaN;
            }
        }
        return Double.valueOf(d2);
    }

    public final String g() {
        return this.j;
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final Iterator i() {
        return new s(this);
    }

    public final Iterator iterator() {
        return new t(this);
    }

    public final Boolean k() {
        return Boolean.valueOf(!this.j.isEmpty());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0190, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0191, code lost:
        c.d.a.b.e.e.n5.h(r5, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01a6, code lost:
        c.d.a.b.e.e.n5.h(r5, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01bd, code lost:
        r0 = r21;
        c.d.a.b.e.e.n5.h(r6, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c7, code lost:
        c.d.a.b.e.e.n5.h("toLowerCase", 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01de, code lost:
        c.d.a.b.e.e.n5.h("toLocaleLowerCase", 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f4, code lost:
        c.d.a.b.e.e.n5.h(r14, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0209, code lost:
        r1 = r24;
        c.d.a.b.e.e.n5.j("substring", 2, r1);
        r2 = r21.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0218, code lost:
        if (r24.isEmpty() != false) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x021a, code lost:
        r3 = r23;
        r4 = (int) c.d.a.b.e.e.n5.a(r3.b((c.d.a.b.e.e.q) r1.get(0)).f().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0234, code lost:
        r3 = r23;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x023c, code lost:
        if (r24.size() <= 1) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x023e, code lost:
        r1 = (int) c.d.a.b.e.e.n5.a(r3.b((c.d.a.b.e.e.q) r1.get(1)).f().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0256, code lost:
        r1 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x025a, code lost:
        r4 = java.lang.Math.min(java.lang.Math.max(r4, 0), r2.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r2.length());
        r3 = new c.d.a.b.e.e.u(r2.substring(java.lang.Math.min(r4, r1), java.lang.Math.max(r4, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0286, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("split", 2, r1);
        r2 = r0.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0296, code lost:
        if (r2.length() != 0) goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02a9, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b3, code lost:
        if (r24.isEmpty() == false) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b5, code lost:
        r5.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ba, code lost:
        r4 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02cd, code lost:
        if (r24.size() <= 1) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02cf, code lost:
        r6 = c.d.a.b.e.e.n5.d(r3.b((c.d.a.b.e.e.q) r1.get(1)).f().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02e6, code lost:
        r6 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ed, code lost:
        if (r6 != 0) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02f6, code lost:
        r1 = r2.split(java.util.regex.Pattern.quote(r4), ((int) r6) + 1);
        r2 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0306, code lost:
        if (r4.isEmpty() == false) goto L_0x031d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0308, code lost:
        if (r2 <= 0) goto L_0x031d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x030a, code lost:
        r14 = r1[0].isEmpty();
        r3 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0319, code lost:
        if (r1[r3].isEmpty() != false) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x031b, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x031d, code lost:
        r3 = r2;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0322, code lost:
        if (((long) r2) <= r6) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0324, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0326, code lost:
        if (r14 >= r3) goto L_0x0335;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0328, code lost:
        r5.add(new c.d.a.b.e.e.u(r1[r14]));
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x033c, code lost:
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("slice", 2, r1);
        r2 = r21.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x034c, code lost:
        if (r24.isEmpty() != false) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x034e, code lost:
        r4 = r3.b((c.d.a.b.e.e.q) r1.get(0)).f().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0362, code lost:
        r4 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0364, code lost:
        r4 = c.d.a.b.e.e.n5.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x036c, code lost:
        if (r4 >= 0.0d) goto L_0x037c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x036e, code lost:
        r8 = (double) r2.length();
        java.lang.Double.isNaN(r8);
        r4 = java.lang.Math.max(r8 + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x037c, code lost:
        r4 = java.lang.Math.min(r4, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0385, code lost:
        r4 = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x038b, code lost:
        if (r24.size() <= 1) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x038d, code lost:
        r5 = r3.b((c.d.a.b.e.e.q) r1.get(1)).f().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03a0, code lost:
        r5 = (double) r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03a5, code lost:
        r5 = c.d.a.b.e.e.n5.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03ad, code lost:
        if (r5 >= 0.0d) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03af, code lost:
        r10 = (double) r2.length();
        java.lang.Double.isNaN(r10);
        r5 = java.lang.Math.max(r10 + r5, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03bd, code lost:
        r5 = java.lang.Math.min(r5, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03c6, code lost:
        r3 = new c.d.a.b.e.e.u(r2.substring(r4, java.lang.Math.max(0, ((int) r5) - r4) + r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03d9, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("search", 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03e8, code lost:
        if (r24.isEmpty() != false) goto L_0x03f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03ea, code lost:
        r17 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03f8, code lost:
        r1 = java.util.regex.Pattern.compile(r17).matcher(r0.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0406, code lost:
        if (r1.find() == false) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0425, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("replace", 2, r1);
        r2 = c.d.a.b.e.e.q.f1722b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0435, code lost:
        if (r24.isEmpty() != false) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0437, code lost:
        r17 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x044b, code lost:
        if (r24.size() <= 1) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x044d, code lost:
        r2 = r3.b((c.d.a.b.e.e.q) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0457, code lost:
        r1 = r17;
        r4 = r0.j;
        r5 = r4.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x045f, code lost:
        if (r5 < 0) goto L_0x0639;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0463, code lost:
        if ((r2 instanceof c.d.a.b.e.e.j) == false) goto L_0x048a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0465, code lost:
        r2 = ((c.d.a.b.e.e.j) r2).a(r3, java.util.Arrays.asList(new c.d.a.b.e.e.q[]{new c.d.a.b.e.e.u(r1), new c.d.a.b.e.e.i(java.lang.Double.valueOf((double) r5)), r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x048a, code lost:
        r3 = new c.d.a.b.e.e.u(r4.substring(0, r5) + r2.g() + r4.substring(r5 + r1.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04b5, code lost:
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("match", 1, r1);
        r2 = r21.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04c5, code lost:
        if (r24.size() > 0) goto L_0x04ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04c7, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04ca, code lost:
        r1 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04d9, code lost:
        r1 = java.util.regex.Pattern.compile(r1).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04e5, code lost:
        if (r1.find() == false) goto L_0x0501;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0505, code lost:
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("lastIndexOf", 2, r1);
        r4 = r21.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0516, code lost:
        if (r24.size() > 0) goto L_0x0519;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0519, code lost:
        r17 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0527, code lost:
        r5 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x052d, code lost:
        if (r24.size() >= 2) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x052f, code lost:
        r1 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0532, code lost:
        r1 = r3.b((c.d.a.b.e.e.q) r1.get(1)).f().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0549, code lost:
        if (java.lang.Double.isNaN(r1) == false) goto L_0x054e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x054b, code lost:
        r1 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x054e, code lost:
        r1 = c.d.a.b.e.e.n5.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0552, code lost:
        r3 = new c.d.a.b.e.e.i(java.lang.Double.valueOf((double) r4.lastIndexOf(r5, (int) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0562, code lost:
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j("indexOf", 2, r1);
        r4 = r21.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0574, code lost:
        if (r24.size() > 0) goto L_0x0577;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0577, code lost:
        r17 = r3.b((c.d.a.b.e.e.q) r1.get(0)).g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0586, code lost:
        r5 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x058c, code lost:
        if (r24.size() >= 2) goto L_0x0590;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x058e, code lost:
        r1 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0590, code lost:
        r1 = r3.b((c.d.a.b.e.e.q) r1.get(1)).f().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x05a3, code lost:
        r3 = new c.d.a.b.e.e.i(java.lang.Double.valueOf((double) r4.indexOf(r5, (int) c.d.a.b.e.e.n5.a(r1))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x05b9, code lost:
        r1 = r24;
        c.d.a.b.e.e.n5.h(r20, 1, r1);
        r2 = r21.j;
        r1 = r23.b((c.d.a.b.e.e.q) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x05dc, code lost:
        if ("length".equals(r1.g()) == false) goto L_0x05e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05e2, code lost:
        r3 = r1.f().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05f0, code lost:
        if (r3 != java.lang.Math.floor(r3)) goto L_0x05fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05f2, code lost:
        r1 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05f3, code lost:
        if (r1 < 0) goto L_0x05fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x05f9, code lost:
        if (r1 >= r2.length()) goto L_0x05fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0600, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x060a, code lost:
        if (r24.isEmpty() != false) goto L_0x0639;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x060c, code lost:
        r2 = new java.lang.StringBuilder(r0.j);
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0618, code lost:
        if (r14 >= r24.size()) goto L_0x062e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x061a, code lost:
        r2.append(r3.b((c.d.a.b.e.e.q) r1.get(r14)).g());
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x063b, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        c.d.a.b.e.e.n5.j(r19, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x064b, code lost:
        if (r24.isEmpty() != false) goto L_0x0666;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x064d, code lost:
        r14 = (int) c.d.a.b.e.e.n5.a(r3.b((c.d.a.b.e.e.q) r1.get(0)).f().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0666, code lost:
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0668, code lost:
        r1 = r0.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x066a, code lost:
        if (r14 < 0) goto L_0x0681;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0670, code lost:
        if (r14 < r1.length()) goto L_0x0673;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        return c.d.a.b.e.e.q.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return new c.d.a.b.e.e.u(r21.j.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return new c.d.a.b.e.e.u(r21.j.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return new c.d.a.b.e.e.u(r21.j.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return new c.d.a.b.e.e.u(r21.j.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return new c.d.a.b.e.e.u(r21.j.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return new c.d.a.b.e.e.f(java.util.Arrays.asList(new c.d.a.b.e.e.q[]{r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return new c.d.a.b.e.e.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new c.d.a.b.e.e.f(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return new c.d.a.b.e.e.i(java.lang.Double.valueOf((double) r1.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return new c.d.a.b.e.e.i(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return new c.d.a.b.e.e.f(java.util.Arrays.asList(new c.d.a.b.e.e.q[]{new c.d.a.b.e.e.u(r1.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return c.d.a.b.e.e.q.f1723c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return c.d.a.b.e.e.q.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return c.d.a.b.e.e.q.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return new c.d.a.b.e.e.u(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return new c.d.a.b.e.e.u(java.lang.String.valueOf(r1.charAt(r14)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c0, code lost:
        r3 = r17;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x012f, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0158, code lost:
        r3 = r17;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x017d, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x017e, code lost:
        r17 = "undefined";
        r20 = r3;
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0184, code lost:
        switch(r1) {
            case 0: goto L_0x063b;
            case 1: goto L_0x0600;
            case 2: goto L_0x05b9;
            case 3: goto L_0x0562;
            case 4: goto L_0x0505;
            case 5: goto L_0x04b5;
            case 6: goto L_0x0425;
            case 7: goto L_0x03d9;
            case 8: goto L_0x033c;
            case 9: goto L_0x0286;
            case 10: goto L_0x0209;
            case 11: goto L_0x01f4;
            case 12: goto L_0x01de;
            case 13: goto L_0x01c7;
            case 14: goto L_0x01bd;
            case 15: goto L_0x01a6;
            case 16: goto L_0x0191;
            default: goto L_0x0187;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0187, code lost:
        r0 = r21;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.q l(java.lang.String r22, c.d.a.b.e.e.n4 r23, java.util.List r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            java.lang.String r2 = "toLowerCase"
            java.lang.String r0 = "toLocaleLowerCase"
            java.lang.String r3 = "toString"
            r16 = r4
            java.lang.String r4 = "hasOwnProperty"
            r17 = r14
            java.lang.String r14 = "toUpperCase"
            r18 = r14
            if (r5 != 0) goto L_0x00af
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r13.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x00af
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x00af
            r5 = r18
            boolean r18 = r5.equals(r1)
            r14 = r17
            if (r18 != 0) goto L_0x00b3
            boolean r17 = r14.equals(r1)
            if (r17 != 0) goto L_0x00b3
            r17 = r4
            java.lang.String r4 = "trim"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x009d
            goto L_0x00b5
        L_0x009d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00af:
            r14 = r17
            r5 = r18
        L_0x00b3:
            r17 = r4
        L_0x00b5:
            int r4 = r22.hashCode()
            r19 = r3
            switch(r4) {
                case -1789698943: goto L_0x016f;
                case -1776922004: goto L_0x015d;
                case -1464939364: goto L_0x014e;
                case -1361633751: goto L_0x0140;
                case -1354795244: goto L_0x0132;
                case -1137582698: goto L_0x0127;
                case -906336856: goto L_0x011f;
                case -726908483: goto L_0x0116;
                case -467511597: goto L_0x010e;
                case -399551817: goto L_0x0105;
                case 3568674: goto L_0x00fa;
                case 103668165: goto L_0x00f2;
                case 109526418: goto L_0x00e9;
                case 109648666: goto L_0x00e0;
                case 530542161: goto L_0x00d7;
                case 1094496948: goto L_0x00cf;
                case 1943291465: goto L_0x00c6;
                default: goto L_0x00be;
            }
        L_0x00be:
            r4 = r16
        L_0x00c0:
            r3 = r17
            r6 = r19
            goto L_0x017d
        L_0x00c6:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00be
            r1 = 3
            goto L_0x012f
        L_0x00cf:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00be
            r1 = 6
            goto L_0x012f
        L_0x00d7:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00be
            r1 = 10
            goto L_0x012f
        L_0x00e0:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00be
            r1 = 9
            goto L_0x012f
        L_0x00e9:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00be
            r1 = 8
            goto L_0x012f
        L_0x00f2:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00be
            r1 = 5
            goto L_0x012f
        L_0x00fa:
            java.lang.String r4 = "trim"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00be
            r1 = 16
            goto L_0x012f
        L_0x0105:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00be
            r1 = 15
            goto L_0x012f
        L_0x010e:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00be
            r1 = 4
            goto L_0x012f
        L_0x0116:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00be
            r1 = 11
            goto L_0x012f
        L_0x011f:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00be
            r1 = 7
            goto L_0x012f
        L_0x0127:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00be
            r1 = 13
        L_0x012f:
            r4 = r16
            goto L_0x0158
        L_0x0132:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00be
            r4 = r16
            r3 = r17
            r6 = r19
            r1 = 1
            goto L_0x017e
        L_0x0140:
            r4 = r16
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00c0
            r3 = r17
            r6 = r19
            r1 = 0
            goto L_0x017e
        L_0x014e:
            r4 = r16
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00c0
            r1 = 12
        L_0x0158:
            r3 = r17
            r6 = r19
            goto L_0x017e
        L_0x015d:
            r4 = r16
            r6 = r19
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x016c
            r1 = 14
            r3 = r17
            goto L_0x017e
        L_0x016c:
            r3 = r17
            goto L_0x017d
        L_0x016f:
            r4 = r16
            r3 = r17
            r6 = r19
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x017d
            r1 = 2
            goto L_0x017e
        L_0x017d:
            r1 = -1
        L_0x017e:
            java.lang.String r17 = "undefined"
            r20 = r3
            r19 = r4
            switch(r1) {
                case 0: goto L_0x063b;
                case 1: goto L_0x0600;
                case 2: goto L_0x05b9;
                case 3: goto L_0x0562;
                case 4: goto L_0x0505;
                case 5: goto L_0x04b5;
                case 6: goto L_0x0425;
                case 7: goto L_0x03d9;
                case 8: goto L_0x033c;
                case 9: goto L_0x0286;
                case 10: goto L_0x0209;
                case 11: goto L_0x01f4;
                case 12: goto L_0x01de;
                case 13: goto L_0x01c7;
                case 14: goto L_0x01bd;
                case 15: goto L_0x01a6;
                case 16: goto L_0x0191;
                default: goto L_0x0187;
            }
        L_0x0187:
            r0 = r21
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Command not supported"
            r1.<init>(r2)
            throw r1
        L_0x0191:
            r1 = r24
            r3 = 0
            c.d.a.b.e.e.n5.h(r5, r3, r1)
            r0 = r21
            java.lang.String r1 = r0.j
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.trim()
            r2.<init>(r1)
            goto L_0x0683
        L_0x01a6:
            r3 = 0
            r0 = r21
            r1 = r24
            c.d.a.b.e.e.n5.h(r5, r3, r1)
            java.lang.String r1 = r0.j
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r3)
            r2.<init>(r1)
            goto L_0x0683
        L_0x01bd:
            r3 = 0
            r0 = r21
            r1 = r24
            c.d.a.b.e.e.n5.h(r6, r3, r1)
            goto L_0x0639
        L_0x01c7:
            r3 = 0
            r0 = r21
            r1 = r24
            c.d.a.b.e.e.n5.h(r2, r3, r1)
            java.lang.String r1 = r0.j
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toLowerCase(r3)
            r2.<init>(r1)
            goto L_0x0683
        L_0x01de:
            r3 = 0
            r1 = r24
            r2 = r0
            r0 = r21
            c.d.a.b.e.e.n5.h(r2, r3, r1)
            java.lang.String r1 = r0.j
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.toLowerCase()
            r2.<init>(r1)
            goto L_0x0683
        L_0x01f4:
            r3 = 0
            r0 = r21
            r1 = r24
            c.d.a.b.e.e.n5.h(r14, r3, r1)
            java.lang.String r1 = r0.j
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.toUpperCase()
            r2.<init>(r1)
            goto L_0x0683
        L_0x0209:
            r0 = r21
            r1 = r24
            r2 = 2
            r3 = 0
            c.d.a.b.e.e.n5.j(r9, r2, r1)
            java.lang.String r2 = r0.j
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x0234
            java.lang.Object r4 = r1.get(r3)
            c.d.a.b.e.e.q r4 = (c.d.a.b.e.e.q) r4
            r3 = r23
            c.d.a.b.e.e.q r4 = r3.b(r4)
            java.lang.Double r4 = r4.f()
            double r4 = r4.doubleValue()
            double r4 = c.d.a.b.e.e.n5.a(r4)
            int r4 = (int) r4
            goto L_0x0237
        L_0x0234:
            r3 = r23
            r4 = 0
        L_0x0237:
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0256
            java.lang.Object r1 = r1.get(r6)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r5 = r1.doubleValue()
            double r5 = c.d.a.b.e.e.n5.a(r5)
            int r1 = (int) r5
            goto L_0x025a
        L_0x0256:
            int r1 = r2.length()
        L_0x025a:
            r3 = 0
            int r4 = java.lang.Math.max(r4, r3)
            int r5 = r2.length()
            int r4 = java.lang.Math.min(r4, r5)
            int r1 = java.lang.Math.max(r1, r3)
            int r3 = r2.length()
            int r1 = java.lang.Math.min(r1, r3)
            c.d.a.b.e.e.u r3 = new c.d.a.b.e.e.u
            int r5 = java.lang.Math.min(r4, r1)
            int r1 = java.lang.Math.max(r4, r1)
            java.lang.String r1 = r2.substring(r5, r1)
            r3.<init>(r1)
            goto L_0x05b6
        L_0x0286:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            c.d.a.b.e.e.n5.j(r10, r2, r1)
            java.lang.String r2 = r0.j
            int r4 = r2.length()
            if (r4 != 0) goto L_0x02a9
            c.d.a.b.e.e.f r2 = new c.d.a.b.e.e.f
            r1 = 1
            c.d.a.b.e.e.q[] r1 = new c.d.a.b.e.e.q[r1]
            r4 = 0
            r1[r4] = r0
            java.util.List r1 = java.util.Arrays.asList(r1)
            r2.<init>(r1)
            goto L_0x0683
        L_0x02a9:
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r6 = r24.isEmpty()
            if (r6 == 0) goto L_0x02ba
            r5.add(r0)
            goto L_0x0335
        L_0x02ba:
            java.lang.Object r6 = r1.get(r4)
            c.d.a.b.e.e.q r6 = (c.d.a.b.e.e.q) r6
            c.d.a.b.e.e.q r4 = r3.b(r6)
            java.lang.String r4 = r4.g()
            int r6 = r24.size()
            r7 = 1
            if (r6 <= r7) goto L_0x02e6
            java.lang.Object r1 = r1.get(r7)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r6 = r1.doubleValue()
            long r6 = c.d.a.b.e.e.n5.d(r6)
            goto L_0x02e9
        L_0x02e6:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02e9:
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x02f6
            c.d.a.b.e.e.f r2 = new c.d.a.b.e.e.f
            r2.<init>()
            goto L_0x0683
        L_0x02f6:
            java.lang.String r1 = java.util.regex.Pattern.quote(r4)
            int r3 = (int) r6
            r8 = 1
            int r3 = r3 + r8
            java.lang.String[] r1 = r2.split(r1, r3)
            int r2 = r1.length
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L_0x031d
            if (r2 <= 0) goto L_0x031d
            r3 = 0
            r3 = r1[r3]
            boolean r14 = r3.isEmpty()
            int r3 = r2 + -1
            r4 = r1[r3]
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x031f
            r3 = r2
            goto L_0x031f
        L_0x031d:
            r3 = r2
            r14 = 0
        L_0x031f:
            long r8 = (long) r2
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0326
            int r3 = r3 + -1
        L_0x0326:
            if (r14 >= r3) goto L_0x0335
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            r4 = r1[r14]
            r2.<init>(r4)
            r5.add(r2)
            int r14 = r14 + 1
            goto L_0x0326
        L_0x0335:
            c.d.a.b.e.e.f r2 = new c.d.a.b.e.e.f
            r2.<init>(r5)
            goto L_0x0683
        L_0x033c:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            c.d.a.b.e.e.n5.j(r11, r2, r1)
            java.lang.String r2 = r0.j
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x0362
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            c.d.a.b.e.e.q r5 = (c.d.a.b.e.e.q) r5
            c.d.a.b.e.e.q r4 = r3.b(r5)
            java.lang.Double r4 = r4.f()
            double r4 = r4.doubleValue()
            goto L_0x0364
        L_0x0362:
            r4 = 0
        L_0x0364:
            double r4 = c.d.a.b.e.e.n5.a(r4)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x037c
            int r8 = r2.length()
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 + r4
            double r4 = java.lang.Math.max(r8, r6)
            goto L_0x0385
        L_0x037c:
            int r6 = r2.length()
            double r6 = (double) r6
            double r4 = java.lang.Math.min(r4, r6)
        L_0x0385:
            int r4 = (int) r4
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x03a0
            java.lang.Object r1 = r1.get(r6)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r5 = r1.doubleValue()
            goto L_0x03a5
        L_0x03a0:
            int r1 = r2.length()
            double r5 = (double) r1
        L_0x03a5:
            double r5 = c.d.a.b.e.e.n5.a(r5)
            r8 = 0
            int r1 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x03bd
            int r1 = r2.length()
            double r10 = (double) r1
            java.lang.Double.isNaN(r10)
            double r10 = r10 + r5
            double r5 = java.lang.Math.max(r10, r8)
            goto L_0x03c6
        L_0x03bd:
            int r1 = r2.length()
            double r7 = (double) r1
            double r5 = java.lang.Math.min(r5, r7)
        L_0x03c6:
            int r1 = (int) r5
            int r1 = r1 - r4
            r5 = 0
            int r1 = java.lang.Math.max(r5, r1)
            c.d.a.b.e.e.u r3 = new c.d.a.b.e.e.u
            int r1 = r1 + r4
            java.lang.String r1 = r2.substring(r4, r1)
            r3.<init>(r1)
            goto L_0x05b6
        L_0x03d9:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 1
            r5 = 0
            c.d.a.b.e.e.n5.j(r15, r2, r1)
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x03f8
            java.lang.Object r1 = r1.get(r5)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.String r17 = r1.g()
        L_0x03f8:
            java.lang.String r1 = r0.j
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r17)
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x0418
            c.d.a.b.e.e.i r2 = new c.d.a.b.e.e.i
            int r1 = r1.start()
            double r3 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x0683
        L_0x0418:
            c.d.a.b.e.e.i r2 = new c.d.a.b.e.e.i
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x0683
        L_0x0425:
            r2 = 2
            r0 = r21
            r3 = r23
            r1 = r24
            c.d.a.b.e.e.n5.j(r8, r2, r1)
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.f1722b
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x0457
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            c.d.a.b.e.e.q r5 = (c.d.a.b.e.e.q) r5
            c.d.a.b.e.e.q r4 = r3.b(r5)
            java.lang.String r17 = r4.g()
            int r4 = r24.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0457
            java.lang.Object r1 = r1.get(r5)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r2 = r3.b(r1)
        L_0x0457:
            r1 = r17
            java.lang.String r4 = r0.j
            int r5 = r4.indexOf(r1)
            if (r5 < 0) goto L_0x0639
            boolean r6 = r2 instanceof c.d.a.b.e.e.j
            if (r6 == 0) goto L_0x048a
            c.d.a.b.e.e.j r2 = (c.d.a.b.e.e.j) r2
            r6 = 3
            c.d.a.b.e.e.q[] r6 = new c.d.a.b.e.e.q[r6]
            c.d.a.b.e.e.u r7 = new c.d.a.b.e.e.u
            r7.<init>(r1)
            r8 = 0
            r6[r8] = r7
            c.d.a.b.e.e.i r7 = new c.d.a.b.e.e.i
            double r8 = (double) r5
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 1
            r6[r8] = r7
            r7 = 2
            r6[r7] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            c.d.a.b.e.e.q r2 = r2.a(r3, r6)
        L_0x048a:
            c.d.a.b.e.e.u r3 = new c.d.a.b.e.e.u
            r6 = 0
            java.lang.String r6 = r4.substring(r6, r5)
            java.lang.String r2 = r2.g()
            int r1 = r1.length()
            int r5 = r5 + r1
            java.lang.String r1 = r4.substring(r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            goto L_0x05b6
        L_0x04b5:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 1
            c.d.a.b.e.e.n5.j(r12, r2, r1)
            java.lang.String r2 = r0.j
            int r4 = r24.size()
            if (r4 > 0) goto L_0x04ca
            java.lang.String r1 = ""
            goto L_0x04d9
        L_0x04ca:
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.String r1 = r1.g()
        L_0x04d9:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r2)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x0501
            c.d.a.b.e.e.f r2 = new c.d.a.b.e.e.f
            r3 = 1
            c.d.a.b.e.e.q[] r3 = new c.d.a.b.e.e.q[r3]
            c.d.a.b.e.e.u r4 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.group()
            r4.<init>(r1)
            r5 = 0
            r3[r5] = r4
            java.util.List r1 = java.util.Arrays.asList(r3)
            r2.<init>(r1)
            goto L_0x0683
        L_0x0501:
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.f1723c
            goto L_0x0683
        L_0x0505:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            r5 = 0
            c.d.a.b.e.e.n5.j(r13, r2, r1)
            java.lang.String r4 = r0.j
            int r6 = r24.size()
            if (r6 > 0) goto L_0x0519
            goto L_0x0527
        L_0x0519:
            java.lang.Object r5 = r1.get(r5)
            c.d.a.b.e.e.q r5 = (c.d.a.b.e.e.q) r5
            c.d.a.b.e.e.q r5 = r3.b(r5)
            java.lang.String r17 = r5.g()
        L_0x0527:
            r5 = r17
            int r6 = r24.size()
            if (r6 >= r2) goto L_0x0532
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0545
        L_0x0532:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r1 = r1.doubleValue()
        L_0x0545:
            boolean r3 = java.lang.Double.isNaN(r1)
            if (r3 == 0) goto L_0x054e
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0552
        L_0x054e:
            double r1 = c.d.a.b.e.e.n5.a(r1)
        L_0x0552:
            c.d.a.b.e.e.i r3 = new c.d.a.b.e.e.i
            int r1 = (int) r1
            int r1 = r4.lastIndexOf(r5, r1)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r3.<init>(r1)
            goto L_0x05b6
        L_0x0562:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            r8 = 0
            c.d.a.b.e.e.n5.j(r7, r2, r1)
            java.lang.String r4 = r0.j
            int r5 = r24.size()
            if (r5 > 0) goto L_0x0577
            goto L_0x0586
        L_0x0577:
            r5 = 0
            java.lang.Object r5 = r1.get(r5)
            c.d.a.b.e.e.q r5 = (c.d.a.b.e.e.q) r5
            c.d.a.b.e.e.q r5 = r3.b(r5)
            java.lang.String r17 = r5.g()
        L_0x0586:
            r5 = r17
            int r6 = r24.size()
            if (r6 >= r2) goto L_0x0590
            r1 = r8
            goto L_0x05a3
        L_0x0590:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r1 = r1.doubleValue()
        L_0x05a3:
            double r1 = c.d.a.b.e.e.n5.a(r1)
            c.d.a.b.e.e.i r3 = new c.d.a.b.e.e.i
            int r1 = (int) r1
            int r1 = r4.indexOf(r5, r1)
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r3.<init>(r1)
        L_0x05b6:
            r2 = r3
            goto L_0x0683
        L_0x05b9:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = r20
            r4 = 1
            c.d.a.b.e.e.n5.h(r2, r4, r1)
            java.lang.String r2 = r0.j
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.String r3 = r1.g()
            java.lang.String r4 = "length"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x05e2
        L_0x05de:
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.g
            goto L_0x0683
        L_0x05e2:
            java.lang.Double r1 = r1.f()
            double r3 = r1.doubleValue()
            double r5 = java.lang.Math.floor(r3)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x05fc
            int r1 = (int) r3
            if (r1 < 0) goto L_0x05fc
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x05fc
            goto L_0x05de
        L_0x05fc:
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.h
            goto L_0x0683
        L_0x0600:
            r0 = r21
            r3 = r23
            r1 = r24
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x0639
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = r0.j
            r2.<init>(r4)
            r14 = 0
        L_0x0614:
            int r4 = r24.size()
            if (r14 >= r4) goto L_0x062e
            java.lang.Object r4 = r1.get(r14)
            c.d.a.b.e.e.q r4 = (c.d.a.b.e.e.q) r4
            c.d.a.b.e.e.q r4 = r3.b(r4)
            java.lang.String r4 = r4.g()
            r2.append(r4)
            int r14 = r14 + 1
            goto L_0x0614
        L_0x062e:
            c.d.a.b.e.e.u r1 = new c.d.a.b.e.e.u
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = r1
            goto L_0x0683
        L_0x0639:
            r2 = r0
            goto L_0x0683
        L_0x063b:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = r19
            r4 = 1
            c.d.a.b.e.e.n5.j(r2, r4, r1)
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x0666
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r3.b(r1)
            java.lang.Double r1 = r1.f()
            double r1 = r1.doubleValue()
            double r1 = c.d.a.b.e.e.n5.a(r1)
            int r14 = (int) r1
            goto L_0x0668
        L_0x0666:
            r2 = 0
            r14 = 0
        L_0x0668:
            java.lang.String r1 = r0.j
            if (r14 < 0) goto L_0x0681
            int r2 = r1.length()
            if (r14 < r2) goto L_0x0673
            goto L_0x0681
        L_0x0673:
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            char r1 = r1.charAt(r14)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.<init>(r1)
            goto L_0x0683
        L_0x0681:
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.i
        L_0x0683:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.u.l(java.lang.String, c.d.a.b.e.e.n4, java.util.List):c.d.a.b.e.e.q");
    }

    public final String toString() {
        String str = this.j;
        return "\"" + str + "\"";
    }
}
