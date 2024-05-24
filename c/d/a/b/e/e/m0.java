package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;

public final class m0 extends x {
    protected m0() {
        this.f1778a.add(n0.ASSIGN);
        this.f1778a.add(n0.CONST);
        this.f1778a.add(n0.CREATE_ARRAY);
        this.f1778a.add(n0.CREATE_OBJECT);
        this.f1778a.add(n0.EXPRESSION_LIST);
        this.f1778a.add(n0.GET);
        this.f1778a.add(n0.GET_INDEX);
        this.f1778a.add(n0.GET_PROPERTY);
        this.f1778a.add(n0.NULL);
        this.f1778a.add(n0.SET_PROPERTY);
        this.f1778a.add(n0.TYPEOF);
        this.f1778a.add(n0.UNDEFINED);
        this.f1778a.add(n0.VAR);
    }

    public final q a(String str, n4 n4Var, List list) {
        String str2;
        n0 n0Var = n0.ADD;
        int ordinal = n5.e(str).ordinal();
        int i = 0;
        if (ordinal == 3) {
            n5.h(n0.ASSIGN.name(), 2, list);
            q b2 = n4Var.b((q) list.get(0));
            if (!(b2 instanceof u)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[]{b2.getClass().getCanonicalName()}));
            } else if (n4Var.h(b2.g())) {
                q b3 = n4Var.b((q) list.get(1));
                n4Var.g(b2.g(), b3);
                return b3;
            } else {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[]{b2.g()}));
            }
        } else if (ordinal == 14) {
            n5.i(n0.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                int i2 = 0;
                while (i2 < list.size() - 1) {
                    q b4 = n4Var.b((q) list.get(i2));
                    if (b4 instanceof u) {
                        n4Var.f(b4.g(), n4Var.b((q) list.get(i2 + 1)));
                        i2 += 2;
                    } else {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[]{b4.getClass().getCanonicalName()}));
                    }
                }
                return q.f1722b;
            }
            throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
        } else if (ordinal == 24) {
            n5.i(n0.EXPRESSION_LIST.name(), 1, list);
            q qVar = q.f1722b;
            while (i < list.size()) {
                qVar = n4Var.b((q) list.get(i));
                if (!(qVar instanceof h)) {
                    i++;
                } else {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
            }
            return qVar;
        } else if (ordinal == 33) {
            n5.h(n0.GET.name(), 1, list);
            q b5 = n4Var.b((q) list.get(0));
            if (b5 instanceof u) {
                return n4Var.d(b5.g());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[]{b5.getClass().getCanonicalName()}));
        } else if (ordinal == 49) {
            n5.h(n0.NULL.name(), 0, list);
            return q.f1723c;
        } else if (ordinal == 58) {
            n5.h(n0.SET_PROPERTY.name(), 3, list);
            q b6 = n4Var.b((q) list.get(0));
            q b7 = n4Var.b((q) list.get(1));
            q b8 = n4Var.b((q) list.get(2));
            if (b6 == q.f1722b || b6 == q.f1723c) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[]{b7.g(), b6.g()}));
            }
            if ((b6 instanceof f) && (b7 instanceof i)) {
                ((f) b6).B(b7.f().intValue(), b8);
            } else if (b6 instanceof m) {
                ((m) b6).r(b7.g(), b8);
            }
            return b8;
        } else if (ordinal != 17) {
            if (ordinal != 18) {
                if (ordinal == 35 || ordinal == 36) {
                    n5.h(n0.GET_PROPERTY.name(), 2, list);
                    q b9 = n4Var.b((q) list.get(0));
                    q b10 = n4Var.b((q) list.get(1));
                    if ((b9 instanceof f) && n5.k(b10)) {
                        return ((f) b9).u(b10.f().intValue());
                    }
                    if (b9 instanceof m) {
                        return ((m) b9).p(b10.g());
                    }
                    if (b9 instanceof u) {
                        if ("length".equals(b10.g())) {
                            return new i(Double.valueOf((double) b9.g().length()));
                        }
                        if (n5.k(b10) && b10.f().doubleValue() < ((double) b9.g().length())) {
                            return new u(String.valueOf(b9.g().charAt(b10.f().intValue())));
                        }
                    }
                    return q.f1722b;
                }
                switch (ordinal) {
                    case 62:
                        n5.h(n0.TYPEOF.name(), 1, list);
                        q b11 = n4Var.b((q) list.get(0));
                        if (b11 instanceof v) {
                            str2 = "undefined";
                        } else if (b11 instanceof g) {
                            str2 = "boolean";
                        } else if (b11 instanceof i) {
                            str2 = "number";
                        } else if (b11 instanceof u) {
                            str2 = "string";
                        } else if (b11 instanceof p) {
                            str2 = "function";
                        } else if ((b11 instanceof r) || (b11 instanceof h)) {
                            throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{b11}));
                        } else {
                            str2 = "object";
                        }
                        return new u(str2);
                    case 63:
                        n5.h(n0.UNDEFINED.name(), 0, list);
                        return q.f1722b;
                    case 64:
                        n5.i(n0.VAR.name(), 1, list);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            q b12 = n4Var.b((q) it.next());
                            if (b12 instanceof u) {
                                n4Var.e(b12.g(), q.f1722b);
                            } else {
                                throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[]{b12.getClass().getCanonicalName()}));
                            }
                        }
                        return q.f1722b;
                    default:
                        super.b(str);
                        throw null;
                }
            } else if (list.isEmpty()) {
                return new n();
            } else {
                if (list.size() % 2 == 0) {
                    n nVar = new n();
                    while (i < list.size() - 1) {
                        q b13 = n4Var.b((q) list.get(i));
                        q b14 = n4Var.b((q) list.get(i + 1));
                        if ((b13 instanceof h) || (b14 instanceof h)) {
                            throw new IllegalStateException("Failed to evaluate map entry");
                        }
                        nVar.r(b13.g(), b14);
                        i += 2;
                    }
                    return nVar;
                }
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            }
        } else if (list.isEmpty()) {
            return new f();
        } else {
            f fVar = new f();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                q b15 = n4Var.b((q) it2.next());
                if (!(b15 instanceof h)) {
                    fVar.B(i, b15);
                    i++;
                } else {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
            }
            return fVar;
        }
    }
}
