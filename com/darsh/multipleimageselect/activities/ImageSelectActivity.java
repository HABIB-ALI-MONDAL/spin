package com.darsh.multipleimageselect.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class ImageSelectActivity extends androidx.appcompat.app.c {
    private TextView A;
    private Button B;
    private final String[] C = {"android.permission.READ_EXTERNAL_STORAGE"};
    /* access modifiers changed from: private */
    public TextView D;
    /* access modifiers changed from: private */
    public ProgressBar E;
    /* access modifiers changed from: private */
    public GridView F;
    /* access modifiers changed from: private */
    public c.c.a.f.c G;
    private androidx.appcompat.app.a H;
    /* access modifiers changed from: private */
    public ActionMode I;
    /* access modifiers changed from: private */
    public int J;
    private ContentObserver K;
    /* access modifiers changed from: private */
    public Handler L;
    private Thread M;
    /* access modifiers changed from: private */
    public final String[] N = {"_id", "_display_name", "_data"};
    /* access modifiers changed from: private */
    public ActionMode.Callback O = new e();
    /* access modifiers changed from: private */
    public ArrayList<c.c.a.h.b> y;
    /* access modifiers changed from: private */
    public String z;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            ImageSelectActivity.this.k0();
        }
    }

    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            if (ImageSelectActivity.this.I == null) {
                ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                ActionMode unused = imageSelectActivity.I = imageSelectActivity.startActionMode(imageSelectActivity.O);
            }
            ImageSelectActivity.this.n0(i);
            ActionMode I = ImageSelectActivity.this.I;
            I.setTitle(ImageSelectActivity.this.J + " " + ImageSelectActivity.this.getString(c.c.a.e.selected));
            if (ImageSelectActivity.this.J == 0) {
                ImageSelectActivity.this.I.finish();
            }
        }
    }

    class c extends Handler {
        c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x00d5, code lost:
            com.darsh.multipleimageselect.activities.ImageSelectActivity.d0(r5.f1855a).setVisibility(4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x00df, code lost:
            super.handleMessage(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                int r0 = r6.what
                r1 = 0
                r2 = 4
                switch(r0) {
                    case 2001: goto L_0x00cc;
                    case 2002: goto L_0x0039;
                    case 2003: goto L_0x002d;
                    case 2004: goto L_0x001d;
                    case 2005: goto L_0x0009;
                    default: goto L_0x0007;
                }
            L_0x0007:
                goto L_0x00df
            L_0x0009:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.ProgressBar r0 = r0.E
                r0.setVisibility(r2)
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.TextView r0 = r0.D
                r0.setVisibility(r1)
                goto L_0x00df
            L_0x001d:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                r6.m0()
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.ProgressBar r6 = r6.E
                r6.setVisibility(r2)
                goto L_0x00d5
            L_0x002d:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                r6.h0()
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                r6.i0()
                goto L_0x00e2
            L_0x0039:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                c.c.a.f.c r0 = r0.G
                if (r0 != 0) goto L_0x0088
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                c.c.a.f.c r0 = new c.c.a.f.c
                com.darsh.multipleimageselect.activities.ImageSelectActivity r3 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.content.Context r3 = r3.getApplicationContext()
                com.darsh.multipleimageselect.activities.ImageSelectActivity r4 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                java.util.ArrayList r4 = r4.y
                r0.<init>(r3, r4)
                c.c.a.f.c unused = r6.G = r0
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.GridView r6 = r6.F
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                c.c.a.f.c r0 = r0.G
                r6.setAdapter(r0)
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.ProgressBar r6 = r6.E
                r6.setVisibility(r2)
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.GridView r6 = r6.F
                r6.setVisibility(r1)
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.content.res.Resources r0 = r6.getResources()
                android.content.res.Configuration r0 = r0.getConfiguration()
                int r0 = r0.orientation
                r6.j0(r0)
                goto L_0x00e2
            L_0x0088:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                c.c.a.f.c r0 = r0.G
                r0.notifyDataSetChanged()
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.view.ActionMode r0 = r0.I
                if (r0 == 0) goto L_0x00e2
                com.darsh.multipleimageselect.activities.ImageSelectActivity r0 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                int r6 = r6.arg1
                int unused = r0.J = r6
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.view.ActionMode r6 = r6.I
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.darsh.multipleimageselect.activities.ImageSelectActivity r1 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                int r1 = r1.J
                r0.append(r1)
                java.lang.String r1 = " "
                r0.append(r1)
                com.darsh.multipleimageselect.activities.ImageSelectActivity r1 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                int r2 = c.c.a.e.selected
                java.lang.String r1 = r1.getString(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r6.setTitle(r0)
                goto L_0x00e2
            L_0x00cc:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.ProgressBar r6 = r6.E
                r6.setVisibility(r1)
            L_0x00d5:
                com.darsh.multipleimageselect.activities.ImageSelectActivity r6 = com.darsh.multipleimageselect.activities.ImageSelectActivity.this
                android.widget.GridView r6 = r6.F
                r6.setVisibility(r2)
                goto L_0x00e2
            L_0x00df:
                super.handleMessage(r6)
            L_0x00e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.darsh.multipleimageselect.activities.ImageSelectActivity.c.handleMessage(android.os.Message):void");
        }
    }

    class d extends ContentObserver {
        d(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            ImageSelectActivity.this.i0();
        }
    }

    class e implements ActionMode.Callback {
        e() {
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != c.c.a.b.menu_item_add_image) {
                return false;
            }
            ImageSelectActivity.this.l0();
            return true;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(c.c.a.d.menu_contextual_action_bar, menu);
            ActionMode unused = ImageSelectActivity.this.I = actionMode;
            int unused2 = ImageSelectActivity.this.J = 0;
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            if (ImageSelectActivity.this.J > 0) {
                ImageSelectActivity.this.f0();
            }
            ActionMode unused = ImageSelectActivity.this.I = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    private class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(ImageSelectActivity imageSelectActivity, a aVar) {
            this();
        }

        public void run() {
            Process.setThreadPriority(10);
            if (ImageSelectActivity.this.G == null) {
                Message obtainMessage = ImageSelectActivity.this.L.obtainMessage();
                obtainMessage.what = 2001;
                obtainMessage.sendToTarget();
            }
            if (!Thread.interrupted()) {
                HashSet hashSet = new HashSet();
                int i = 0;
                if (ImageSelectActivity.this.y != null) {
                    int size = ImageSelectActivity.this.y.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.c.a.h.b bVar = (c.c.a.h.b) ImageSelectActivity.this.y.get(i2);
                        if (new File(bVar.l).exists() && bVar.m) {
                            hashSet.add(Long.valueOf(bVar.j));
                        }
                    }
                }
                Cursor query = ImageSelectActivity.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ImageSelectActivity.this.N, "bucket_display_name =?", new String[]{ImageSelectActivity.this.z}, "date_added");
                if (query == null) {
                    Message obtainMessage2 = ImageSelectActivity.this.L.obtainMessage();
                    obtainMessage2.what = 2005;
                    obtainMessage2.sendToTarget();
                    return;
                }
                ArrayList arrayList = new ArrayList(query.getCount());
                if (query.moveToLast()) {
                    int i3 = 0;
                    while (!Thread.interrupted()) {
                        long j2 = query.getLong(query.getColumnIndex(ImageSelectActivity.this.N[0]));
                        String string = query.getString(query.getColumnIndex(ImageSelectActivity.this.N[1]));
                        String string2 = query.getString(query.getColumnIndex(ImageSelectActivity.this.N[2]));
                        boolean contains = hashSet.contains(Long.valueOf(j2));
                        if (contains) {
                            i3++;
                        }
                        if (new File(string2).exists()) {
                            arrayList.add(new c.c.a.h.b(j2, string, string2, contains));
                        }
                        if (!query.moveToPrevious()) {
                            i = i3;
                        }
                    }
                    return;
                }
                query.close();
                if (ImageSelectActivity.this.y == null) {
                    ArrayList unused = ImageSelectActivity.this.y = new ArrayList();
                }
                ImageSelectActivity.this.y.clear();
                ImageSelectActivity.this.y.addAll(arrayList);
                Message obtainMessage3 = ImageSelectActivity.this.L.obtainMessage();
                obtainMessage3.what = 2002;
                obtainMessage3.arg1 = i;
                obtainMessage3.sendToTarget();
                Thread.interrupted();
            }
        }
    }

    private void G() {
        Thread thread = this.M;
        if (thread != null && thread.isAlive()) {
            this.M.interrupt();
            try {
                this.M.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e0() {
        if (androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            k0();
            return;
        }
        Message obtainMessage = this.L.obtainMessage();
        obtainMessage.what = 2003;
        obtainMessage.sendToTarget();
    }

    /* access modifiers changed from: private */
    public void f0() {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).m = false;
        }
        this.J = 0;
        this.G.notifyDataSetChanged();
    }

    private ArrayList<c.c.a.h.b> g0() {
        ArrayList<c.c.a.h.b> arrayList = new ArrayList<>();
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            if (this.y.get(i).m) {
                arrayList.add(this.y.get(i));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void h0() {
        this.A.setVisibility(4);
        this.B.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void i0() {
        G();
        Thread thread = new Thread(new f(this, (a) null));
        this.M = thread;
        thread.start();
    }

    /* access modifiers changed from: private */
    public void j0(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        c.c.a.f.c cVar = this.G;
        int i2 = 3;
        if (cVar != null) {
            int i3 = displayMetrics.widthPixels;
            cVar.b(i == 1 ? i3 / 3 : i3 / 5);
        }
        GridView gridView = this.F;
        if (i != 1) {
            i2 = 5;
        }
        gridView.setNumColumns(i2);
    }

    /* access modifiers changed from: private */
    public void k0() {
        androidx.core.app.a.m(this, this.C, 23);
    }

    /* access modifiers changed from: private */
    public void l0() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("images", g0());
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void m0() {
        this.A.setVisibility(0);
        this.B.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void n0(int i) {
        if (this.y.get(i).m || this.J < c.c.a.g.a.f1295a) {
            this.y.get(i).m = !this.y.get(i).m;
            this.J = this.y.get(i).m ? this.J + 1 : this.J - 1;
            this.G.notifyDataSetChanged();
            return;
        }
        Toast.makeText(getApplicationContext(), String.format(getString(c.c.a.e.limit_exceeded), new Object[]{Integer.valueOf(c.c.a.g.a.f1295a)}), 0).show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j0(configuration.orientation);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.c.a.c.activity_image_select);
        D((Toolbar) findViewById(c.c.a.b.toolbar));
        androidx.appcompat.app.a x = x();
        this.H = x;
        if (x != null) {
            x.s(true);
            this.H.u(c.c.a.a.ic_arrow_back);
            this.H.t(true);
            this.H.x(c.c.a.e.image_view);
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        this.z = intent.getStringExtra("album");
        TextView textView = (TextView) findViewById(c.c.a.b.text_view_error);
        this.D = textView;
        textView.setVisibility(4);
        this.A = (TextView) findViewById(c.c.a.b.text_view_request_permission);
        Button button = (Button) findViewById(c.c.a.b.button_grant_permission);
        this.B = button;
        button.setOnClickListener(new a());
        h0();
        this.E = (ProgressBar) findViewById(c.c.a.b.progress_bar_image_select);
        GridView gridView = (GridView) findViewById(c.c.a.b.grid_view_image_select);
        this.F = gridView;
        gridView.setOnItemClickListener(new b());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.a aVar = this.H;
        if (aVar != null) {
            aVar.v((Drawable) null);
        }
        this.y = null;
        c.c.a.f.c cVar = this.G;
        if (cVar != null) {
            cVar.a();
        }
        this.F.setOnItemClickListener((AdapterView.OnItemClickListener) null);
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
            Message obtainMessage = this.L.obtainMessage();
            obtainMessage.what = (iArr.length <= 0 || iArr[0] != 0) ? 2004 : 2003;
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.L = new c();
        this.K = new d(this.L);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.K);
        e0();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        G();
        getContentResolver().unregisterContentObserver(this.K);
        this.K = null;
        Handler handler = this.L;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.L = null;
        }
    }
}
