package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.soundcloud.android.crop.d;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends d {
    private int A;
    ArrayList<c> u = new ArrayList<>();
    c v;
    Context w;
    private float x;
    private float y;
    private int z;

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void s(c cVar) {
        Rect rect = cVar.f3059b;
        float max = Math.max(1.0f, Math.min((((float) getWidth()) / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = {cVar.f3058a.centerX(), cVar.f3058a.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            q(max, fArr[0], fArr[1], 300.0f);
        }
        t(cVar);
    }

    private void t(c cVar) {
        Rect rect = cVar.f3059b;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            j((float) max, (float) max2);
        }
    }

    public /* bridge */ /* synthetic */ Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    /* access modifiers changed from: protected */
    public void k(float f2, float f3) {
        super.k(f2, f3);
        Iterator<c> it = this.u.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.f3060c.postTranslate(f2, f3);
            next.n();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<c> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (this.n.a() != null) {
            Iterator<c> it = this.u.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.f3060c.set(getUnrotatedMatrix());
                next.n();
                if (next.l()) {
                    s(next);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (getScale() == 1.0f) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.w
            com.soundcloud.android.crop.CropImageActivity r0 = (com.soundcloud.android.crop.CropImageActivity) r0
            boolean r0 = r0.q()
            if (r0 == 0) goto L_0x000c
            r7 = 0
            return r7
        L_0x000c:
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x006b
            if (r0 == r1) goto L_0x0056
            r2 = 2
            if (r0 == r2) goto L_0x001a
            goto L_0x00b3
        L_0x001a:
            com.soundcloud.android.crop.c r0 = r6.v
            if (r0 == 0) goto L_0x004b
            int r0 = r7.getActionIndex()
            int r0 = r7.getPointerId(r0)
            int r2 = r6.A
            if (r0 != r2) goto L_0x004b
            com.soundcloud.android.crop.c r0 = r6.v
            int r2 = r6.z
            float r3 = r7.getX()
            float r4 = r6.x
            float r3 = r3 - r4
            float r4 = r7.getY()
            float r5 = r6.y
            float r4 = r4 - r5
            r0.k(r2, r3, r4)
            float r0 = r7.getX()
            r6.x = r0
            float r7 = r7.getY()
            r6.y = r7
        L_0x004b:
            float r7 = r6.getScale()
            r0 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x00b3
            goto L_0x0067
        L_0x0056:
            com.soundcloud.android.crop.c r7 = r6.v
            if (r7 == 0) goto L_0x0064
            r6.s(r7)
            com.soundcloud.android.crop.c r7 = r6.v
            com.soundcloud.android.crop.c$b r0 = com.soundcloud.android.crop.c.b.None
            r7.r(r0)
        L_0x0064:
            r7 = 0
            r6.v = r7
        L_0x0067:
            r6.b()
            goto L_0x00b3
        L_0x006b:
            java.util.ArrayList<com.soundcloud.android.crop.c> r0 = r6.u
            java.util.Iterator r0 = r0.iterator()
        L_0x0071:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r2 = r0.next()
            com.soundcloud.android.crop.c r2 = (com.soundcloud.android.crop.c) r2
            float r3 = r7.getX()
            float r4 = r7.getY()
            int r3 = r2.h(r3, r4)
            if (r3 == r1) goto L_0x0071
            r6.z = r3
            r6.v = r2
            float r0 = r7.getX()
            r6.x = r0
            float r0 = r7.getY()
            r6.y = r0
            int r0 = r7.getActionIndex()
            int r7 = r7.getPointerId(r0)
            r6.A = r7
            com.soundcloud.android.crop.c r7 = r6.v
            r0 = 32
            if (r3 != r0) goto L_0x00ae
            com.soundcloud.android.crop.c$b r0 = com.soundcloud.android.crop.c.b.Move
            goto L_0x00b0
        L_0x00ae:
            com.soundcloud.android.crop.c$b r0 = com.soundcloud.android.crop.c.b.Grow
        L_0x00b0:
            r7.r(r0)
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soundcloud.android.crop.CropImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void p(float f2, float f3, float f4) {
        super.p(f2, f3, f4);
        Iterator<c> it = this.u.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.f3060c.set(getUnrotatedMatrix());
            next.n();
        }
    }

    public void r(c cVar) {
        this.u.add(cVar);
        invalidate();
    }

    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public /* bridge */ /* synthetic */ void setRecycler(d.c cVar) {
        super.setRecycler(cVar);
    }
}
