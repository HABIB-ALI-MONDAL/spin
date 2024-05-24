package c.d.a.b.e.e;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public final class i implements q {
    private final Double j;

    public i(Double d2) {
        if (d2 == null) {
            this.j = Double.valueOf(Double.NaN);
        } else {
            this.j = d2;
        }
    }

    public final q d() {
        return new i(this.j);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        return this.j.equals(((i) obj).j);
    }

    public final Double f() {
        return this.j;
    }

    public final String g() {
        if (Double.isNaN(this.j.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.j.doubleValue())) {
            return this.j.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal stripTrailingZeros = BigDecimal.valueOf(this.j.doubleValue()).stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((stripTrailingZeros.scale() > 0 ? stripTrailingZeros.precision() : stripTrailingZeros.scale()) - 1);
        String format = decimalFormat.format(stripTrailingZeros);
        int indexOf = format.indexOf("E");
        if (indexOf <= 0) {
            return format;
        }
        int parseInt = Integer.parseInt(format.substring(indexOf + 1));
        return ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) ? format.replace("E-", "e-").replace("E", "e+") : stripTrailingZeros.toPlainString();
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final Iterator i() {
        return null;
    }

    public final Boolean k() {
        boolean z = false;
        if (!Double.isNaN(this.j.doubleValue()) && this.j.doubleValue() != 0.0d) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final q l(String str, n4 n4Var, List list) {
        if ("toString".equals(str)) {
            return new u(g());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{g(), str}));
    }

    public final String toString() {
        return g();
    }
}
