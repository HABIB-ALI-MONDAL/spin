package f.a.a.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class a {
    private a() {
    }

    private int b(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static a c() {
        return new a();
    }

    private Bitmap d(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public void a(Context context, Uri uri) {
        Bitmap decodeFile;
        Bitmap d2;
        String g = f.g(context, uri);
        int b2 = b(g);
        if (b2 != 0 && (decodeFile = BitmapFactory.decodeFile(g)) != null && (d2 = d(decodeFile, b2)) != null) {
            try {
                d2.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(g)));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
        }
    }
}
