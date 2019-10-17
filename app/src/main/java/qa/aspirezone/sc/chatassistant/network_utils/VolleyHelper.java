package qa.aspirezone.sc.chatassistant.network_utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import qa.aspirezone.sc.chatassistant.network_utils.network_helpers.MultipartStack;
//import com.iquip.dprandroid.network_utils.network_helpers.MultipartStack;

public class VolleyHelper {

    private static VolleyHelper sVolleySingleton;
    private RequestQueue mRequestQueue;
    private static Context mAppContext;

    private VolleyHelper(Context appContext) {

        mAppContext = appContext;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized VolleyHelper getInstance(Context context) {
        if (sVolleySingleton == null) {
            sVolleySingleton = new VolleyHelper(context.getApplicationContext());
        }
        return sVolleySingleton;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            //mRequestQueue = Volley.newRequestQueue(mAppContext);
            mRequestQueue = Volley.newRequestQueue(mAppContext, new MultipartStack());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
//       if(isNetworkAvailable()){
//        getRequestQueue().add(req);
//       }else{
//
//           Toast.makeText(mAppContext,"No internet connection",Toast.LENGTH_LONG).show();
//       }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mAppContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

 }
