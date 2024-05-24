package c.d.a.b.e.e;

import java.io.IOException;

public class a9 extends IOException {
    public a9(String str) {
        super(str);
    }

    static z8 a() {
        return new z8("Protocol message tag had invalid wire type.");
    }

    static a9 b() {
        return new a9("Protocol message contained an invalid tag (zero).");
    }

    static a9 c() {
        return new a9("Protocol message had invalid UTF-8.");
    }

    static a9 d() {
        return new a9("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static a9 e() {
        return new a9("Failed to parse the message.");
    }

    static a9 f() {
        return new a9("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
