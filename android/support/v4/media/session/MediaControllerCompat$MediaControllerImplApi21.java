package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import androidx.core.app.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a  reason: collision with root package name */
    final Object f8a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f9b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<c, a> f10c;

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionCompat.Token f11d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> j;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = (MediaControllerCompat$MediaControllerImplApi21) this.j.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.f8a) {
                    mediaControllerCompat$MediaControllerImplApi21.f11d.b(b.a.h(c.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerCompat$MediaControllerImplApi21.f11d.c(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerCompat$MediaControllerImplApi21.a();
                }
            }
        }
    }

    private static class a extends c.C0005c {
        a(c cVar) {
            super(cVar);
        }

        public void Z(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        public void e(CharSequence charSequence) {
            throw new AssertionError();
        }

        public void f() {
            throw new AssertionError();
        }

        public void j(Bundle bundle) {
            throw new AssertionError();
        }

        public void w(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f11d.a() != null) {
            for (c next : this.f9b) {
                a aVar = new a(next);
                this.f10c.put(next, aVar);
                next.f15c = aVar;
                try {
                    this.f11d.a().r(aVar);
                    next.i(13, (Object) null, (Bundle) null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f9b.clear();
        }
    }
}
