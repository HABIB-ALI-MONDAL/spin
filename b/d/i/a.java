package b.d.i;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import b.d.j.c;

public class a implements Spannable {
    private final Spannable j;
    private final C0025a k;
    private final PrecomputedText l;

    /* renamed from: b.d.i.a$a  reason: collision with other inner class name */
    public static final class C0025a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f606a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f607b;

        /* renamed from: c  reason: collision with root package name */
        private final int f608c;

        /* renamed from: d  reason: collision with root package name */
        private final int f609d;

        /* renamed from: b.d.i.a$a$a  reason: collision with other inner class name */
        public static class C0026a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f610a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f611b;

            /* renamed from: c  reason: collision with root package name */
            private int f612c;

            /* renamed from: d  reason: collision with root package name */
            private int f613d;

            public C0026a(TextPaint textPaint) {
                this.f610a = textPaint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.f612c = 1;
                    this.f613d = 1;
                } else {
                    this.f613d = 0;
                    this.f612c = 0;
                }
                this.f611b = i >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public C0025a a() {
                return new C0025a(this.f610a, this.f611b, this.f612c, this.f613d);
            }

            public C0026a b(int i) {
                this.f612c = i;
                return this;
            }

            public C0026a c(int i) {
                this.f613d = i;
                return this;
            }

            public C0026a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f611b = textDirectionHeuristic;
                return this;
            }
        }

        public C0025a(PrecomputedText.Params params) {
            this.f606a = params.getTextPaint();
            this.f607b = params.getTextDirection();
            this.f608c = params.getBreakStrategy();
            this.f609d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        @SuppressLint({"NewApi"})
        C0025a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f606a = textPaint;
            this.f607b = textDirectionHeuristic;
            this.f608c = i;
            this.f609d = i2;
        }

        public boolean a(C0025a aVar) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.f608c != aVar.b() || this.f609d != aVar.c())) || this.f606a.getTextSize() != aVar.e().getTextSize() || this.f606a.getTextScaleX() != aVar.e().getTextScaleX() || this.f606a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i >= 21 && (this.f606a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f606a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f606a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.f606a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f606a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f606a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f606a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f608c;
        }

        public int c() {
            return this.f609d;
        }

        public TextDirectionHeuristic d() {
            return this.f607b;
        }

        public TextPaint e() {
            return this.f606a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0025a)) {
                return false;
            }
            C0025a aVar = (C0025a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f607b == aVar.d();
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return c.b(Float.valueOf(this.f606a.getTextSize()), Float.valueOf(this.f606a.getTextScaleX()), Float.valueOf(this.f606a.getTextSkewX()), Float.valueOf(this.f606a.getLetterSpacing()), Integer.valueOf(this.f606a.getFlags()), this.f606a.getTextLocales(), this.f606a.getTypeface(), Boolean.valueOf(this.f606a.isElegantTextHeight()), this.f607b, Integer.valueOf(this.f608c), Integer.valueOf(this.f609d));
            } else if (i >= 21) {
                return c.b(Float.valueOf(this.f606a.getTextSize()), Float.valueOf(this.f606a.getTextScaleX()), Float.valueOf(this.f606a.getTextSkewX()), Float.valueOf(this.f606a.getLetterSpacing()), Integer.valueOf(this.f606a.getFlags()), this.f606a.getTextLocale(), this.f606a.getTypeface(), Boolean.valueOf(this.f606a.isElegantTextHeight()), this.f607b, Integer.valueOf(this.f608c), Integer.valueOf(this.f609d));
            } else if (i >= 18) {
                return c.b(Float.valueOf(this.f606a.getTextSize()), Float.valueOf(this.f606a.getTextScaleX()), Float.valueOf(this.f606a.getTextSkewX()), Integer.valueOf(this.f606a.getFlags()), this.f606a.getTextLocale(), this.f606a.getTypeface(), this.f607b, Integer.valueOf(this.f608c), Integer.valueOf(this.f609d));
            } else if (i >= 17) {
                return c.b(Float.valueOf(this.f606a.getTextSize()), Float.valueOf(this.f606a.getTextScaleX()), Float.valueOf(this.f606a.getTextSkewX()), Integer.valueOf(this.f606a.getFlags()), this.f606a.getTextLocale(), this.f606a.getTypeface(), this.f607b, Integer.valueOf(this.f608c), Integer.valueOf(this.f609d));
            } else {
                return c.b(Float.valueOf(this.f606a.getTextSize()), Float.valueOf(this.f606a.getTextScaleX()), Float.valueOf(this.f606a.getTextSkewX()), Integer.valueOf(this.f606a.getFlags()), this.f606a.getTypeface(), this.f607b, Integer.valueOf(this.f608c), Integer.valueOf(this.f609d));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x00df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "{"
                r0.<init>(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "textSize="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f606a
                float r2 = r2.getTextSize()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textScaleX="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f606a
                float r2 = r2.getTextScaleX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textSkewX="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f606a
                float r2 = r2.getTextSkewX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r1 < r2) goto L_0x008f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = ", letterSpacing="
                r2.append(r3)
                android.text.TextPaint r3 = r4.f606a
                float r3 = r3.getLetterSpacing()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = ", elegantTextHeight="
                r2.append(r3)
                android.text.TextPaint r3 = r4.f606a
                boolean r3 = r3.isElegantTextHeight()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
            L_0x008f:
                r2 = 24
                java.lang.String r3 = ", textLocale="
                if (r1 < r2) goto L_0x00ae
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r3)
                android.text.TextPaint r3 = r4.f606a
                android.os.LocaleList r3 = r3.getTextLocales()
            L_0x00a3:
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
                goto L_0x00c1
            L_0x00ae:
                r2 = 17
                if (r1 < r2) goto L_0x00c1
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r3)
                android.text.TextPaint r3 = r4.f606a
                java.util.Locale r3 = r3.getTextLocale()
                goto L_0x00a3
            L_0x00c1:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = ", typeface="
                r2.append(r3)
                android.text.TextPaint r3 = r4.f606a
                android.graphics.Typeface r3 = r3.getTypeface()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.append(r2)
                r2 = 26
                if (r1 < r2) goto L_0x00f9
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", variationSettings="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f606a
                java.lang.String r2 = r2.getFontVariationSettings()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
            L_0x00f9:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textDir="
                r1.append(r2)
                android.text.TextDirectionHeuristic r2 = r4.f607b
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", breakStrategy="
                r1.append(r2)
                int r2 = r4.f608c
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", hyphenationFrequency="
                r1.append(r2)
                int r2 = r4.f609d
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.String r1 = "}"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.i.a.C0025a.toString():java.lang.String");
        }
    }

    public C0025a a() {
        return this.k;
    }

    public PrecomputedText b() {
        Spannable spannable = this.j;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i) {
        return this.j.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.j.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.j.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.j.getSpanStart(obj);
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.l.getSpans(i, i2, cls) : this.j.getSpans(i, i2, cls);
    }

    public int length() {
        return this.j.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.j.nextSpanTransition(i, i2, cls);
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.l.removeSpan(obj);
        } else {
            this.j.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.l.setSpan(obj, i, i2, i3);
        } else {
            this.j.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.j.subSequence(i, i2);
    }

    public String toString() {
        return this.j.toString();
    }
}
