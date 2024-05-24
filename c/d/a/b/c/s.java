package c.d.a.b.c;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f1537a;

    /* renamed from: b  reason: collision with root package name */
    private final i f1538b;

    s(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f1537a = new Messenger(iBinder);
            this.f1538b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f1538b = new i(iBinder);
            this.f1537a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        Messenger messenger = this.f1537a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        i iVar = this.f1538b;
        if (iVar != null) {
            iVar.b(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
