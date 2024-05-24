package f.a.a.f;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import f.a.a.d.a;
import f.a.a.d.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3120a = "f.a.a.f.b";

    public static Intent a(Uri uri) {
        Intent intent = new Intent();
        intent.addFlags(1);
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        return intent;
    }

    public static Intent b(Uri uri, Uri uri2, a aVar) {
        boolean g = g.g();
        String str = f3120a;
        StringBuilder sb = new StringBuilder();
        sb.append("getCaptureIntentWithCrop:isReturnData:");
        sb.append(g ? "true" : "false");
        Log.w(str, sb.toString());
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(1);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        if (aVar.a() * aVar.b() > 0) {
            intent.putExtra("aspectX", aVar.a());
            intent.putExtra("aspectY", aVar.b());
        }
        if (aVar.c() * aVar.d() > 0) {
            intent.putExtra("outputX", aVar.c());
            intent.putExtra("outputY", aVar.d());
        }
        intent.putExtra("scale", true);
        intent.putExtra("output", uri2);
        intent.putExtra("return-data", g);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        return intent;
    }

    public static Intent c() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        return intent;
    }

    public static Intent d() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        return intent;
    }

    public static Intent e(e eVar, int i) {
        Intent intent = new Intent(eVar.a(), AlbumSelectActivity.class);
        if (i <= 0) {
            i = 1;
        }
        intent.putExtra("limit", i);
        return intent;
    }
}
