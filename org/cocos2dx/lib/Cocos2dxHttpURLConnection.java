package org.cocos2dx.lib;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class Cocos2dxHttpURLConnection {
    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";
    private static String TAG = "Cocos2dxHttpURLConnection";

    static void addRequestHeader(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setRequestProperty(str, str2);
    }

    public static String combinCookies(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = "FALSE";
        String str3 = null;
        String str4 = null;
        String str5 = "/";
        String str6 = null;
        String str7 = str;
        for (String split : list) {
            int i = 0;
            for (String str8 : split.split(";")) {
                int indexOf = str8.indexOf("=");
                if (-1 != indexOf) {
                    String[] strArr = new String[2];
                    strArr[i] = str8.substring(i, indexOf);
                    strArr[1] = str8.substring(indexOf + 1);
                    if ("expires".equalsIgnoreCase(strArr[i].trim())) {
                        str4 = str2Seconds(strArr[1].trim());
                    } else if ("path".equalsIgnoreCase(strArr[0].trim())) {
                        str5 = strArr[1];
                    } else if ("secure".equalsIgnoreCase(strArr[0].trim())) {
                        str2 = strArr[1];
                    } else if ("domain".equalsIgnoreCase(strArr[0].trim())) {
                        str7 = strArr[1];
                    } else {
                        i = 0;
                        if (!"version".equalsIgnoreCase(strArr[0].trim()) && !"max-age".equalsIgnoreCase(strArr[0].trim())) {
                            str6 = strArr[0];
                            str3 = strArr[1];
                        }
                    }
                    i = 0;
                }
            }
            if (str7 == null) {
                str7 = "none";
            }
            sb.append(str7);
            sb.append(9);
            sb.append("FALSE");
            sb.append(9);
            sb.append(str5);
            sb.append(9);
            sb.append(str2);
            sb.append(9);
            sb.append(str4);
            sb.append("\t");
            sb.append(str6);
            sb.append("\t");
            sb.append(str3);
            sb.append(10);
        }
        return sb.toString();
    }

    static int connect(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = TAG;
            Log.e(str, "connect" + e2.toString());
            return 1;
        }
    }

    static HttpURLConnection createHttpURLConnection(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (Exception e2) {
            e2.printStackTrace();
            String str2 = TAG;
            Log.e(str2, "createHttpURLConnection:" + e2.toString());
            return null;
        }
    }

    static void disconnect(HttpURLConnection httpURLConnection) {
        httpURLConnection.disconnect();
    }

    static int getResponseCode(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = TAG;
            Log.e(str, "getResponseCode:" + e2.toString());
            return 0;
        }
    }

    static byte[] getResponseContent(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        String str;
        StringBuilder sb;
        String str2;
        try {
            inputStream = httpURLConnection.getInputStream();
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding != null) {
                if (contentEncoding.equalsIgnoreCase("gzip")) {
                    inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                } else if (contentEncoding.equalsIgnoreCase("deflate")) {
                    inputStream = new InflaterInputStream(httpURLConnection.getInputStream());
                }
            }
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            str = TAG;
            sb = new StringBuilder();
            str2 = "1 getResponseContent: ";
            sb.append(str2);
            sb.append(e.toString());
            Log.e(str, sb.toString());
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            str = TAG;
            sb = new StringBuilder();
            str2 = "2 getResponseContent:";
            sb.append(str2);
            sb.append(e.toString());
            Log.e(str, sb.toString());
            return null;
        }
    }

    static String getResponseHeaderByIdx(HttpURLConnection httpURLConnection, int i) {
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        int i2 = 0;
        for (Map.Entry entry : headerFields.entrySet()) {
            if (i2 == i) {
                String str = (String) entry.getKey();
                if (str == null) {
                    return listToString((List) entry.getValue(), ",") + "\n";
                }
                return str + ":" + listToString((List) entry.getValue(), ",") + "\n";
            }
            i2++;
        }
        return null;
    }

    static String getResponseHeaderByKey(HttpURLConnection httpURLConnection, String str) {
        Map headerFields;
        if (str == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return null;
        }
        for (Map.Entry entry : headerFields.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return "set-cookie".equalsIgnoreCase(str) ? combinCookies((List) entry.getValue(), httpURLConnection.getURL().getHost()) : listToString((List) entry.getValue(), ",");
            }
        }
        return null;
    }

    static int getResponseHeaderByKeyInt(HttpURLConnection httpURLConnection, String str) {
        String headerField = httpURLConnection.getHeaderField(str);
        if (headerField == null) {
            return 0;
        }
        return Integer.parseInt(headerField);
    }

    static String getResponseHeaders(HttpURLConnection httpURLConnection) {
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : headerFields.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2 == null) {
                str = str + listToString((List) entry.getValue(), ",") + "\n";
            } else {
                str = str + str2 + ":" + listToString((List) entry.getValue(), ",") + "\n";
            }
        }
        return str;
    }

    static String getResponseMessage(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseMessage();
        } catch (Exception e2) {
            e2.printStackTrace();
            String exc = e2.toString();
            String str = TAG;
            Log.e(str, "getResponseMessage: " + exc);
            return exc;
        }
    }

    public static String listToString(List<String> list, String str) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String next : list) {
            if (z) {
                sb.append(str);
            }
            if (next == null) {
                next = "";
            }
            sb.append(next);
            z = true;
        }
        return sb.toString();
    }

    static void sendRequest(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            if (bArr != null) {
                outputStream.write(bArr);
                outputStream.flush();
            }
            outputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = TAG;
            Log.e(str, "sendRequest:" + e2.toString());
        }
    }

    static void setReadAndConnectTimeout(HttpURLConnection httpURLConnection, int i, int i2) {
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setConnectTimeout(i2);
    }

    static void setRequestMethod(HttpURLConnection httpURLConnection, String str) {
        try {
            httpURLConnection.setRequestMethod(str);
            if (str.equalsIgnoreCase(POST_METHOD) || str.equalsIgnoreCase(PUT_METHOD)) {
                httpURLConnection.setDoOutput(true);
            }
        } catch (ProtocolException e2) {
            String str2 = TAG;
            Log.e(str2, "setRequestMethod:" + e2.toString());
        }
    }

    static void setVerifySSL(HttpURLConnection httpURLConnection, String str) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                if (str.startsWith("/")) {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                } else {
                    bufferedInputStream = new BufferedInputStream(Cocos2dxHelper.getActivity().getAssets().open(str.substring(7)));
                }
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(bufferedInputStream);
                PrintStream printStream = System.out;
                printStream.println("ca=" + ((X509Certificate) generateCertificate).getSubjectDN());
                bufferedInputStream.close();
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream) null, (char[]) null);
                instance.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                SSLContext instance3 = SSLContext.getInstance("TLS");
                instance3.init((KeyManager[]) null, instance2.getTrustManagers(), (SecureRandom) null);
                httpsURLConnection.setSSLSocketFactory(instance3.getSocketFactory());
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = TAG;
                Log.e(str2, "setVerifySSL:" + e2.toString());
            }
        }
    }

    private static String str2Seconds(String str) {
        long j;
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat("EEE, dd-MMM-yy hh:mm:ss zzz", Locale.US).parse(str));
            j = instance.getTimeInMillis() / 1000;
        } catch (ParseException e2) {
            String str2 = TAG;
            Log.e(str2, "str2Seconds: " + e2.toString());
            j = 0;
        }
        return Long.toString(j);
    }
}
