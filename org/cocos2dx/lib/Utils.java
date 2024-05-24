package org.cocos2dx.lib;

import android.app.Activity;
import android.os.Build;
import android.view.View;

public class Utils {
    private static Activity sActivity;

    public static void hideVirtualButton() {
        if (Build.VERSION.SDK_INT >= 19 && sActivity != null) {
            Class cls = View.class;
            int intValue = ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION")).intValue();
            int intValue2 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN")).intValue();
            int intValue3 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_HIDE_NAVIGATION")).intValue();
            int intValue4 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_FULLSCREEN")).intValue();
            Object[] objArr = {Integer.valueOf(((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_LAYOUT_STABLE")).intValue() | intValue | intValue2 | intValue3 | intValue4 | ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "SYSTEM_UI_FLAG_IMMERSIVE_STICKY")).intValue())};
            Cocos2dxReflectionHelper.invokeInstanceMethod(sActivity.getWindow().getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, objArr);
        }
    }

    public static void setActivity(Activity activity) {
        sActivity = activity;
    }
}
