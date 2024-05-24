package org.cocos2dx.javascript.service;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public abstract class SDKClass implements SDKInterface {
    private Context mainActive = null;

    public Context getContext() {
        return this.mainActive;
    }

    public void init(Context context) {
        this.mainActive = context;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onBackPressed() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
    }
}
