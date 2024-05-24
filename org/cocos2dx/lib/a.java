package org.cocos2dx.lib;

import java.util.concurrent.CountDownLatch;

class a implements Runnable {
    private CountDownLatch j;
    private boolean[] k;
    private final int l;
    private final String m;

    a(CountDownLatch countDownLatch, boolean[] zArr, int i, String str) {
        this.j = countDownLatch;
        this.k = zArr;
        this.l = i;
        this.m = str;
    }

    public void run() {
        this.k[0] = Cocos2dxWebViewHelper._shouldStartLoading(this.l, this.m);
        this.j.countDown();
    }
}
