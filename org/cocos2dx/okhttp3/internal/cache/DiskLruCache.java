package org.cocos2dx.okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.io.FileSystem;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new a();
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, d> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final d entry;
        final boolean[] written;

        class a extends a {
            a(Sink sink) {
                super(sink);
            }

            /* access modifiers changed from: protected */
            public void c(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    Editor.this.detach();
                }
            }
        }

        Editor(d dVar) {
            this.entry = dVar;
            this.written = dVar.f3189e ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public void abort() {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.f3190f == this) {
                        DiskLruCache.this.completeEdit(this, false);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abortUnlessCommitted() {
            /*
                r3 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0015 }
                if (r1 != 0) goto L_0x0013
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r1 = r3.entry     // Catch:{ all -> 0x0015 }
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.f3190f     // Catch:{ all -> 0x0015 }
                if (r1 != r3) goto L_0x0013
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0013 }
                r2 = 0
                r1.completeEdit(r3, r2)     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }

        public void commit() {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.f3190f == this) {
                        DiskLruCache.this.completeEdit(this, true);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            if (this.entry.f3190f == this) {
                int i = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i < diskLruCache.valueCount) {
                        try {
                            diskLruCache.fileSystem.delete(this.entry.f3188d[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.entry.f3190f = null;
                        return;
                    }
                }
            }
        }

        public Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    d dVar = this.entry;
                    if (dVar.f3190f != this) {
                        Sink blackhole = Okio.blackhole();
                        return blackhole;
                    }
                    if (!dVar.f3189e) {
                        this.written[i] = true;
                    }
                    try {
                        a aVar = new a(DiskLruCache.this.fileSystem.sink(dVar.f3188d[i]));
                        return aVar;
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.cocos2dx.okio.Source newSource(int r5) {
            /*
                r4 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x002b }
                if (r1 != 0) goto L_0x0025
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r1 = r4.entry     // Catch:{ all -> 0x002b }
                boolean r2 = r1.f3189e     // Catch:{ all -> 0x002b }
                r3 = 0
                if (r2 == 0) goto L_0x0023
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r2 = r1.f3190f     // Catch:{ all -> 0x002b }
                if (r2 == r4) goto L_0x0013
                goto L_0x0023
            L_0x0013:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r2 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0021 }
                org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r2.fileSystem     // Catch:{ FileNotFoundException -> 0x0021 }
                java.io.File[] r1 = r1.f3187c     // Catch:{ FileNotFoundException -> 0x0021 }
                r5 = r1[r5]     // Catch:{ FileNotFoundException -> 0x0021 }
                org.cocos2dx.okio.Source r5 = r2.source(r5)     // Catch:{ FileNotFoundException -> 0x0021 }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r5
            L_0x0021:
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r3
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r3
            L_0x0025:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002b }
                r5.<init>()     // Catch:{ all -> 0x002b }
                throw r5     // Catch:{ all -> 0x002b }
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):org.cocos2dx.okio.Source");
        }
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        @Nullable
        public Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public String key() {
            return this.key;
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r1 = r6.j;
            r1.mostRecentRebuildFailed = true;
            r1.journalWriter = org.cocos2dx.okio.Okio.buffer(org.cocos2dx.okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                boolean r2 = r1.initialized     // Catch:{ all -> 0x003f }
                r3 = 0
                r4 = 1
                if (r2 != 0) goto L_0x000d
                r2 = 1
                goto L_0x000e
            L_0x000d:
                r2 = 0
            L_0x000e:
                boolean r5 = r1.closed     // Catch:{ all -> 0x003f }
                r2 = r2 | r5
                if (r2 == 0) goto L_0x0015
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return
            L_0x0015:
                r1.trimToSize()     // Catch:{ IOException -> 0x0019 }
                goto L_0x001d
            L_0x0019:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                r1.mostRecentTrimFailed = r4     // Catch:{ all -> 0x003f }
            L_0x001d:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x003d
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                r1.rebuildJournal()     // Catch:{ IOException -> 0x002f }
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                r1.redundantOpCount = r3     // Catch:{ IOException -> 0x002f }
                goto L_0x003d
            L_0x002f:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                r1.mostRecentRebuildFailed = r4     // Catch:{ all -> 0x003f }
                org.cocos2dx.okio.Sink r2 = org.cocos2dx.okio.Okio.blackhole()     // Catch:{ all -> 0x003f }
                org.cocos2dx.okio.BufferedSink r2 = org.cocos2dx.okio.Okio.buffer((org.cocos2dx.okio.Sink) r2)     // Catch:{ all -> 0x003f }
                r1.journalWriter = r2     // Catch:{ all -> 0x003f }
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return
            L_0x003f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.a.run():void");
        }
    }

    class b extends a {
        static {
            Class<DiskLruCache> cls = DiskLruCache.class;
        }

        b(Sink sink) {
            super(sink);
        }

        /* access modifiers changed from: protected */
        public void c(IOException iOException) {
            DiskLruCache.this.hasJournalErrors = true;
        }
    }

    class c implements Iterator<Snapshot> {
        final Iterator<d> j;
        Snapshot k;
        Snapshot l;

        c() {
            this.j = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        }

        /* renamed from: b */
        public Snapshot next() {
            if (hasNext()) {
                Snapshot snapshot = this.k;
                this.l = snapshot;
                this.k = null;
                return snapshot;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.k != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.closed) {
                    return false;
                }
                while (this.j.hasNext()) {
                    d next = this.j.next();
                    if (next.f3189e) {
                        Snapshot c2 = next.c();
                        if (c2 != null) {
                            this.k = c2;
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        public void remove() {
            Snapshot snapshot = this.l;
            if (snapshot != null) {
                try {
                    DiskLruCache.this.remove(snapshot.key);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.l = null;
                    throw th;
                }
                this.l = null;
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private final class d {

        /* renamed from: a  reason: collision with root package name */
        final String f3185a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f3186b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f3187c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f3188d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3189e;

        /* renamed from: f  reason: collision with root package name */
        Editor f3190f;
        long g;

        d(String str) {
            this.f3185a = str;
            int i = DiskLruCache.this.valueCount;
            this.f3186b = new long[i];
            this.f3187c = new File[i];
            this.f3188d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.valueCount; i2++) {
                sb.append(i2);
                this.f3187c[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.f3188d[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f3186b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        public Snapshot c() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.f3186b.clone();
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i2 >= diskLruCache.valueCount) {
                            return new Snapshot(this.f3185a, this.g, sourceArr, jArr);
                        }
                        sourceArr[i2] = diskLruCache.fileSystem.source(this.f3187c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i >= diskLruCache2.valueCount || sourceArr[i] == null) {
                                try {
                                    diskLruCache2.removeEntry(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                Util.closeQuietly((Closeable) sourceArr[i]);
                                i++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.f3186b) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    static {
        Class<DiskLruCache> cls = DiskLruCache.class;
    }

    DiskLruCache(FileSystem fileSystem2, File file, int i, int i2, long j, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor2;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new DiskLruCache(fileSystem2, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private BufferedSink newJournalWriter() {
        return Okio.buffer((Sink) new b(this.fileSystem.appendingSink(this.journalFile)));
    }

    private void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<d> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f3190f == null) {
                while (i < this.valueCount) {
                    this.size += next.f3186b[i];
                    i++;
                }
            } else {
                next.f3190f = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.f3187c[i]);
                    this.fileSystem.delete(next.f3188d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.exhausted() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readJournal() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            org.cocos2dx.okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            org.cocos2dx.okio.Source r1 = r1.source(r2)
            org.cocos2dx.okio.BufferedSource r1 = org.cocos2dx.okio.Okio.buffer((org.cocos2dx.okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.appVersion     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.valueCount     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005d }
            r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r2 = r9.lruEntries     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.rebuildJournal()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            org.cocos2dx.okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x00a8 }
            r9.journalWriter = r0     // Catch:{ all -> 0x00a8 }
        L_0x0076:
            org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r7.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00a8 }
            r7.append(r2)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r3)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r5)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
            throw r4     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            goto L_0x00ae
        L_0x00ad:
            throw r0
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            d dVar = this.lruEntries.get(str2);
            if (dVar == null) {
                dVar = new d(str2);
                this.lruEntries.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f3189e = true;
                dVar.f3190f = null;
                dVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                dVar.f3190f = new Editor(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(READ)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized void close() {
        if (this.initialized) {
            if (!this.closed) {
                for (d dVar : (d[]) this.lruEntries.values().toArray(new d[this.lruEntries.size()])) {
                    Editor editor = dVar.f3190f;
                    if (editor != null) {
                        editor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = r10.entry     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.f3190f     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.f3189e     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.valueCount     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.written     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            org.cocos2dx.okhttp3.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x00fb }
            java.io.File[] r4 = r0.f3188d     // Catch:{ all -> 0x00fb }
            r4 = r4[r2]     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x002a
            r10.abort()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.abort()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0047:
            int r10 = r9.valueCount     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.f3188d     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.f3187c     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okhttp3.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x00fb }
            r3.rename(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f3186b     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okhttp3.internal.io.FileSystem r10 = r9.fileSystem     // Catch:{ all -> 0x00fb }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f3186b     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.size     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.size = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x00fb }
            r2.delete(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.redundantOpCount     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.redundantOpCount = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.f3190f = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.f3189e     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.f3189e = r1     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            org.cocos2dx.okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.f3185a     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            r0.d(r10)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.nextSequenceNumber     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.nextSequenceNumber = r1     // Catch:{ all -> 0x00fb }
            r0.g = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r10 = r9.lruEntries     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f3185a     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            org.cocos2dx.okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f3185a     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.size     // Catch:{ all -> 0x00fb }
            long r0 = r9.maxSize     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.executor     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.cleanupRunnable     // Catch:{ all -> 0x00fb }
            r10.execute(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00ff
        L_0x00fe:
            throw r10
        L_0x00ff:
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.completeEdit(org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @Nullable
    public Editor edit(String str) {
        return edit(str, ANY_SEQUENCE_NUMBER);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0074 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0074 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r5.lruEntries     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r1 = r0.g     // Catch:{ all -> 0x0074 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r5)
            return r3
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r7 = r0.f3190f     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r3
        L_0x002b:
            boolean r7 = r5.mostRecentTrimFailed     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.mostRecentRebuildFailed     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            org.cocos2dx.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            org.cocos2dx.okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            org.cocos2dx.okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            org.cocos2dx.okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            org.cocos2dx.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.hasJournalErrors     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = new org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r7 = r5.lruEntries     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r6 = new org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.f3190f = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.executor     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.cleanupRunnable     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r3
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public synchronized void evictAll() {
        initialize();
        for (d removeEntry : (d[]) this.lruEntries.values().toArray(new d[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
        this.mostRecentTrimFailed = false;
    }

    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x0050 }
            r3.checkNotClosed()     // Catch:{ all -> 0x0050 }
            r3.validateKey(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r3.lruEntries     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.f3189e     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.c()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.redundantOpCount     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.redundantOpCount = r1     // Catch:{ all -> 0x0050 }
            org.cocos2dx.okio.BufferedSink r1 = r3.journalWriter     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            org.cocos2dx.okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            org.cocos2dx.okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0050 }
            org.cocos2dx.okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.journalRebuildRequired()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.executor     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.cleanupRunnable     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.get(java.lang.String):org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() {
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e2) {
                    Platform platform = Platform.get();
                    platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing", e2);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    /* access modifiers changed from: package-private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public synchronized void rebuildJournal() {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try {
            buffer.writeUtf8(MAGIC).writeByte(10);
            buffer.writeUtf8(VERSION_1).writeByte(10);
            buffer.writeDecimalLong((long) this.appVersion).writeByte(10);
            buffer.writeDecimalLong((long) this.valueCount).writeByte(10);
            buffer.writeByte(10);
            for (d next : this.lruEntries.values()) {
                if (next.f3190f != null) {
                    buffer.writeUtf8(DIRTY).writeByte(32);
                    buffer.writeUtf8(next.f3185a);
                } else {
                    buffer.writeUtf8(CLEAN).writeByte(32);
                    buffer.writeUtf8(next.f3185a);
                    next.d(buffer);
                }
                buffer.writeByte(10);
            }
            buffer.close();
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.initialize()     // Catch:{ all -> 0x0029 }
            r6.checkNotClosed()     // Catch:{ all -> 0x0029 }
            r6.validateKey(r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r6.lruEntries     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r7 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.removeEntry(r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.size     // Catch:{ all -> 0x0029 }
            long r3 = r6.maxSize     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean removeEntry(d dVar) {
        Editor editor = dVar.f3190f;
        if (editor != null) {
            editor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(dVar.f3187c[i]);
            long j = this.size;
            long[] jArr = dVar.f3186b;
            this.size = j - jArr[i];
            jArr[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(dVar.f3185a).writeByte(10);
        this.lruEntries.remove(dVar.f3185a);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() {
        initialize();
        return this.size;
    }

    public synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }
}
