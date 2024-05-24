package org.cocos2dx.lib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;

public class Cocos2dxAccelerometer implements SensorEventListener {
    private static final String TAG = Cocos2dxAccelerometer.class.getSimpleName();
    private final Sensor mAcceleration;
    private final Sensor mAccelerationIncludingGravity;
    private final Context mContext;
    private b mDeviceMotionEvent = new b();
    private final Sensor mGyroscope;
    private int mSamplingPeriodUs = 1;
    private final SensorManager mSensorManager;

    class a {

        /* renamed from: a  reason: collision with root package name */
        public float f3129a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f3130b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f3131c = 0.0f;

        a(Cocos2dxAccelerometer cocos2dxAccelerometer) {
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        public a f3132a;

        /* renamed from: b  reason: collision with root package name */
        public a f3133b;

        /* renamed from: c  reason: collision with root package name */
        public c f3134c;

        b() {
            this.f3132a = new a(Cocos2dxAccelerometer.this);
            this.f3133b = new a(Cocos2dxAccelerometer.this);
            this.f3134c = new c(Cocos2dxAccelerometer.this);
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        public float f3136a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f3137b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f3138c = 0.0f;

        c(Cocos2dxAccelerometer cocos2dxAccelerometer) {
        }
    }

    public Cocos2dxAccelerometer(Context context) {
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mAcceleration = sensorManager.getDefaultSensor(1);
        this.mAccelerationIncludingGravity = sensorManager.getDefaultSensor(10);
        this.mGyroscope = sensorManager.getDefaultSensor(4);
    }

    public static native void onSensorChanged(float f2, float f3, float f4, long j);

    public void disable() {
        this.mSensorManager.unregisterListener(this);
    }

    public void enable() {
        this.mSensorManager.registerListener(this, this.mAcceleration, this.mSamplingPeriodUs);
        this.mSensorManager.registerListener(this, this.mAccelerationIncludingGravity, this.mSamplingPeriodUs);
        this.mSensorManager.registerListener(this, this.mGyroscope, this.mSamplingPeriodUs);
    }

    public b getDeviceMotionEvent() {
        return this.mDeviceMotionEvent;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        a aVar;
        float f2;
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            aVar = this.mDeviceMotionEvent.f3133b;
            float[] fArr = sensorEvent.values;
            aVar.f3129a = fArr[0];
            aVar.f3130b = fArr[1];
            f2 = fArr[2];
        } else if (type == 10) {
            aVar = this.mDeviceMotionEvent.f3132a;
            float[] fArr2 = sensorEvent.values;
            aVar.f3129a = fArr2[0];
            aVar.f3130b = fArr2[1];
            f2 = fArr2[2];
        } else if (type == 4) {
            this.mDeviceMotionEvent.f3134c.f3136a = (float) Math.toDegrees((double) sensorEvent.values[0]);
            this.mDeviceMotionEvent.f3134c.f3137b = (float) Math.toDegrees((double) sensorEvent.values[1]);
            this.mDeviceMotionEvent.f3134c.f3138c = (float) Math.toDegrees((double) sensorEvent.values[2]);
            return;
        } else {
            return;
        }
        aVar.f3131c = f2;
    }

    public void setInterval(float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSamplingPeriodUs = (int) (f2 * 1000000.0f);
        }
        disable();
        enable();
    }
}
