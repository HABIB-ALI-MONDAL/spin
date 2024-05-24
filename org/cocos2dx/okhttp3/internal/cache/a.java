package org.cocos2dx.okhttp3.internal.cache;

import java.io.IOException;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.ForwardingSink;
import org.cocos2dx.okio.Sink;

class a extends ForwardingSink {
    private boolean j;

    a(Sink sink) {
        super(sink);
    }

    /* access modifiers changed from: protected */
    public void c(IOException iOException) {
        throw null;
    }

    public void close() {
        if (!this.j) {
            try {
                super.close();
            } catch (IOException e2) {
                this.j = true;
                c(e2);
            }
        }
    }

    public void flush() {
        if (!this.j) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.j = true;
                c(e2);
            }
        }
    }

    public void write(Buffer buffer, long j2) {
        if (this.j) {
            buffer.skip(j2);
            return;
        }
        try {
            super.write(buffer, j2);
        } catch (IOException e2) {
            this.j = true;
            c(e2);
        }
    }
}
