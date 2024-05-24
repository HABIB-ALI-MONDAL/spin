package c.d.a.a.i.a0.j;

import android.database.sqlite.SQLiteDatabase;
import c.d.a.a.i.a0.j.t0;

public final /* synthetic */ class a0 implements t0.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a0 f1323a = new a0();

    private /* synthetic */ a0() {
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
