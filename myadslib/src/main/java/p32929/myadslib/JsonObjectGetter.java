package p32929.myadslib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonObjectGetter extends AsyncTask<Void, Void, MyAd[]> {

    String TAG = getClass().getSimpleName();

    Context context;
    String jsonUrl;
    JsonObjectGetListener listener;

    public JsonObjectGetter(Context context, String jsonUrl, JsonObjectGetListener listener) {
        this.context = context;
        this.jsonUrl = jsonUrl;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (context == null || listener == null || jsonUrl == null) {
            Log.d(TAG, "onPreExecute: context == null || listener == null || jsonUrl == null");
            cancel(true);
        } else if (!isNetworkAvailable(context)) {
            listener.onError("Please check your network connection");
            cancel(true);
        } else if (jsonUrl.isEmpty()) {
            listener.onError("Please provide a valid JSON URL");
            cancel(true);
        }
    }

    @Override
    protected MyAd[] doInBackground(Void... voids) {
        try {
            URL url = new URL(jsonUrl);
            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            MyAd myAd[] = new MyAd[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                myAd[i] = new MyAd(
                        object.getString("appIconStr"),
                        object.getString("appDescription"),
                        object.getString("url")
                );
            }
            return myAd;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(MyAd[] myAds) {
        super.onPostExecute(myAds);
        if (listener != null && myAds != null) {
            listener.onSuccess(myAds);
        } else {
            listener.onError("Unknown error");
        }
    }

    private boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
