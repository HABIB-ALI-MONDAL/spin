package org.cocos2dx.okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.Call;
import org.cocos2dx.okhttp3.EventListener;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.WebSocket;
import org.cocos2dx.okhttp3.internal.Internal;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.cache.InternalCache;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.RouteDatabase;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okhttp3.internal.proxy.NullProxySelector;
import org.cocos2dx.okhttp3.internal.tls.CertificateChainCleaner;
import org.cocos2dx.okhttp3.internal.tls.OkHostnameVerifier;
import org.cocos2dx.okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    final Authenticator authenticator;
    @Nullable
    final Cache cache;
    final int callTimeout;
    final CertificateChainCleaner certificateChainCleaner;
    final CertificatePinner certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<ConnectionSpec> connectionSpecs;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    @Nullable
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;
    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;

    public static final class Builder {
        Authenticator authenticator;
        @Nullable
        Cache cache;
        int callTimeout;
        @Nullable
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        @Nullable
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        @Nullable
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        @Nullable
        SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            ProxySelector proxySelector2 = ProxySelector.getDefault();
            this.proxySelector = proxySelector2;
            if (proxySelector2 == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            Authenticator authenticator2 = Authenticator.NONE;
            this.proxyAuthenticator = authenticator2;
            this.authenticator = authenticator2;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        Builder(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.interceptors = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.networkInterceptors = arrayList2;
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.callTimeout = okHttpClient.callTimeout;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(Authenticator authenticator2) {
            Objects.requireNonNull(authenticator2, "authenticator == null");
            this.authenticator = authenticator2;
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(@Nullable Cache cache2) {
            this.cache = cache2;
            this.internalCache = null;
            return this;
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.callTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder callTimeout(Duration duration) {
            this.callTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner2) {
            Objects.requireNonNull(certificatePinner2, "certificatePinner == null");
            this.certificatePinner = certificatePinner2;
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder connectTimeout(Duration duration) {
            this.connectTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool2) {
            Objects.requireNonNull(connectionPool2, "connectionPool == null");
            this.connectionPool = connectionPool2;
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            Objects.requireNonNull(cookieJar2, "cookieJar == null");
            this.cookieJar = cookieJar2;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher2) {
            if (dispatcher2 != null) {
                this.dispatcher = dispatcher2;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns dns2) {
            Objects.requireNonNull(dns2, "dns == null");
            this.dns = dns2;
            return this;
        }

        public Builder eventListener(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.eventListenerFactory = EventListener.factory(eventListener);
            return this;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            Objects.requireNonNull(factory, "eventListenerFactory == null");
            this.eventListenerFactory = factory;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            Objects.requireNonNull(hostnameVerifier2, "hostnameVerifier == null");
            this.hostnameVerifier = hostnameVerifier2;
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder pingInterval(Duration duration) {
            this.pingInterval = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder proxy(@Nullable Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator2) {
            Objects.requireNonNull(authenticator2, "proxyAuthenticator == null");
            this.proxyAuthenticator = authenticator2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            Objects.requireNonNull(proxySelector2, "proxySelector == null");
            this.proxySelector = proxySelector2;
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder readTimeout(Duration duration) {
            this.readTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(@Nullable InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory socketFactory2) {
            Objects.requireNonNull(socketFactory2, "socketFactory == null");
            this.socketFactory = socketFactory2;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder writeTimeout(Duration duration) {
            this.writeTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    class a extends Internal {
        a() {
        }

        public void addLenient(Headers.Builder builder, String str) {
            builder.addLenient(str);
        }

        public void addLenient(Headers.Builder builder, String str, String str2) {
            builder.addLenient(str, str2);
        }

        public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            connectionSpec.apply(sSLSocket, z);
        }

        public int code(Response.Builder builder) {
            return builder.code;
        }

        public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
            return connectionPool.connectionBecameIdle(realConnection);
        }

        public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            return connectionPool.deduplicate(address, streamAllocation);
        }

        public boolean equalsNonHost(Address address, Address address2) {
            return address.equalsNonHost(address2);
        }

        public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
            return connectionPool.get(address, streamAllocation, route);
        }

        public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
            return illegalArgumentException.getMessage().startsWith("Invalid URL host");
        }

        public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
            return a.g(okHttpClient, request, true);
        }

        public void put(ConnectionPool connectionPool, RealConnection realConnection) {
            connectionPool.put(realConnection);
        }

        public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
            return connectionPool.routeDatabase;
        }

        public void setCache(Builder builder, InternalCache internalCache) {
            builder.setInternalCache(internalCache);
        }

        public StreamAllocation streamAllocation(Call call) {
            return ((a) call).j();
        }

        @Nullable
        public IOException timeoutExit(Call call, @Nullable IOException iOException) {
            return ((a) call).k(iOException);
        }
    }

    static {
        Internal.instance = new a();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        CertificateChainCleaner certificateChainCleaner2;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        List<ConnectionSpec> list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        Iterator<ConnectionSpec> it = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.isTls()) {
                    z = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = builder.sslSocketFactory;
        if (sSLSocketFactory != null || !z) {
            this.sslSocketFactory = sSLSocketFactory;
            certificateChainCleaner2 = builder.certificateChainCleaner;
        } else {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.sslSocketFactory = newSslSocketFactory(platformTrustManager);
            certificateChainCleaner2 = CertificateChainCleaner.get(platformTrustManager);
        }
        this.certificateChainCleaner = certificateChainCleaner2;
        if (this.sslSocketFactory != null) {
            Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (this.interceptors.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        } else if (this.networkInterceptors.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw Util.assertionError("No System TLS", e2);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public Cache cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    /* access modifiers changed from: package-private */
    public InternalCache internalCache() {
        Cache cache2 = this.cache;
        return cache2 != null ? cache2.internalCache : this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Call newCall(Request request) {
        return a.g(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }
}
