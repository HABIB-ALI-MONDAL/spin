package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.IInterface;
import c.d.a.b.d.a;
import java.util.Map;

public interface f1 extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(i1 i1Var);

    void getAppInstanceId(i1 i1Var);

    void getCachedAppInstanceId(i1 i1Var);

    void getConditionalUserProperties(String str, String str2, i1 i1Var);

    void getCurrentScreenClass(i1 i1Var);

    void getCurrentScreenName(i1 i1Var);

    void getGmpAppId(i1 i1Var);

    void getMaxUserProperties(String str, i1 i1Var);

    void getSessionId(i1 i1Var);

    void getTestFlag(i1 i1Var, int i);

    void getUserProperties(String str, String str2, boolean z, i1 i1Var);

    void initForTests(Map map);

    void initialize(a aVar, n1 n1Var, long j);

    void isDataCollectionEnabled(i1 i1Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, i1 i1Var, long j);

    void logHealthData(int i, String str, a aVar, a aVar2, a aVar3);

    void onActivityCreated(a aVar, Bundle bundle, long j);

    void onActivityDestroyed(a aVar, long j);

    void onActivityPaused(a aVar, long j);

    void onActivityResumed(a aVar, long j);

    void onActivitySaveInstanceState(a aVar, i1 i1Var, long j);

    void onActivityStarted(a aVar, long j);

    void onActivityStopped(a aVar, long j);

    void performAction(Bundle bundle, i1 i1Var, long j);

    void registerOnMeasurementEventListener(k1 k1Var);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(a aVar, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(k1 k1Var);

    void setInstanceIdProvider(m1 m1Var);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, a aVar, boolean z, long j);

    void unregisterOnMeasurementEventListener(k1 k1Var);
}
