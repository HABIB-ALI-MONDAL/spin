package org.cocos2dx.lib;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import java.io.IOException;
import java.util.Map;

public class Cocos2dxVideoView extends SurfaceView {
    private static final String AssetResourceRoot = "@assets/";
    private static final int EVENT_CLICKED = 5;
    private static final int EVENT_COMPLETED = 3;
    private static final int EVENT_META_LOADED = 4;
    private static final int EVENT_PAUSED = 1;
    private static final int EVENT_PLAYING = 0;
    private static final int EVENT_READY_TO_PLAY = 6;
    private static final int EVENT_STOPPED = 2;
    /* access modifiers changed from: private */
    public String TAG = "Cocos2dxVideoView";
    protected Cocos2dxActivity mCocos2dxActivity = null;
    private MediaPlayer.OnCompletionListener mCompletionListener = new b();
    /* access modifiers changed from: private */
    public e mCurrentState = e.IDLE;
    private int mDuration;
    private MediaPlayer.OnErrorListener mErrorListener = new c();
    protected boolean mFullScreenEnabled = false;
    protected int mFullScreenHeight = 0;
    protected int mFullScreenWidth = 0;
    private boolean mIsAssetRouse = false;
    private boolean mKeepRatio = false;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer = null;
    /* access modifiers changed from: private */
    public boolean mMetaUpdated = false;
    private OnVideoEventListener mOnVideoEventListener;
    /* access modifiers changed from: private */
    public int mPositionBeforeRelease = 0;
    MediaPlayer.OnPreparedListener mPreparedListener = new a();
    SurfaceHolder.Callback mSHCallback = new d();
    private int mSeekWhenPrepared = 0;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder = null;
    private String mVideoFilePath = null;
    /* access modifiers changed from: private */
    public int mVideoHeight = 0;
    private Uri mVideoUri;
    /* access modifiers changed from: private */
    public int mVideoWidth = 0;
    protected int mViewHeight = 0;
    protected int mViewLeft = 0;
    private int mViewTag = 0;
    protected int mViewTop = 0;
    protected int mViewWidth = 0;
    protected int mVisibleHeight = 0;
    protected int mVisibleLeft = 0;
    protected int mVisibleTop = 0;
    protected int mVisibleWidth = 0;

    public interface OnVideoEventListener {
        void onVideoEvent(int i, int i2);
    }

    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            int unused = Cocos2dxVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            int unused2 = Cocos2dxVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            if (!(Cocos2dxVideoView.this.mVideoWidth == 0 || Cocos2dxVideoView.this.mVideoHeight == 0)) {
                Cocos2dxVideoView.this.fixSize();
            }
            if (!Cocos2dxVideoView.this.mMetaUpdated) {
                Cocos2dxVideoView.this.sendEvent(4);
                Cocos2dxVideoView.this.sendEvent(6);
                boolean unused3 = Cocos2dxVideoView.this.mMetaUpdated = true;
            }
            e unused4 = Cocos2dxVideoView.this.mCurrentState = e.PREPARED;
        }
    }

    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            e unused = Cocos2dxVideoView.this.mCurrentState = e.PLAYBACK_COMPLETED;
            Cocos2dxVideoView.this.sendEvent(3);
        }
    }

    class c implements MediaPlayer.OnErrorListener {

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Cocos2dxVideoView.this.sendEvent(3);
            }
        }

        c() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String access$500 = Cocos2dxVideoView.this.TAG;
            Log.d(access$500, "Error: " + i + "," + i2);
            e unused = Cocos2dxVideoView.this.mCurrentState = e.ERROR;
            if (Cocos2dxVideoView.this.getWindowToken() == null) {
                return true;
            }
            Resources resources = Cocos2dxVideoView.this.mCocos2dxActivity.getResources();
            new AlertDialog.Builder(Cocos2dxVideoView.this.mCocos2dxActivity).setTitle(resources.getString(resources.getIdentifier("VideoView_error_title", "string", "android"))).setMessage(resources.getIdentifier(i == 200 ? "VideoView_error_text_invalid_progressive_playback" : "VideoView_error_text_unknown", "string", "android")).setPositiveButton(resources.getString(resources.getIdentifier("VideoView_error_button", "string", "android")), new a()).setCancelable(false).show();
            return true;
        }
    }

    class d implements SurfaceHolder.Callback {
        d() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceHolder unused = Cocos2dxVideoView.this.mSurfaceHolder = surfaceHolder;
            Cocos2dxVideoView.this.openVideo();
            if (Cocos2dxVideoView.this.mPositionBeforeRelease > 0) {
                Cocos2dxVideoView.this.mMediaPlayer.seekTo(Cocos2dxVideoView.this.mPositionBeforeRelease);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SurfaceHolder unused = Cocos2dxVideoView.this.mSurfaceHolder = null;
            Cocos2dxVideoView cocos2dxVideoView = Cocos2dxVideoView.this;
            int unused2 = cocos2dxVideoView.mPositionBeforeRelease = cocos2dxVideoView.getCurrentPosition();
            Cocos2dxVideoView.this.release();
        }
    }

    private enum e {
        IDLE,
        ERROR,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACK_COMPLETED
    }

    public Cocos2dxVideoView(Cocos2dxActivity cocos2dxActivity, int i) {
        super(cocos2dxActivity);
        this.mViewTag = i;
        this.mCocos2dxActivity = cocos2dxActivity;
        initVideoView();
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mCurrentState = e.IDLE;
    }

    /* access modifiers changed from: private */
    public void openVideo() {
        String str;
        StringBuilder sb;
        if (this.mSurfaceHolder != null) {
            if (this.mIsAssetRouse) {
                if (this.mVideoFilePath == null) {
                    return;
                }
            } else if (this.mVideoUri == null) {
                return;
            }
            pausePlaybackService();
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                if (this.mIsAssetRouse) {
                    AssetFileDescriptor openFd = this.mCocos2dxActivity.getAssets().openFd(this.mVideoFilePath);
                    this.mMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                } else {
                    this.mMediaPlayer.setDataSource(this.mVideoUri.toString());
                }
                this.mCurrentState = e.INITIALIZED;
                this.mMediaPlayer.prepare();
                showFirstFrame();
            } catch (IOException e2) {
                e = e2;
                str = this.TAG;
                sb = new StringBuilder();
                sb.append("Unable to open content: ");
                sb.append(this.mVideoUri);
                Log.w(str, sb.toString(), e);
                this.mCurrentState = e.ERROR;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                str = this.TAG;
                sb = new StringBuilder();
                sb.append("Unable to open content: ");
                sb.append(this.mVideoUri);
                Log.w(str, sb.toString(), e);
                this.mCurrentState = e.ERROR;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    private void pausePlaybackService() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        this.mCocos2dxActivity.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    public void release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(int i) {
        OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
        if (onVideoEventListener != null) {
            onVideoEventListener.onVideoEvent(this.mViewTag, i);
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mVideoUri = uri;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    private void showFirstFrame() {
        this.mMediaPlayer.seekTo(1);
    }

    public void fixSize() {
        if (this.mFullScreenEnabled) {
            this.mFullScreenWidth = this.mCocos2dxActivity.getGLSurfaceView().getWidth();
            int height = this.mCocos2dxActivity.getGLSurfaceView().getHeight();
            this.mFullScreenHeight = height;
            fixSize(0, 0, this.mFullScreenWidth, height);
            return;
        }
        fixSize(this.mViewLeft, this.mViewTop, this.mViewWidth, this.mViewHeight);
    }

    public void fixSize(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = this.mVideoWidth;
        if (!(i6 == 0 || (i5 = this.mVideoHeight) == 0)) {
            if (i3 == 0 || i4 == 0) {
                this.mVisibleLeft = i;
                this.mVisibleTop = i2;
                this.mVisibleWidth = i6;
                this.mVisibleHeight = i5;
                getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.leftMargin = this.mVisibleLeft;
                layoutParams.topMargin = this.mVisibleTop;
                setLayoutParams(layoutParams);
            } else if (this.mKeepRatio && !this.mFullScreenEnabled) {
                if (i6 * i4 > i3 * i5) {
                    this.mVisibleWidth = i3;
                    this.mVisibleHeight = (i5 * i3) / i6;
                } else if (i6 * i4 < i3 * i5) {
                    this.mVisibleWidth = (i6 * i4) / i5;
                    this.mVisibleHeight = i4;
                }
                this.mVisibleLeft = i + ((i3 - this.mVisibleWidth) / 2);
                this.mVisibleTop = i2 + ((i4 - this.mVisibleHeight) / 2);
                getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams2.leftMargin = this.mVisibleLeft;
                layoutParams2.topMargin = this.mVisibleTop;
                setLayoutParams(layoutParams2);
            }
        }
        this.mVisibleLeft = i;
        this.mVisibleTop = i2;
        this.mVisibleWidth = i3;
        this.mVisibleHeight = i4;
        getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
        FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams22.leftMargin = this.mVisibleLeft;
        layoutParams22.topMargin = this.mVisibleTop;
        setLayoutParams(layoutParams22);
    }

    public int getCurrentPosition() {
        boolean z = true;
        boolean z2 = this.mCurrentState == e.ERROR;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            z = false;
        }
        if (!z2 && !z) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if (!(eVar == e.IDLE || eVar == e.ERROR || eVar == e.INITIALIZED || (mediaPlayer = this.mMediaPlayer) == null)) {
            this.mDuration = mediaPlayer.getDuration();
        }
        return this.mDuration;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mVisibleWidth, this.mVisibleHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            sendEvent(5);
        }
        return true;
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if ((eVar == e.STARTED || eVar == e.PLAYBACK_COMPLETED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = e.PAUSED;
            mediaPlayer.pause();
            sendEvent(1);
        }
    }

    public int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i : size : Math.min(i, size);
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if (eVar != e.IDLE && eVar != e.INITIALIZED && eVar != e.STOPPED && eVar != e.ERROR && (mediaPlayer = this.mMediaPlayer) != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public void setFullScreenEnabled(boolean z) {
        if (this.mFullScreenEnabled != z) {
            this.mFullScreenEnabled = z;
            fixSize();
        }
    }

    public void setKeepRatio(boolean z) {
        this.mKeepRatio = z;
        fixSize();
    }

    public void setVideoFileName(String str) {
        boolean z;
        if (str.startsWith(AssetResourceRoot)) {
            str = str.substring(8);
        }
        if (str.startsWith("/")) {
            z = false;
        } else {
            this.mVideoFilePath = str;
            z = true;
        }
        this.mIsAssetRouse = z;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVideoRect(int i, int i2, int i3, int i4) {
        if (this.mViewLeft != i || this.mViewTop != i2 || this.mViewWidth != i3 || this.mViewHeight != i4) {
            this.mViewLeft = i;
            this.mViewTop = i2;
            this.mViewWidth = i3;
            this.mViewHeight = i4;
            fixSize(i, i2, i3, i4);
        }
    }

    public void setVideoURL(String str) {
        this.mIsAssetRouse = false;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVideoViewEventListener(OnVideoEventListener onVideoEventListener) {
        this.mOnVideoEventListener = onVideoEventListener;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f2);
        }
    }

    public void start() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if ((eVar == e.PREPARED || eVar == e.PAUSED || eVar == e.PLAYBACK_COMPLETED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = e.STARTED;
            mediaPlayer.start();
            sendEvent(0);
        }
    }

    public void stop() {
        e eVar;
        MediaPlayer mediaPlayer;
        e eVar2 = this.mCurrentState;
        if (eVar2 != e.IDLE && eVar2 != e.INITIALIZED && eVar2 != e.ERROR && eVar2 != (eVar = e.STOPPED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = eVar;
            mediaPlayer.stop();
            sendEvent(2);
            try {
                this.mMediaPlayer.prepare();
                showFirstFrame();
            } catch (Exception unused) {
            }
        }
    }

    public void stopPlayback() {
        release();
    }
}
