package org.cocos2dx.okio;

import java.io.IOException;

public final class Pipe {
    final Buffer buffer = new Buffer();
    final long maxBufferSize;
    private final Sink sink = new a();
    boolean sinkClosed;
    private final Source source = new b();
    boolean sourceClosed;

    final class a implements Sink {
        final Timeout j = new Timeout();

        a() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (!pipe.sinkClosed) {
                    if (pipe.sourceClosed) {
                        if (pipe.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    Pipe pipe2 = Pipe.this;
                    pipe2.sinkClosed = true;
                    pipe2.buffer.notifyAll();
                }
            }
        }

        public void flush() {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    throw new IllegalStateException("closed");
                } else if (pipe.sourceClosed) {
                    if (pipe.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
            }
        }

        public Timeout timeout() {
            return this.j;
        }

        public void write(Buffer buffer, long j2) {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (j2 > 0) {
                        Pipe pipe = Pipe.this;
                        if (!pipe.sourceClosed) {
                            long size = pipe.maxBufferSize - pipe.buffer.size();
                            if (size == 0) {
                                this.j.waitUntilNotified(Pipe.this.buffer);
                            } else {
                                long min = Math.min(size, j2);
                                Pipe.this.buffer.write(buffer, min);
                                j2 -= min;
                                Pipe.this.buffer.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }
    }

    final class b implements Source {
        final Timeout j = new Timeout();

        b() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        public long read(Buffer buffer, long j2) {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size() == 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.sinkClosed) {
                            return -1;
                        }
                        this.j.waitUntilNotified(pipe.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j2);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public Timeout timeout() {
            return this.j;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
