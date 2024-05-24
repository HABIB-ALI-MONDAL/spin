package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f434a;

    /* renamed from: b  reason: collision with root package name */
    int f435b = -1;

    b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f434a.equals(((b) obj).f434a);
    }

    public int hashCode() {
        return this.f434a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f434a;
    }
}
