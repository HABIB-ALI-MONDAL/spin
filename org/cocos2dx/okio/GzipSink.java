package org.cocos2dx.okio;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink sink2) {
        if (sink2 != null) {
            Deflater deflater2 = new Deflater(-1, true);
            this.deflater = deflater2;
            BufferedSink buffer = Okio.buffer(sink2);
            this.sink = buffer;
            this.deflaterSink = new DeflaterSink(buffer, deflater2);
            writeHeader();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    private void updateCrc(Buffer buffer, long j) {
        d dVar = buffer.head;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (dVar.f3263c - dVar.f3262b));
            this.crc.update(dVar.f3261a, dVar.f3262b, min);
            j -= (long) min;
            dVar = dVar.f3266f;
        }
    }

    private void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    public void close() {
        if (!this.closed) {
            try {
                this.deflaterSink.finishDeflate();
                writeFooter();
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

    public final Deflater deflater() {
        return this.deflater;
    }

    public void flush() {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            updateCrc(buffer, j);
            this.deflaterSink.write(buffer, j);
        }
    }
}
