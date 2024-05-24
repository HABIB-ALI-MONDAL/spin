package c.e.a.a;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static b a(File file) {
        Map<String, String> b2 = b(file);
        if (b2 == null) {
            return null;
        }
        b2.remove("channel");
        return new b(b2.get("channel"), b2);
    }

    public static Map<String, String> b(File file) {
        try {
            String c2 = c(file);
            if (c2 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c2);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return e.d(file, 1903654775);
    }
}
