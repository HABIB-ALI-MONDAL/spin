package org.cocos2dx.lib;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

class Cocos2dxAudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    private static AudioManager.OnAudioFocusChangeListener f3142a = new a();

    class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: org.cocos2dx.lib.Cocos2dxAudioFocusManager$a$a  reason: collision with other inner class name */
        class C0085a implements Runnable {
            C0085a(a aVar) {
            }

            public void run() {
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(1);
            }
        }

        class b implements Runnable {
            b(a aVar) {
            }

            public void run() {
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(2);
            }
        }

        class c implements Runnable {
            c(a aVar) {
            }

            public void run() {
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(3);
            }
        }

        class d implements Runnable {
            d(a aVar) {
            }

            public void run() {
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
            }
        }

        a() {
        }

        public void onAudioFocusChange(int i) {
            Runnable dVar;
            Log.d("AudioFocusManager", "onAudioFocusChange: " + i + ", thread: " + Thread.currentThread().getName());
            if (i == -1) {
                Log.d("AudioFocusManager", "Pause music by AUDIOFOCUS_LOSS");
                dVar = new C0085a(this);
            } else if (i == -2) {
                Log.d("AudioFocusManager", "Pause music by AUDIOFOCUS_LOSS_TRANSILENT");
                dVar = new b(this);
            } else if (i == -3) {
                Log.d("AudioFocusManager", "Lower the volume, keep playing by AUDIOFOCUS_LOSS_TRANSILENT_CAN_DUCK");
                dVar = new c(this);
            } else if (i == 1) {
                Log.d("AudioFocusManager", "Resume music by AUDIOFOCUS_GAIN");
                dVar = new d(this);
            } else {
                return;
            }
            Cocos2dxHelper.runOnGLThread(dVar);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
        }
    }

    static boolean b(Context context) {
        if (((AudioManager) context.getSystemService("audio")).requestAudioFocus(f3142a, 3, 1) == 1) {
            Log.d("AudioFocusManager", "requestAudioFocus succeed");
            return true;
        }
        Log.e("AudioFocusManager", "requestAudioFocus failed!");
        return false;
    }

    static void c(Context context) {
        if (((AudioManager) context.getSystemService("audio")).abandonAudioFocus(f3142a) == 1) {
            Log.d("AudioFocusManager", "abandonAudioFocus succeed!");
        } else {
            Log.e("AudioFocusManager", "abandonAudioFocus failed!");
        }
        Cocos2dxHelper.runOnGLThread(new b());
    }

    /* access modifiers changed from: private */
    public static native void nativeOnAudioFocusChange(int i);
}
