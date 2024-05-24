package org.cocos2dx.okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater2 != null) {
            this.sink = bufferedSink;
            this.deflater = deflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
    }

    @IgnoreJRERequirement
    private void deflate(boolean z) {
        d writableSegment;
        Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            Deflater deflater2 = this.deflater;
            byte[] bArr = writableSegment.f3261a;
            int i = writableSegment.f3263c;
            int i2 = 8192 - i;
            int deflate = z ? deflater2.deflate(bArr, i, i2, 2) : deflater2.deflate(bArr, i, i2);
            if (deflate > 0) {
                writableSegment.f3263c += deflate;
                buffer.size += (long) deflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.f3262b == writableSegment.f3263c) {
            buffer.head = writableSegment.b();
            e.a(writableSegment);
        }
    }

    public void close() {
        if (!this.closed) {
            try {
                finishDeflate();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                g.f(th);
                throw null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void finishDeflate() {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() {
        deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    public void write(Buffer buffer, long j) {
        g.b(buffer.size, 0, j);
        while (j > 0) {
            d dVar = buffer.head;
            int min = (int) Math.min(j, (long) (dVar.f3263c - dVar.f3262b));
            this.deflater.setInput(dVar.f3261a, dVar.f3262b, min);
            deflate(false);
            long j2 = (long) min;
            buffer.size -= j2;
            int i = dVar.f3262b + min;
            dVar.f3262b = i;
            if (i == dVar.f3263c) {
                buffer.head = dVar.b();
                e.a(dVar);
            }
            j -= j2;
        }
    }
}
