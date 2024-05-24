package c.d.a.b.e.e;

final class ya {
    static String a(r7 r7Var) {
        String str;
        StringBuilder sb = new StringBuilder(r7Var.i());
        for (int i = 0; i < r7Var.i(); i++) {
            int d2 = r7Var.d(i);
            if (d2 == 34) {
                str = "\\\"";
            } else if (d2 == 39) {
                str = "\\'";
            } else if (d2 != 92) {
                switch (d2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (d2 < 32 || d2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((d2 >>> 6) & 3) + 48));
                            sb.append((char) (((d2 >>> 3) & 7) + 48));
                            d2 = (d2 & 7) + 48;
                        }
                        sb.append((char) d2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
