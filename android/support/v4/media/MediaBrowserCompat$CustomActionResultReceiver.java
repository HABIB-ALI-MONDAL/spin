package android.support.v4.media;

import a.a.a.a.b;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

class MediaBrowserCompat$CustomActionResultReceiver extends b {
    private final String l;
    private final Bundle m;
    private final a n;

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
        if (this.n != null) {
            MediaSessionCompat.a(bundle);
            if (i == -1) {
                this.n.a(this.l, this.m, bundle);
            } else if (i == 0) {
                this.n.c(this.l, this.m, bundle);
            } else if (i != 1) {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.m + ", resultData=" + bundle + ")");
            } else {
                this.n.b(this.l, this.m, bundle);
            }
        }
    }
}
