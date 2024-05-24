package b.g.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final h<?> f698a;

    private g(h<?> hVar) {
        this.f698a = hVar;
    }

    public static g b(h<?> hVar) {
        return new g(hVar);
    }

    public void a(d dVar) {
        h<?> hVar = this.f698a;
        hVar.f702d.m(hVar, hVar, dVar);
    }

    public void c() {
        this.f698a.f702d.u();
    }

    public void d(Configuration configuration) {
        this.f698a.f702d.v(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f698a.f702d.w(menuItem);
    }

    public void f() {
        this.f698a.f702d.x();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f698a.f702d.y(menu, menuInflater);
    }

    public void h() {
        this.f698a.f702d.z();
    }

    public void i() {
        this.f698a.f702d.B();
    }

    public void j(boolean z) {
        this.f698a.f702d.C(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.f698a.f702d.R(menuItem);
    }

    public void l(Menu menu) {
        this.f698a.f702d.S(menu);
    }

    public void m() {
        this.f698a.f702d.T();
    }

    public void n(boolean z) {
        this.f698a.f702d.U(z);
    }

    public boolean o(Menu menu) {
        return this.f698a.f702d.V(menu);
    }

    public void p() {
        this.f698a.f702d.W();
    }

    public void q() {
        this.f698a.f702d.X();
    }

    public void r() {
        this.f698a.f702d.Z();
    }

    public boolean s() {
        return this.f698a.f702d.f0();
    }

    public d t(String str) {
        return this.f698a.f702d.k0(str);
    }

    public i u() {
        return this.f698a.f();
    }

    public void v() {
        this.f698a.f702d.H0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f698a.f702d.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable, k kVar) {
        this.f698a.f702d.Q0(parcelable, kVar);
    }

    public k y() {
        return this.f698a.f702d.R0();
    }

    public Parcelable z() {
        return this.f698a.f702d.T0();
    }
}
