package c.d.a.b.e.e;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class z9 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1793a;

    static {
        char[] cArr = new char[80];
        f1793a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(x9 x9Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(x9Var, sb, 0);
        return sb.toString();
    }

    static void b(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object b2 : (List) obj) {
                b(sb, i, str, b2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry b3 : ((Map) obj).entrySet()) {
                b(sb, i, str, b3);
            }
        } else {
            sb.append(10);
            c(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(ya.a(r7.v((String) obj)));
                sb.append('\"');
            } else if (obj instanceof r7) {
                sb.append(": \"");
                sb.append(ya.a((r7) obj));
                sb.append('\"');
            } else if (obj instanceof s8) {
                sb.append(" {");
                d((s8) obj, sb, i + 2);
                sb.append("\n");
                c(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i + 2;
                b(sb, i3, "key", entry.getKey());
                b(sb, i3, "value", entry.getValue());
                sb.append("\n");
                c(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void c(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(f1793a, 0, i2);
            i -= i2;
        }
    }

    private static void d(x9 x9Var, StringBuilder sb, int i) {
        int i2;
        Object obj;
        Method method;
        String substring;
        Object s;
        Method method2;
        x9 x9Var2 = x9Var;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = x9Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring2 = ((String) entry.getKey()).substring(i2);
            if (substring2.endsWith("List") && !substring2.endsWith("OrBuilderList") && !substring2.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                substring = substring2.substring(0, substring2.length() - 4);
                s = s8.s(method2, x9Var2, new Object[0]);
            } else if (!substring2.endsWith("Map") || substring2.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set".concat(String.valueOf(substring2))) && (!substring2.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring2.substring(0, substring2.length() - 5)))))) {
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring2)));
                    if (method4 != null) {
                        Object s2 = s8.s(method4, x9Var2, new Object[0]);
                        if (method5 == null) {
                            if (s2 instanceof Boolean) {
                                if (!((Boolean) s2).booleanValue()) {
                                }
                            } else if (s2 instanceof Integer) {
                                if (((Integer) s2).intValue() == 0) {
                                }
                            } else if (s2 instanceof Float) {
                                if (Float.floatToRawIntBits(((Float) s2).floatValue()) == 0) {
                                }
                            } else if (!(s2 instanceof Double)) {
                                if (s2 instanceof String) {
                                    obj = "";
                                } else if (s2 instanceof r7) {
                                    obj = r7.k;
                                } else if (s2 instanceof x9) {
                                    if (s2 == ((x9) s2).d()) {
                                    }
                                } else if ((s2 instanceof Enum) && ((Enum) s2).ordinal() == 0) {
                                }
                                if (s2.equals(obj)) {
                                }
                            } else if (Double.doubleToRawLongBits(((Double) s2).doubleValue()) == 0) {
                            }
                        } else if (!((Boolean) s8.s(method5, x9Var2, new Object[0])).booleanValue()) {
                        }
                        b(sb2, i3, substring2, s2);
                    }
                }
                i2 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                s = s8.s(method, x9Var2, new Object[0]);
            }
            b(sb2, i3, substring, s);
            i2 = 3;
        }
        if (!(x9Var2 instanceof q8)) {
            bb bbVar = ((s8) x9Var2).zzc;
            if (bbVar != null) {
                bbVar.i(sb2, i3);
                return;
            }
            return;
        }
        j8 j8Var = ((q8) x9Var2).zza;
        throw null;
    }
}
