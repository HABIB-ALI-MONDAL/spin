package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class c implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    final Object f13a;

    /* renamed from: b  reason: collision with root package name */
    a f14b;

    /* renamed from: c  reason: collision with root package name */
    a f15c;

    private class a extends Handler {
    }

    private static class b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f16a;

        b(c cVar) {
            this.f16a = new WeakReference<>(cVar);
        }

        public void a(List<?> list) {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.b(list));
            }
        }

        public void b(Object obj) {
            c cVar = (c) this.f16a.get();
            if (cVar != null && cVar.f15c == null) {
                cVar.d(PlaybackStateCompat.a(obj));
            }
        }

        public void c(Object obj) {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.a(obj));
            }
        }

        public void d(int i, int i2, int i3, int i4, int i5) {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.a(new d(i, i2, i3, i4, i5));
            }
        }

        public void e(CharSequence charSequence) {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        public void f() {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.g();
            }
        }

        public void g(String str, Bundle bundle) {
            c cVar = (c) this.f16a.get();
            if (cVar == null) {
                return;
            }
            if (cVar.f15c == null || Build.VERSION.SDK_INT >= 23) {
                cVar.h(str, bundle);
            }
        }

        public void j(Bundle bundle) {
            c cVar = (c) this.f16a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    private static class C0005c extends a.C0003a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f17a;

        C0005c(c cVar) {
            this.f17a = new WeakReference<>(cVar);
        }

        public void B(int i) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i), (Bundle) null);
            }
        }

        public void I(boolean z) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z), (Bundle) null);
            }
        }

        public void Q(int i) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i), (Bundle) null);
            }
        }

        public void S() {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(13, (Object) null, (Bundle) null);
            }
        }

        public void T(PlaybackStateCompat playbackStateCompat) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, (Bundle) null);
            }
        }

        public void U(String str, Bundle bundle) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        public void Z(ParcelableVolumeInfo parcelableVolumeInfo) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.j, parcelableVolumeInfo.k, parcelableVolumeInfo.l, parcelableVolumeInfo.m, parcelableVolumeInfo.n) : null, (Bundle) null);
            }
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(5, list, (Bundle) null);
            }
        }

        public void e(CharSequence charSequence) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(6, charSequence, (Bundle) null);
            }
        }

        public void f() {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(8, (Object) null, (Bundle) null);
            }
        }

        public void j(Bundle bundle) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(7, bundle, (Bundle) null);
            }
        }

        public void l(boolean z) {
        }

        public void w(MediaMetadataCompat mediaMetadataCompat) {
            c cVar = (c) this.f17a.get();
            if (cVar != null) {
                cVar.i(3, mediaMetadataCompat, (Bundle) null);
            }
        }
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f13a = e.a(new b(this));
        } else {
            this.f15c = new C0005c(this);
        }
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    public void binderDied() {
        i(8, (Object) null, (Bundle) null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void i(int i, Object obj, Bundle bundle) {
        a aVar = this.f14b;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }
}
