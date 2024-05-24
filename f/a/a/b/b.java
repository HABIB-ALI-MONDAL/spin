package f.a.a.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import f.a.a.b.a;
import f.a.a.d.e;
import f.a.a.d.j;
import f.a.a.e.b;
import f.a.a.e.c;

public class b extends Activity implements a.C0080a, f.a.a.e.a {
    private static final String TAG = b.class.getName();
    private f.a.a.d.b invokeParam;
    private a takePhoto;

    public a getTakePhoto() {
        if (this.takePhoto == null) {
            this.takePhoto = (a) c.b(this).a(new c(this, this));
        }
        return this.takePhoto;
    }

    public b.c invoke(f.a.a.d.b bVar) {
        b.c a2 = f.a.a.e.b.a(e.c(this), bVar.b());
        if (b.c.WAIT.equals(a2)) {
            this.invokeParam = bVar;
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        getTakePhoto().onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getTakePhoto().h(bundle);
        super.onCreate(bundle);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        f.a.a.e.b.b(this, f.a.a.e.b.c(i, strArr, iArr), this.invokeParam, this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        getTakePhoto().onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void takeCancel() {
        Log.i(TAG, getResources().getString(f.a.a.a.msg_operation_canceled));
    }

    public void takeFail(j jVar, String str) {
        String str2 = TAG;
        Log.i(str2, "takeFail:" + str);
    }

    public void takeSuccess(j jVar) {
        String str = TAG;
        Log.i(str, "takeSuccess：" + jVar.a().a());
    }
}
