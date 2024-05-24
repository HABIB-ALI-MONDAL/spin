package android.support.v4.media;

import a.a.a.a.b;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

class MediaBrowserCompat$ItemReceiver extends b {
    private final String l;
    private final b m;

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.m.a(this.l);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.m.b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.m.a(this.l);
        }
    }
}
