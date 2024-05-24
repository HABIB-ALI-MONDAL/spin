package org.cocos2dx.javascript;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.cocos2dx.javascript.service.SDKClass;
import org.json.JSONArray;
import org.json.JSONObject;

public class SDKWrapper {
    private static SDKWrapper mInstace;
    private Context mainActive = null;
    private List<SDKClass> sdkClasses;

    public static SDKWrapper getInstance() {
        if (mInstace == null) {
            mInstace = new SDKWrapper();
        }
        return mInstace;
    }

    private String getJson(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }

    public Context getContext() {
        return this.mainActive;
    }

    public void init(Context context) {
        this.mainActive = context;
        for (SDKClass init : this.sdkClasses) {
            init.init(context);
        }
    }

    public void loadSDKClass() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(getJson(this.mainActive, "project.json")).getJSONArray("serviceClassPath");
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add((SDKClass) Class.forName(jSONArray.getString(i)).newInstance());
                }
                this.sdkClasses = arrayList;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        for (SDKClass onActivityResult : this.sdkClasses) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        for (SDKClass onBackPressed : this.sdkClasses) {
            onBackPressed.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (SDKClass onConfigurationChanged : this.sdkClasses) {
            onConfigurationChanged.onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        for (SDKClass onDestroy : this.sdkClasses) {
            onDestroy.onDestroy();
        }
    }

    public void onNewIntent(Intent intent) {
        for (SDKClass onNewIntent : this.sdkClasses) {
            onNewIntent.onNewIntent(intent);
        }
    }

    public void onPause() {
        for (SDKClass onPause : this.sdkClasses) {
            onPause.onPause();
        }
    }

    public void onRestart() {
        for (SDKClass onRestart : this.sdkClasses) {
            onRestart.onRestart();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        for (SDKClass onRestoreInstanceState : this.sdkClasses) {
            onRestoreInstanceState.onRestoreInstanceState(bundle);
        }
    }

    public void onResume() {
        for (SDKClass onResume : this.sdkClasses) {
            onResume.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        for (SDKClass onSaveInstanceState : this.sdkClasses) {
            onSaveInstanceState.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        for (SDKClass onStart : this.sdkClasses) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (SDKClass onStop : this.sdkClasses) {
            onStop.onStop();
        }
    }

    public void setGLSurfaceView(GLSurfaceView gLSurfaceView, Context context) {
        this.mainActive = context;
        loadSDKClass();
        for (SDKClass gLSurfaceView2 : this.sdkClasses) {
            gLSurfaceView2.setGLSurfaceView(gLSurfaceView);
        }
    }
}
