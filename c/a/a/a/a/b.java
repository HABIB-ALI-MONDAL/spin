package c.a.a.a.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, a> f805a = new HashMap<>();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final File f806a;

        /* renamed from: b  reason: collision with root package name */
        public long f807b;

        /* renamed from: c  reason: collision with root package name */
        public int f808c;

        /* renamed from: d  reason: collision with root package name */
        public long f809d;

        /* renamed from: e  reason: collision with root package name */
        public long f810e = -1;

        public a(String str, File file, String str2) {
            this.f806a = file;
        }

        public AssetFileDescriptor a() {
            if (this.f808c != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f806a, 268435456), b(), this.f809d);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public long b() {
            return this.f810e;
        }

        public void c(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) {
            long j = this.f807b;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.f810e = j + 30 + ((long) (byteBuffer.getShort(26) & 65535)) + ((long) (byteBuffer.getShort(28) & 65535));
                } else {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public b(String str) {
        new HashMap();
        ByteBuffer.allocate(4);
        a(str);
    }

    private static int c(RandomAccessFile randomAccessFile) {
        return d(randomAccessFile.readInt());
    }

    private static int d(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j = 65557;
            if (65557 > length) {
                j = length;
            }
            randomAccessFile.seek(0);
            int c2 = c(randomAccessFile);
            if (c2 == 101010256) {
                Log.i("zipro", "Found Zip archive, but it looks empty");
                throw new IOException();
            } else if (c2 == 67324752) {
                randomAccessFile.seek(length - j);
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                }
                if (length2 < 0) {
                    Log.d("zipro", "Zip: EOCD not found, " + str2 + " is not zip");
                }
                short s = allocate.getShort(length2 + 8);
                long j2 = ((long) allocate.getInt(length2 + 12)) & 4294967295L;
                long j3 = ((long) allocate.getInt(length2 + 16)) & 4294967295L;
                if (j3 + j2 > length) {
                    Log.w("zipro", "bad offsets (dir " + j3 + ", size " + j2 + ", eocd " + length2 + ")");
                    throw new IOException();
                } else if (s != 0) {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j3, j2);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    short s2 = 65535;
                    byte[] bArr = new byte[65535];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(byteOrder);
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < s) {
                        if (map.getInt(i3) == 33639248) {
                            short s3 = map.getShort(i3 + 28) & s2;
                            short s4 = map.getShort(i3 + 30) & s2;
                            short s5 = map.getShort(i3 + 32) & s2;
                            map.position(i3 + 46);
                            map.get(bArr, i, s3);
                            map.position(i);
                            String str3 = new String(bArr, i, s3);
                            a aVar = new a(str2, file, str3);
                            aVar.f808c = map.getShort(i3 + 10) & 65535;
                            map.getInt(i3 + 12);
                            map.getLong(i3 + 16);
                            map.getLong(i3 + 20);
                            aVar.f809d = map.getLong(i3 + 24) & 4294967295L;
                            aVar.f807b = ((long) map.getInt(i3 + 42)) & 4294967295L;
                            allocate2.clear();
                            aVar.c(randomAccessFile, allocate2);
                            this.f805a.put(str3, aVar);
                            i3 += s3 + 46 + s4 + s5;
                            i2++;
                            str2 = str;
                            file = file;
                            i = 0;
                            s2 = 65535;
                        } else {
                            Log.w("zipro", "Missed a central dir sig (at " + i3 + ")");
                            throw new IOException();
                        }
                    }
                } else {
                    Log.w("zipro", "empty archive?");
                    throw new IOException();
                }
            } else {
                Log.v("zipro", "Not a Zip archive");
                throw new IOException();
            }
        } else {
            throw new IOException();
        }
    }

    public AssetFileDescriptor b(String str) {
        a aVar = this.f805a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }
}
