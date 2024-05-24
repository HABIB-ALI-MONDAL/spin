package b.d.k.y;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {
    private final int j;
    private final b k;
    private final int l;

    public a(int i, b bVar, int i2) {
        this.j = i;
        this.k = bVar;
        this.l = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.j);
        this.k.F(this.l, bundle);
    }
}
