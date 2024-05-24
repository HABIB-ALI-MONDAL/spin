package android.support.v4.media;

import a.a.a.a.b;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

class MediaBrowserCompat$SearchResultReceiver extends b {
    private final String l;
    private final Bundle m;
    private final c n;

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.n.a(this.l, this.m);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        ArrayList arrayList = null;
        if (parcelableArray != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
            }
        }
        this.n.b(this.l, this.m, arrayList);
    }
}
