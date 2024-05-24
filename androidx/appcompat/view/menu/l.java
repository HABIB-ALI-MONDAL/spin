package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.k;
import b.d.k.b;

class l extends k {

    class a extends k.a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        b.C0028b f167d;

        public a(l lVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean b() {
            return this.f163b.isVisible();
        }

        public View d(MenuItem menuItem) {
            return this.f163b.onCreateActionView(menuItem);
        }

        public boolean g() {
            return this.f163b.overridesItemVisibility();
        }

        public void j(b.C0028b bVar) {
            this.f167d = bVar;
            this.f163b.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.C0028b bVar = this.f167d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }
    }

    l(Context context, b.d.f.a.b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: package-private */
    public k.a h(ActionProvider actionProvider) {
        return new a(this, this.f142b, actionProvider);
    }
}
