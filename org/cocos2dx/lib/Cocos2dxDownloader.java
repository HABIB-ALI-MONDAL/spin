package org.cocos2dx.lib;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Call;
import org.cocos2dx.okhttp3.Callback;
import org.cocos2dx.okhttp3.OkHttpClient;

public class Cocos2dxDownloader {
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, Boolean> _resumingSupport = new ConcurrentHashMap<>();
    private int _countOfMaxProcessingTasks;
    /* access modifiers changed from: private */
    public OkHttpClient _httpClient = null;
    /* access modifiers changed from: private */
    public int _id;
    private int _runningTaskCount = 0;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, Call> _taskMap = new ConcurrentHashMap<>();
    private Queue<Runnable> _taskQueue = new LinkedList();
    /* access modifiers changed from: private */
    public String _tempFileNameSuffix;

    class a implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ long k;
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        a(int i, long j2, long j3, long j4) {
            this.j = i;
            this.k = j2;
            this.l = j3;
            this.m = j4;
        }

        public void run() {
            Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
            cocos2dxDownloader.nativeOnProgress(cocos2dxDownloader._id, this.j, this.k, this.l, this.m);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ String l;
        final /* synthetic */ byte[] m;

        b(int i, int i2, String str, byte[] bArr) {
            this.j = i;
            this.k = i2;
            this.l = str;
            this.m = bArr;
        }

        public void run() {
            Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
            cocos2dxDownloader.nativeOnFinish(cocos2dxDownloader._id, this.j, this.k, this.l, this.m);
        }
    }

    class c implements Runnable {
        String j = null;
        String k = null;
        File l = null;
        File m = null;
        long n = 0;
        final /* synthetic */ String o;
        final /* synthetic */ String p;
        final /* synthetic */ Cocos2dxDownloader q;
        final /* synthetic */ String[] r;
        final /* synthetic */ int s;

        class a implements Callback {
            a() {
            }

            public void onFailure(Call call, IOException iOException) {
                c cVar = c.this;
                cVar.q.onFinish(cVar.s, 0, iOException.toString(), (byte[]) null);
            }

            /* JADX WARNING: type inference failed for: r5v0 */
            /* JADX WARNING: type inference failed for: r5v1, types: [java.io.InputStream] */
            /* JADX WARNING: type inference failed for: r5v2 */
            /* JADX WARNING: type inference failed for: r5v3 */
            /* JADX WARNING: type inference failed for: r5v4, types: [java.io.FileOutputStream] */
            /* JADX WARNING: type inference failed for: r5v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0101 A[Catch:{ IOException -> 0x0120, all -> 0x011e }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0112 A[Catch:{ IOException -> 0x0120, all -> 0x011e }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01b2 A[SYNTHETIC, Splitter:B:83:0x01b2] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01ba A[Catch:{ IOException -> 0x01b6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x01cd A[SYNTHETIC, Splitter:B:93:0x01cd] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x01d5 A[Catch:{ IOException -> 0x01d1 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(org.cocos2dx.okhttp3.Call r21, org.cocos2dx.okhttp3.Response r22) {
                /*
                    r20 = this;
                    r1 = r20
                    java.lang.String r2 = "Cocos2dxDownloader"
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r3 = new byte[r0]
                    r4 = 0
                    r5 = 0
                    int r6 = r22.code()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    r7 = 200(0xc8, float:2.8E-43)
                    if (r6 < r7) goto L_0x0189
                    int r6 = r22.code()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    r7 = 206(0xce, float:2.89E-43)
                    if (r6 <= r7) goto L_0x001c
                    goto L_0x0189
                L_0x001c:
                    org.cocos2dx.okhttp3.ResponseBody r6 = r22.body()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    long r13 = r6.contentLength()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r6 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.String r6 = r6.o     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    int r6 = r6.length()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    r7 = 0
                    if (r6 <= 0) goto L_0x005b
                    java.util.concurrent.ConcurrentHashMap r6 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r9 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.String r9 = r9.k     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    boolean r6 = r6.containsKey(r9)     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    if (r6 != 0) goto L_0x005b
                    int r6 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                    if (r6 <= 0) goto L_0x0050
                    java.util.concurrent.ConcurrentHashMap r6 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r9 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.String r9 = r9.k     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                L_0x004c:
                    r6.put(r9, r10)     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    goto L_0x005b
                L_0x0050:
                    java.util.concurrent.ConcurrentHashMap r6 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r9 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.String r9 = r9.k     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    goto L_0x004c
                L_0x005b:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r6 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    long r9 = r6.n     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.okhttp3.ResponseBody r6 = r22.body()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    java.io.InputStream r6 = r6.byteStream()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r11 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    java.lang.String r11 = r11.o     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    int r11 = r11.length()     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r15 = -1
                    if (r11 <= 0) goto L_0x012f
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    long r11 = r0.n     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0085
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r7 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    java.io.File r7 = r7.l     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r8 = 1
                    r0.<init>(r7, r8)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    goto L_0x008e
                L_0x0085:
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r7 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    java.io.File r7 = r7.l     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r0.<init>(r7, r4)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                L_0x008e:
                    r11 = r0
                L_0x008f:
                    int r0 = r6.read(r3)     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    if (r0 == r15) goto L_0x00b7
                    long r7 = (long) r0     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    long r16 = r9 + r7
                    r11.write(r3, r4, r0)     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    org.cocos2dx.lib.Cocos2dxDownloader r9 = r0.q     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    int r0 = r0.s     // Catch:{ IOException -> 0x012a, all -> 0x0125 }
                    r18 = r7
                    r7 = r9
                    r8 = r0
                    r9 = r18
                    r18 = r11
                    r11 = r16
                    r21 = r13
                    r7.onProgress(r8, r9, r11, r13)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r13 = r21
                    r9 = r16
                    r11 = r18
                    goto L_0x008f
                L_0x00b7:
                    r18 = r11
                    r18.flush()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r0 = r0.m     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    boolean r0 = r0.exists()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    if (r0 == 0) goto L_0x00f5
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r0 = r0.m     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    boolean r0 = r0.isDirectory()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    if (r0 == 0) goto L_0x00d1
                    goto L_0x00fe
                L_0x00d1:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r0 = r0.m     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    boolean r0 = r0.delete()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    if (r0 != 0) goto L_0x00f5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r0.<init>()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.lang.String r3 = "Can't remove old file:"
                    r0.append(r3)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r3 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r3 = r3.m     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r0.append(r3)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    goto L_0x00ff
                L_0x00f5:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r3 = r0.l     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    java.io.File r0 = r0.m     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r3.renameTo(r0)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                L_0x00fe:
                    r0 = r5
                L_0x00ff:
                    if (r0 != 0) goto L_0x0112
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader r3 = r0.q     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    int r0 = r0.s     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r3.onFinish(r0, r4, r5, r5)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader r0 = r0.q     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r0.runNextTaskIfExists()     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    goto L_0x011b
                L_0x0112:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r3 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    org.cocos2dx.lib.Cocos2dxDownloader r7 = r3.q     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    int r3 = r3.s     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                    r7.onFinish(r3, r4, r0, r5)     // Catch:{ IOException -> 0x0120, all -> 0x011e }
                L_0x011b:
                    r5 = r18
                    goto L_0x0175
                L_0x011e:
                    r0 = move-exception
                    goto L_0x0128
                L_0x0120:
                    r0 = move-exception
                    r11 = r18
                    goto L_0x01a0
                L_0x0125:
                    r0 = move-exception
                    r18 = r11
                L_0x0128:
                    r3 = r0
                    goto L_0x0184
                L_0x012a:
                    r0 = move-exception
                    r18 = r11
                    goto L_0x01a0
                L_0x012f:
                    int r11 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                    if (r11 <= 0) goto L_0x013a
                    java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    int r7 = (int) r13     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r0.<init>(r7)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    goto L_0x0140
                L_0x013a:
                    java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r7.<init>(r0)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r0 = r7
                L_0x0140:
                    int r7 = r6.read(r3)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    if (r7 == r15) goto L_0x0161
                    long r11 = (long) r7     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    long r16 = r9 + r11
                    r0.write(r3, r4, r7)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r7 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader r8 = r7.q     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    int r9 = r7.s     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r7 = r8
                    r8 = r9
                    r9 = r11
                    r11 = r16
                    r18 = r13
                    r7.onProgress(r8, r9, r11, r13)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r9 = r16
                    r13 = r18
                    goto L_0x0140
                L_0x0161:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r3 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader r7 = r3.q     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    int r3 = r3.s     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    byte[] r0 = r0.toByteArray()     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r7.onFinish(r3, r4, r5, r0)     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    org.cocos2dx.lib.Cocos2dxDownloader r0 = r0.q     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                    r0.runNextTaskIfExists()     // Catch:{ IOException -> 0x0186, all -> 0x0180 }
                L_0x0175:
                    if (r6 == 0) goto L_0x017a
                    r6.close()     // Catch:{ IOException -> 0x01b6 }
                L_0x017a:
                    if (r5 == 0) goto L_0x01c5
                    r5.close()     // Catch:{ IOException -> 0x01b6 }
                    goto L_0x01c5
                L_0x0180:
                    r0 = move-exception
                    r3 = r0
                    r18 = r5
                L_0x0184:
                    r5 = r6
                    goto L_0x01cb
                L_0x0186:
                    r0 = move-exception
                    r11 = r5
                    goto L_0x01a0
                L_0x0189:
                    org.cocos2dx.lib.Cocos2dxDownloader$c r0 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    org.cocos2dx.lib.Cocos2dxDownloader r3 = r0.q     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    int r0 = r0.s     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    r6 = -2
                    java.lang.String r7 = r22.message()     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    r3.onFinish(r0, r6, r7, r5)     // Catch:{ IOException -> 0x019d, all -> 0x0198 }
                    return
                L_0x0198:
                    r0 = move-exception
                    r3 = r0
                    r18 = r5
                    goto L_0x01cb
                L_0x019d:
                    r0 = move-exception
                    r6 = r5
                    r11 = r6
                L_0x01a0:
                    r0.printStackTrace()     // Catch:{ all -> 0x01c6 }
                    org.cocos2dx.lib.Cocos2dxDownloader$c r3 = org.cocos2dx.lib.Cocos2dxDownloader.c.this     // Catch:{ all -> 0x01c6 }
                    org.cocos2dx.lib.Cocos2dxDownloader r7 = r3.q     // Catch:{ all -> 0x01c6 }
                    int r3 = r3.s     // Catch:{ all -> 0x01c6 }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01c6 }
                    r7.onFinish(r3, r4, r0, r5)     // Catch:{ all -> 0x01c6 }
                    if (r6 == 0) goto L_0x01b8
                    r6.close()     // Catch:{ IOException -> 0x01b6 }
                    goto L_0x01b8
                L_0x01b6:
                    r0 = move-exception
                    goto L_0x01be
                L_0x01b8:
                    if (r11 == 0) goto L_0x01c5
                    r11.close()     // Catch:{ IOException -> 0x01b6 }
                    goto L_0x01c5
                L_0x01be:
                    java.lang.String r0 = r0.toString()
                    android.util.Log.e(r2, r0)
                L_0x01c5:
                    return
                L_0x01c6:
                    r0 = move-exception
                    r3 = r0
                    r5 = r6
                    r18 = r11
                L_0x01cb:
                    if (r5 == 0) goto L_0x01d3
                    r5.close()     // Catch:{ IOException -> 0x01d1 }
                    goto L_0x01d3
                L_0x01d1:
                    r0 = move-exception
                    goto L_0x01d9
                L_0x01d3:
                    if (r18 == 0) goto L_0x01e0
                    r18.close()     // Catch:{ IOException -> 0x01d1 }
                    goto L_0x01e0
                L_0x01d9:
                    java.lang.String r0 = r0.toString()
                    android.util.Log.e(r2, r0)
                L_0x01e0:
                    goto L_0x01e2
                L_0x01e1:
                    throw r3
                L_0x01e2:
                    goto L_0x01e1
                */
                throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.lib.Cocos2dxDownloader.c.a.onResponse(org.cocos2dx.okhttp3.Call, org.cocos2dx.okhttp3.Response):void");
            }
        }

        class b implements Runnable {
            final /* synthetic */ String j;

            b(String str) {
                this.j = str;
            }

            public void run() {
                Cocos2dxDownloader cocos2dxDownloader = c.this.q;
                cocos2dxDownloader.nativeOnFinish(cocos2dxDownloader._id, c.this.s, 0, this.j, (byte[]) null);
            }
        }

        c(String str, String str2, Cocos2dxDownloader cocos2dxDownloader, String[] strArr, int i) {
            this.o = str;
            this.p = str2;
            this.q = cocos2dxDownloader;
            this.r = strArr;
            this.s = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0134  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = r7.o
                int r0 = r0.length()
                r1 = 0
                if (r0 <= 0) goto L_0x00bc
                java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00b6, NullPointerException -> 0x00b1 }
                java.lang.String r3 = r7.p     // Catch:{ URISyntaxException -> 0x00b6, NullPointerException -> 0x00b1 }
                r0.<init>(r3)     // Catch:{ URISyntaxException -> 0x00b6, NullPointerException -> 0x00b1 }
                java.lang.String r0 = r0.getHost()     // Catch:{ URISyntaxException -> 0x00b6, NullPointerException -> 0x00b1 }
                r7.j = r0     // Catch:{ URISyntaxException -> 0x00b6, NullPointerException -> 0x00b1 }
                java.io.File r0 = new java.io.File
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = r7.o
                r3.append(r4)
                org.cocos2dx.lib.Cocos2dxDownloader r4 = r7.q
                java.lang.String r4 = r4._tempFileNameSuffix
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r0.<init>(r3)
                r7.l = r0
                boolean r0 = r0.isDirectory()
                if (r0 == 0) goto L_0x003d
                goto L_0x00ba
            L_0x003d:
                java.io.File r0 = r7.l
                java.io.File r0 = r0.getParentFile()
                boolean r3 = r0.isDirectory()
                if (r3 != 0) goto L_0x0050
                boolean r0 = r0.mkdirs()
                if (r0 != 0) goto L_0x0050
                goto L_0x00ba
            L_0x0050:
                java.io.File r0 = new java.io.File
                java.lang.String r3 = r7.o
                r0.<init>(r3)
                r7.m = r0
                boolean r0 = r0.isDirectory()
                if (r0 == 0) goto L_0x0060
                goto L_0x00ba
            L_0x0060:
                java.io.File r0 = r7.l
                long r3 = r0.length()
                java.lang.String r0 = r7.j
                java.lang.String r5 = "www."
                boolean r0 = r0.startsWith(r5)
                if (r0 == 0) goto L_0x0078
                java.lang.String r0 = r7.j
                r5 = 4
                java.lang.String r0 = r0.substring(r5)
                goto L_0x007a
            L_0x0078:
                java.lang.String r0 = r7.j
            L_0x007a:
                r7.k = r0
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x00bc
                java.util.concurrent.ConcurrentHashMap r0 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport
                java.lang.String r5 = r7.k
                boolean r0 = r0.containsKey(r5)
                if (r0 == 0) goto L_0x00a1
                java.util.concurrent.ConcurrentHashMap r0 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport
                java.lang.String r5 = r7.k
                java.lang.Object r0 = r0.get(r5)
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x00a1
                r7.n = r3
                goto L_0x00bc
            L_0x00a1:
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ FileNotFoundException -> 0x00bc }
                java.io.File r3 = r7.l     // Catch:{ FileNotFoundException -> 0x00bc }
                r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00bc }
                java.lang.String r3 = ""
                r0.print(r3)     // Catch:{ FileNotFoundException -> 0x00bc }
                r0.close()     // Catch:{ FileNotFoundException -> 0x00bc }
                goto L_0x00bc
            L_0x00b1:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00ba
            L_0x00b6:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00ba:
                r0 = 0
                goto L_0x0116
            L_0x00bc:
                org.cocos2dx.okhttp3.Request$Builder r0 = new org.cocos2dx.okhttp3.Request$Builder
                r0.<init>()
                java.lang.String r3 = r7.p
                org.cocos2dx.okhttp3.Request$Builder r0 = r0.url((java.lang.String) r3)
                r3 = 0
            L_0x00c8:
                java.lang.String[] r4 = r7.r
                int r5 = r4.length
                int r5 = r5 / 2
                if (r3 >= r5) goto L_0x00dd
                int r5 = r3 * 2
                r6 = r4[r5]
                int r5 = r5 + 1
                r4 = r4[r5]
                r0.addHeader(r6, r4)
                int r3 = r3 + 1
                goto L_0x00c8
            L_0x00dd:
                long r3 = r7.n
                int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x0100
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "bytes="
                r1.append(r2)
                long r2 = r7.n
                r1.append(r2)
                java.lang.String r2 = "-"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "RANGE"
                r0.addHeader(r2, r1)
            L_0x0100:
                org.cocos2dx.okhttp3.Request r0 = r0.build()
                org.cocos2dx.lib.Cocos2dxDownloader r1 = r7.q
                org.cocos2dx.okhttp3.OkHttpClient r1 = r1._httpClient
                org.cocos2dx.okhttp3.Call r0 = r1.newCall(r0)
                org.cocos2dx.lib.Cocos2dxDownloader$c$a r1 = new org.cocos2dx.lib.Cocos2dxDownloader$c$a
                r1.<init>()
                r0.enqueue(r1)
            L_0x0116:
                if (r0 != 0) goto L_0x0134
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Can't create DownloadTask for "
                r0.append(r1)
                java.lang.String r1 = r7.p
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                org.cocos2dx.lib.Cocos2dxDownloader$c$b r1 = new org.cocos2dx.lib.Cocos2dxDownloader$c$b
                r1.<init>(r0)
                org.cocos2dx.lib.Cocos2dxHelper.runOnGLThread(r1)
                goto L_0x0143
            L_0x0134:
                org.cocos2dx.lib.Cocos2dxDownloader r1 = r7.q
                java.util.concurrent.ConcurrentHashMap r1 = r1._taskMap
                int r2 = r7.s
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.put(r2, r0)
            L_0x0143:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.lib.Cocos2dxDownloader.c.run():void");
        }
    }

    class d implements Runnable {
        final /* synthetic */ int k;

        d(int i) {
            this.k = i;
        }

        public void run() {
            for (Map.Entry entry : Cocos2dxDownloader.this._taskMap.entrySet()) {
                Object key = entry.getKey();
                Call call = (Call) entry.getValue();
                if (call != null && Integer.parseInt(key.toString()) == this.k) {
                    call.cancel();
                    Cocos2dxDownloader.this._taskMap.remove(Integer.valueOf(this.k));
                    Cocos2dxDownloader.this.runNextTaskIfExists();
                    return;
                }
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            for (Map.Entry value : Cocos2dxDownloader.this._taskMap.entrySet()) {
                Call call = (Call) value.getValue();
                if (call != null) {
                    call.cancel();
                }
            }
        }
    }

    public static void abort(Cocos2dxDownloader cocos2dxDownloader, int i) {
        Cocos2dxHelper.getActivity().runOnUiThread(new d(i));
    }

    public static void cancelAllRequests(Cocos2dxDownloader cocos2dxDownloader) {
        Cocos2dxHelper.getActivity().runOnUiThread(new e());
    }

    public static Cocos2dxDownloader createDownloader(int i, int i2, String str, int i3) {
        Cocos2dxDownloader cocos2dxDownloader = new Cocos2dxDownloader();
        cocos2dxDownloader._id = i;
        cocos2dxDownloader._httpClient = (i2 > 0 ? new OkHttpClient().newBuilder().followRedirects(true).followSslRedirects(true).callTimeout((long) i2, TimeUnit.SECONDS) : new OkHttpClient().newBuilder().followRedirects(true).followSslRedirects(true)).build();
        cocos2dxDownloader._tempFileNameSuffix = str;
        cocos2dxDownloader._countOfMaxProcessingTasks = i3;
        return cocos2dxDownloader;
    }

    public static void createTask(Cocos2dxDownloader cocos2dxDownloader, int i, String str, String str2, String[] strArr) {
        cocos2dxDownloader.enqueueTask(new c(str2, str, cocos2dxDownloader, strArr, i));
    }

    private void enqueueTask(Runnable runnable) {
        synchronized (this._taskQueue) {
            if (this._runningTaskCount < this._countOfMaxProcessingTasks) {
                Cocos2dxHelper.getActivity().runOnUiThread(runnable);
                this._runningTaskCount++;
            } else {
                this._taskQueue.add(runnable);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onFinish(int i, int i2, String str, byte[] bArr) {
        if (this._taskMap.get(Integer.valueOf(i)) != null) {
            this._taskMap.remove(Integer.valueOf(i));
            this._runningTaskCount--;
            Cocos2dxHelper.runOnGLThread(new b(i, i2, str, bArr));
            runNextTaskIfExists();
        }
    }

    /* access modifiers changed from: private */
    public void onProgress(int i, long j, long j2, long j3) {
        Cocos2dxHelper.runOnGLThread(new a(i, j, j2, j3));
    }

    /* access modifiers changed from: private */
    public void runNextTaskIfExists() {
        synchronized (this._taskQueue) {
            while (this._runningTaskCount < this._countOfMaxProcessingTasks && this._taskQueue.size() > 0) {
                Cocos2dxHelper.getActivity().runOnUiThread(this._taskQueue.poll());
                this._runningTaskCount++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public native void nativeOnFinish(int i, int i2, int i3, String str, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void nativeOnProgress(int i, int i2, long j, long j2, long j3);
}
