package com.soundcloud.android.crop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import b.g.a.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Intent f3057a;

    private a(Uri uri, Uri uri2) {
        Intent intent = new Intent();
        this.f3057a = intent;
        intent.setData(uri);
        this.f3057a.putExtra("output", uri2);
    }

    public static a c(Uri uri, Uri uri2) {
        return new a(uri, uri2);
    }

    public a a() {
        this.f3057a.putExtra("aspect_x", 1);
        this.f3057a.putExtra("aspect_y", 1);
        return this;
    }

    public Intent b(Context context) {
        this.f3057a.setClass(context, CropImageActivity.class);
        return this.f3057a;
    }

    public void d(Activity activity) {
        e(activity, 6709);
    }

    public void e(Activity activity, int i) {
        activity.startActivityForResult(b(activity), i);
    }

    public void f(Context context, d dVar) {
        g(context, dVar, 6709);
    }

    public void g(Context context, d dVar, int i) {
        dVar.startActivityForResult(b(context), i);
    }

    public a h(int i, int i2) {
        this.f3057a.putExtra("aspect_x", i);
        this.f3057a.putExtra("aspect_y", i2);
        return this;
    }

    public a i(int i, int i2) {
        this.f3057a.putExtra("max_x", i);
        this.f3057a.putExtra("max_y", i2);
        return this;
    }
}
