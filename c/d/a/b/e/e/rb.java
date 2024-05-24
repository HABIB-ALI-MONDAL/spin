package c.d.a.b.e.e;

public enum rb {
    DOUBLE(sb.DOUBLE, 1),
    FLOAT(sb.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(sb.BOOLEAN, 0),
    STRING(sb.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(sb.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(sb.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final sb j;

    private rb(sb sbVar, int i) {
        this.j = sbVar;
    }

    public final sb d() {
        return this.j;
    }
}
