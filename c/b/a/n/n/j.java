package c.b.a.n.n;

import android.text.TextUtils;
import android.util.Log;
import c.b.a.n.e;
import c.b.a.n.n.d;
import c.b.a.n.p.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class j implements d<InputStream> {
    static final b p = new a();
    private final g j;
    private final int k;
    private final b l;
    private HttpURLConnection m;
    private InputStream n;
    private volatile boolean o;

    private static class a implements b {
        a() {
        }

        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url);
    }

    public j(g gVar, int i) {
        this(gVar, i, p);
    }

    j(g gVar, int i, b bVar) {
        this.j = gVar;
        this.k = i;
        this.l = bVar;
    }

    private InputStream e(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = c.b.a.t.b.f(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.n = inputStream;
        return this.n;
    }

    private static boolean f(int i) {
        return i / 100 == 2;
    }

    private static boolean g(int i) {
        return i / 100 == 3;
    }

    private InputStream h(URL url, int i, URL url2, Map<String, String> map) {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.m = this.l.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.m.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.m.setConnectTimeout(this.k);
            this.m.setReadTimeout(this.k);
            this.m.setUseCaches(false);
            this.m.setDoInput(true);
            this.m.setInstanceFollowRedirects(false);
            this.m.connect();
            this.n = this.m.getInputStream();
            if (this.o) {
                return null;
            }
            int responseCode = this.m.getResponseCode();
            if (f(responseCode)) {
                return e(this.m);
            }
            if (g(responseCode)) {
                String headerField = this.m.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i + 1, url, map);
                }
                throw new e("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new e(responseCode);
            } else {
                throw new e(this.m.getResponseMessage(), responseCode);
            }
        } else {
            throw new e("Too many (> 5) redirects!");
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.m = null;
    }

    public c.b.a.n.a c() {
        return c.b.a.n.a.REMOTE;
    }

    public void cancel() {
        this.o = true;
    }

    public void d(c.b.a.g gVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long b2 = c.b.a.t.d.b();
        try {
            aVar.h(h(this.j.h(), 0, (URL) null, this.j.e()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(c.b.a.t.d.a(b2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            aVar.g(e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + c.b.a.t.d.a(b2));
            }
            throw th;
        }
    }
}
