package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

public class CanvasRenderingContext2DImpl {
    private static final String TAG = "CanvasContext2D";
    private static final int TEXT_ALIGN_CENTER = 1;
    private static final int TEXT_ALIGN_LEFT = 0;
    private static final int TEXT_ALIGN_RIGHT = 2;
    private static final int TEXT_BASELINE_BOTTOM = 2;
    private static final int TEXT_BASELINE_MIDDLE = 1;
    private static final int TEXT_BASELINE_TOP = 0;
    private static float _sApproximatingOblique = -0.25f;
    private static WeakReference<Context> sContext;
    private static HashMap<String, Typeface> sTypefaceCache = new HashMap<>();
    private Bitmap mBitmap;
    private Canvas mCanvas = new Canvas();
    private int mFillStyleA = 255;
    private int mFillStyleB = 0;
    private int mFillStyleG = 0;
    private int mFillStyleR = 0;
    private String mFontName = "Arial";
    private float mFontSize = 40.0f;
    private boolean mIsBoldFont = false;
    private boolean mIsItalicFont = false;
    private boolean mIsObliqueFont = false;
    private boolean mIsSmallCapsFontVariant = false;
    private String mLineCap = "butt";
    private String mLineJoin = "miter";
    private Paint mLinePaint;
    private Path mLinePath;
    private float mLineWidth = 0.0f;
    private int mStrokeStyleA = 255;
    private int mStrokeStyleB = 0;
    private int mStrokeStyleG = 0;
    private int mStrokeStyleR = 0;
    private int mTextAlign = 0;
    private int mTextBaseline = 2;
    private TextPaint mTextPaint;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public float f3125a;

        /* renamed from: b  reason: collision with root package name */
        public float f3126b;

        a(CanvasRenderingContext2DImpl canvasRenderingContext2DImpl, float f2, float f3) {
            this.f3125a = f2;
            this.f3126b = f3;
        }

        a(CanvasRenderingContext2DImpl canvasRenderingContext2DImpl, a aVar) {
            this.f3125a = aVar.f3125a;
            this.f3126b = aVar.f3126b;
        }
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        public float f3127a;

        /* renamed from: b  reason: collision with root package name */
        public float f3128b;

        b(CanvasRenderingContext2DImpl canvasRenderingContext2DImpl, float f2, float f3) {
            this.f3127a = f2;
            this.f3128b = f3;
        }
    }

    private CanvasRenderingContext2DImpl() {
    }

    private void _fillImageData(byte[] bArr, float f2, float f3, float f4, float f5) {
        Log.d(TAG, "_fillImageData: ");
        int i = (int) (f2 * f3);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 4;
            iArr[i2] = (((bArr[i3 + 3] & 255) & 255) << 24) | (((bArr[i3 + 0] & 255) & 255) << 16) | (((bArr[i3 + 1] & 255) & 255) << 8) | (bArr[i3 + 2] & 255 & 255);
        }
        int i4 = (int) f2;
        this.mBitmap.setPixels(iArr, 0, i4, (int) f4, (int) f5, i4, (int) f3);
    }

    private void beginPath() {
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePath.reset();
    }

    private void clearRect(float f2, float f3, float f4, float f5) {
        int i = (int) (f4 * f5);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
        int i3 = (int) f4;
        this.mBitmap.setPixels(iArr, 0, i3, (int) f2, (int) f3, i3, (int) f5);
    }

    private static void clearTypefaceCache() {
        sTypefaceCache.clear();
    }

    private void closePath() {
        this.mLinePath.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.cocos2dx.lib.CanvasRenderingContext2DImpl.a convertDrawPoint(org.cocos2dx.lib.CanvasRenderingContext2DImpl.a r5, java.lang.String r6) {
        /*
            r4 = this;
            org.cocos2dx.lib.CanvasRenderingContext2DImpl$a r0 = new org.cocos2dx.lib.CanvasRenderingContext2DImpl$a
            r0.<init>(r4, r5)
            org.cocos2dx.lib.CanvasRenderingContext2DImpl$b r5 = r4.measureTextReturnSize(r6)
            int r6 = r4.mTextAlign
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 1
            if (r6 != r2) goto L_0x0019
            float r6 = r0.f3125a
            float r3 = r5.f3127a
            float r3 = r3 / r1
        L_0x0015:
            float r6 = r6 - r3
            r0.f3125a = r6
            goto L_0x0021
        L_0x0019:
            r3 = 2
            if (r6 != r3) goto L_0x0021
            float r6 = r0.f3125a
            float r3 = r5.f3127a
            goto L_0x0015
        L_0x0021:
            int r6 = r4.mTextBaseline
            if (r6 != 0) goto L_0x002d
            float r6 = r0.f3126b
            float r5 = r5.f3128b
        L_0x0029:
            float r6 = r6 + r5
            r0.f3126b = r6
            goto L_0x0035
        L_0x002d:
            if (r6 != r2) goto L_0x0035
            float r6 = r0.f3126b
            float r5 = r5.f3128b
            float r5 = r5 / r1
            goto L_0x0029
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.lib.CanvasRenderingContext2DImpl.convertDrawPoint(org.cocos2dx.lib.CanvasRenderingContext2DImpl$a, java.lang.String):org.cocos2dx.lib.CanvasRenderingContext2DImpl$a");
    }

    private void createTextPaintIfNeeded() {
        if (this.mTextPaint == null) {
            this.mTextPaint = newPaint(this.mFontName, (int) this.mFontSize, this.mIsBoldFont, this.mIsItalicFont, this.mIsObliqueFont, this.mIsSmallCapsFontVariant);
        }
    }

    static void destroy() {
        sContext = null;
    }

    private void fill() {
        if (this.mLinePaint == null) {
            this.mLinePaint = new Paint();
        }
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePaint.setARGB(this.mFillStyleA, this.mFillStyleR, this.mFillStyleG, this.mFillStyleB);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
        this.mLinePaint.setStrokeWidth(0.0f);
        setStrokeCap(this.mLinePaint);
        setStrokeJoin(this.mLinePaint);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
    }

    private void fillRect(float f2, float f3, float f4, float f5) {
        int i = ((this.mFillStyleA & 255) << 24) | ((this.mFillStyleR & 255) << 16) | ((this.mFillStyleG & 255) << 8) | (this.mFillStyleB & 255);
        int i2 = (int) (f4 * f5);
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i;
        }
        int i4 = (int) f4;
        this.mBitmap.setPixels(iArr, 0, i4, (int) f2, (int) f3, i4, (int) f5);
    }

    private void fillText(String str, float f2, float f3, float f4) {
        createTextPaintIfNeeded();
        this.mTextPaint.setARGB(this.mFillStyleA, this.mFillStyleR, this.mFillStyleG, this.mFillStyleB);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        scaleX(this.mTextPaint, str, f4);
        a convertDrawPoint = convertDrawPoint(new a(this, f2, f3), str);
        this.mCanvas.drawText(str, convertDrawPoint.f3125a, convertDrawPoint.f3126b, this.mTextPaint);
    }

    private byte[] getDataRef() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            byte[] bArr = new byte[(bitmap.getWidth() * this.mBitmap.getHeight() * 4)];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.nativeOrder());
            this.mBitmap.copyPixelsToBuffer(wrap);
            return bArr;
        }
        Log.e(TAG, "getDataRef return null");
        return null;
    }

    static void init(Context context) {
        sContext = new WeakReference<>(context);
    }

    private void lineTo(float f2, float f3) {
        this.mLinePath.lineTo(f2, f3);
    }

    private static void loadTypeface(String str, String str2) {
        if (!sTypefaceCache.containsKey(str)) {
            Typeface typeface = null;
            try {
                if (str2.startsWith("/")) {
                    typeface = Typeface.createFromFile(str2);
                } else if (sContext.get() != null) {
                    if (str2.startsWith("@assets/")) {
                        str2 = str2.substring(8);
                    }
                    typeface = Typeface.createFromAsset(((Context) sContext.get()).getAssets(), str2);
                }
                if (typeface != null) {
                    sTypefaceCache.put(str, typeface);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private float measureText(String str) {
        createTextPaintIfNeeded();
        return this.mTextPaint.measureText(str);
    }

    private b measureTextReturnSize(String str) {
        createTextPaintIfNeeded();
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        return new b(this, measureText(str), fontMetrics.descent - fontMetrics.ascent);
    }

    private void moveTo(float f2, float f3) {
        this.mLinePath.moveTo(f2, f3);
    }

    private static TextPaint newPaint(String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        String str2;
        Typeface typeface;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i);
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        if (z) {
            str2 = str + "-Bold";
            textPaint.setFakeBoldText(true);
        } else {
            str2 = str;
        }
        if (z2) {
            str2 = str2 + "-Italic";
        }
        if (sTypefaceCache.containsKey(str2)) {
            typeface = sTypefaceCache.get(str2);
        } else {
            typeface = Typeface.create(str, (!z || !z2) ? z ? 1 : z2 ? 2 : 0 : 3);
        }
        textPaint.setTypeface(typeface);
        if (z3) {
            textPaint.setTextSkewX(_sApproximatingOblique);
        }
        if (z4 && Build.VERSION.SDK_INT >= 21) {
            Cocos2dxReflectionHelper.invokeInstanceMethod(textPaint, "setFontFeatureSettings", new Class[]{String.class}, new Object[]{"smcp"});
        }
        return textPaint;
    }

    private void recreateBuffer(float f2, float f3) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil((double) f2), (int) Math.ceil((double) f3), Bitmap.Config.ARGB_8888);
        this.mBitmap = createBitmap;
        this.mCanvas.setBitmap(createBitmap);
    }

    private void rect(float f2, float f3, float f4, float f5) {
        beginPath();
        moveTo(f2, f3);
        float f6 = f5 + f3;
        lineTo(f2, f6);
        float f7 = f2 + f4;
        lineTo(f7, f6);
        lineTo(f7, f3);
        closePath();
    }

    private void restoreContext() {
        if (this.mCanvas.getSaveCount() > 1) {
            this.mCanvas.restore();
        }
    }

    private void saveContext() {
        this.mCanvas.save();
    }

    private void scaleX(TextPaint textPaint, String str, float f2) {
        if (f2 >= Float.MIN_VALUE) {
            float measureText = measureText(str);
            if (measureText - f2 >= Float.MIN_VALUE) {
                textPaint.setTextScaleX(f2 / measureText);
            }
        }
    }

    private void setFillStyle(float f2, float f3, float f4, float f5) {
        this.mFillStyleR = (int) (f2 * 255.0f);
        this.mFillStyleG = (int) (f3 * 255.0f);
        this.mFillStyleB = (int) (f4 * 255.0f);
        this.mFillStyleA = (int) (f5 * 255.0f);
    }

    private void setLineCap(String str) {
        this.mLineCap = str;
    }

    private void setLineJoin(String str) {
        this.mLineJoin = str;
    }

    private void setLineWidth(float f2) {
        this.mLineWidth = f2;
    }

    private void setStrokeCap(Paint paint) {
        Paint.Cap cap;
        String str = this.mLineCap;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -894674659:
                if (str.equals("square")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3035667:
                if (str.equals("butt")) {
                    c2 = 1;
                    break;
                }
                break;
            case 108704142:
                if (str.equals("round")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                cap = Paint.Cap.SQUARE;
                break;
            case 1:
                cap = Paint.Cap.BUTT;
                break;
            case 2:
                cap = Paint.Cap.ROUND;
                break;
            default:
                return;
        }
        paint.setStrokeCap(cap);
    }

    private void setStrokeJoin(Paint paint) {
        Paint.Join join;
        String str = this.mLineJoin;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 93630586:
                if (str.equals("bevel")) {
                    c2 = 0;
                    break;
                }
                break;
            case 103906565:
                if (str.equals("miter")) {
                    c2 = 1;
                    break;
                }
                break;
            case 108704142:
                if (str.equals("round")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                join = Paint.Join.BEVEL;
                break;
            case 1:
                join = Paint.Join.MITER;
                break;
            case 2:
                join = Paint.Join.ROUND;
                break;
            default:
                return;
        }
        paint.setStrokeJoin(join);
    }

    private void setStrokeStyle(float f2, float f3, float f4, float f5) {
        this.mStrokeStyleR = (int) (f2 * 255.0f);
        this.mStrokeStyleG = (int) (f3 * 255.0f);
        this.mStrokeStyleB = (int) (f4 * 255.0f);
        this.mStrokeStyleA = (int) (f5 * 255.0f);
    }

    private void setTextAlign(int i) {
        this.mTextAlign = i;
    }

    private void setTextBaseline(int i) {
        this.mTextBaseline = i;
    }

    private void stroke() {
        if (this.mLinePaint == null) {
            Paint paint = new Paint();
            this.mLinePaint = paint;
            paint.setAntiAlias(true);
        }
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePaint.setARGB(this.mStrokeStyleA, this.mStrokeStyleR, this.mStrokeStyleG, this.mStrokeStyleB);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
        setStrokeCap(this.mLinePaint);
        setStrokeJoin(this.mLinePaint);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
    }

    private void strokeText(String str, float f2, float f3, float f4) {
        createTextPaintIfNeeded();
        this.mTextPaint.setARGB(this.mStrokeStyleA, this.mStrokeStyleR, this.mStrokeStyleG, this.mStrokeStyleB);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setStrokeWidth(this.mLineWidth);
        scaleX(this.mTextPaint, str, f4);
        a convertDrawPoint = convertDrawPoint(new a(this, f2, f3), str);
        this.mCanvas.drawText(str, convertDrawPoint.f3125a, convertDrawPoint.f3126b, this.mTextPaint);
    }

    private void updateFont(String str, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.mFontName = str;
        this.mFontSize = f2;
        this.mIsBoldFont = z;
        this.mIsItalicFont = z2;
        this.mIsObliqueFont = z3;
        this.mIsSmallCapsFontVariant = z4;
        this.mTextPaint = null;
    }
}
