package com.darsh.multipleimageselect.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class AlbumSelectActivity extends androidx.appcompat.app.c {
    private Button A;
    private final String[] B = {"android.permission.READ_EXTERNAL_STORAGE"};
    /* access modifiers changed from: private */
    public TextView C;
    /* access modifiers changed from: private */
    public ProgressBar D;
    /* access modifiers changed from: private */
    public GridView E;
    /* access modifiers changed from: private */
    public c.c.a.f.a F;
    private androidx.appcompat.app.a G;
    private ContentObserver H;
    /* access modifiers changed from: private */
    public Handler I;
    private Thread J;
    /* access modifiers changed from: private */
    public final String[] K = {"bucket_display_name", "_data"};
    /* access modifiers changed from: private */
    public ArrayList<c.c.a.h.a> y;
    private TextView z;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            AlbumSelectActivity.this.Z();
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            Intent intent = new Intent(AlbumSelectActivity.this.getApplicationContext(), ImageSelectActivity.class);
            intent.putExtra("album", ((c.c.a.h.a) AlbumSelectActivity.this.y.get(i)).f1296a);
            AlbumSelectActivity.this.startActivityForResult(intent, 2000);
        }
    }

    class c extends Handler {
        c() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 2001:
                    AlbumSelectActivity.this.D.setVisibility(0);
                    break;
                case 2002:
                    if (AlbumSelectActivity.this.F == null) {
                        c.c.a.f.a unused = AlbumSelectActivity.this.F = new c.c.a.f.a(AlbumSelectActivity.this.getApplicationContext(), AlbumSelectActivity.this.y);
                        AlbumSelectActivity.this.E.setAdapter(AlbumSelectActivity.this.F);
                        AlbumSelectActivity.this.D.setVisibility(4);
                        AlbumSelectActivity.this.E.setVisibility(0);
                        AlbumSelectActivity albumSelectActivity = AlbumSelectActivity.this;
                        albumSelectActivity.Y(albumSelectActivity.getResources().getConfiguration().orientation);
                        return;
                    }
                    AlbumSelectActivity.this.F.notifyDataSetChanged();
                    return;
                case 2003:
                    AlbumSelectActivity.this.W();
                    AlbumSelectActivity.this.X();
                    return;
                case 2004:
                    AlbumSelectActivity.this.a0();
                    AlbumSelectActivity.this.D.setVisibility(4);
                    break;
                case 2005:
                    AlbumSelectActivity.this.D.setVisibility(4);
                    AlbumSelectActivity.this.C.setVisibility(0);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
            AlbumSelectActivity.this.E.setVisibility(4);
        }
    }

    class d extends ContentObserver {
        d(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            AlbumSelectActivity.this.X();
        }
    }

    private class e implements Runnable {
        private e() {
        }

        /* synthetic */ e(AlbumSelectActivity albumSelectActivity, a aVar) {
            this();
        }

        public void run() {
            Process.setThreadPriority(10);
            if (AlbumSelectActivity.this.F == null) {
                Message obtainMessage = AlbumSelectActivity.this.I.obtainMessage();
                obtainMessage.what = 2001;
                obtainMessage.sendToTarget();
            }
            if (!Thread.interrupted()) {
                Cursor query = AlbumSelectActivity.this.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, AlbumSelectActivity.this.K, (String) null, (String[]) null, "date_added");
                if (query == null) {
                    Message obtainMessage2 = AlbumSelectActivity.this.I.obtainMessage();
                    obtainMessage2.what = 2005;
                    obtainMessage2.sendToTarget();
                    return;
                }
                ArrayList arrayList = new ArrayList(query.getCount());
                HashSet hashSet = new HashSet();
                if (query.moveToLast()) {
                    while (!Thread.interrupted()) {
                        String string = query.getString(query.getColumnIndex(AlbumSelectActivity.this.K[0]));
                        String string2 = query.getString(query.getColumnIndex(AlbumSelectActivity.this.K[1]));
                        if (new File(string2).exists() && !hashSet.contains(string)) {
                            arrayList.add(new c.c.a.h.a(string, string2));
                            hashSet.add(string);
                        }
                        if (!query.moveToPrevious()) {
                        }
                    }
                    return;
                }
                query.close();
                if (AlbumSelectActivity.this.y == null) {
                    ArrayList unused = AlbumSelectActivity.this.y = new ArrayList();
                }
                AlbumSelectActivity.this.y.clear();
                AlbumSelectActivity.this.y.addAll(arrayList);
                Message obtainMessage3 = AlbumSelectActivity.this.I.obtainMessage();
                obtainMessage3.what = 2002;
                obtainMessage3.sendToTarget();
                Thread.interrupted();
            }
        }
    }

    public AlbumSelectActivity() {
        Class<AlbumSelectActivity> cls = AlbumSelectActivity.class;
    }

    private void G() {
        Thread thread = this.J;
        if (thread != null && thread.isAlive()) {
            this.J.interrupt();
            try {
                this.J.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void V() {
        if (androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            Z();
            return;
        }
        Message obtainMessage = this.I.obtainMessage();
        obtainMessage.what = 2003;
        obtainMessage.sendToTarget();
    }

    /* access modifiers changed from: private */
    public void W() {
        this.z.setVisibility(4);
        this.A.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void X() {
        G();
        Thread thread = new Thread(new e(this, (a) null));
        this.J = thread;
        thread.start();
    }

    /* access modifiers changed from: private */
    public void Y(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        c.c.a.f.a aVar = this.F;
        int i2 = 2;
        if (aVar != null) {
            int i3 = displayMetrics.widthPixels;
            aVar.b(i == 1 ? i3 / 2 : i3 / 4);
        }
        GridView gridView = this.E;
        if (i != 1) {
            i2 = 4;
        }
        gridView.setNumColumns(i2);
    }

    /* access modifiers changed from: private */
    public void Z() {
        androidx.core.app.a.m(this, this.B, 23);
    }

    /* access modifiers changed from: private */
    public void a0() {
        this.z.setVisibility(0);
        this.A.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2000 && i2 == -1 && intent != null) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Y(configuration.orientation);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.c.a.c.activity_album_select);
        D((Toolbar) findViewById(c.c.a.b.toolbar));
        androidx.appcompat.app.a x = x();
        this.G = x;
        if (x != null) {
            x.s(true);
            this.G.u(c.c.a.a.ic_arrow_back);
            this.G.t(true);
            this.G.x(c.c.a.e.album_view);
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        c.c.a.g.a.f1295a = intent.getIntExtra("limit", 10);
        TextView textView = (TextView) findViewById(c.c.a.b.text_view_error);
        this.C = textView;
        textView.setVisibility(4);
        this.z = (TextView) findViewById(c.c.a.b.text_view_request_permission);
        Button button = (Button) findViewById(c.c.a.b.button_grant_permission);
        this.A = button;
        button.setOnClickListener(new a());
        W();
        this.D = (ProgressBar) findViewById(c.c.a.b.progress_bar_album_select);
        GridView gridView = (GridView) findViewById(c.c.a.b.grid_view_album_select);
        this.E = gridView;
        gridView.setOnItemClickListener(new b());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.a aVar = this.G;
        if (aVar != null) {
            aVar.v((Drawable) null);
        }
        this.y = null;
        c.c.a.f.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.E.setOnItemClickListener((AdapterView.OnItemClickListener) null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        onBackPressed();
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 23) {
            Message obtainMessage = this.I.obtainMessage();
            obtainMessage.what = (iArr.length <= 0 || iArr[0] != 0) ? 2004 : 2003;
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.I = new c();
        this.H = new d(this.I);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.H);
        V();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        G();
        getContentResolver().unregisterContentObserver(this.H);
        this.H = null;
        Handler handler = this.I;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.I = null;
        }
    }
}
