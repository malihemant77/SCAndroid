package qa.aspirezone.sc.chatassistant.network_utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
//import com.iquip.dprandroid.preferences.AppPreferences;

import java.util.HashMap;
import java.util.Map;

import qa.aspirezone.sc.chatassistant.preferences.AppPreferences;

import static com.android.volley.VolleyLog.TAG;


public abstract class AppRequest<T> extends Request<T> {

    public static final int
            ERROR_UNKNOWN = -1;

    private Map<String, String> mHeaders;
    private Map<String, String> mParams;

    private AppResponseListener<T> mListener;
    private AppRequestHandler.AppErrorListener mErrorListener;
    private boolean isAuthRequired;
    private boolean isBearer;
    private Context context;
    private int mRequestCode;
    private VolleyError volleyError;

    public AppRequest(int method, String url, Map<String, String> params, AppResponseListener<T> listener, AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context) {
        super(method, url, null);
        mListener = listener;
        mErrorListener = errorListener;
        mHeaders = new HashMap<>();
        mParams = params;
        mRequestCode = requestCode;
        this.isAuthRequired = isAuthRequired;
        this.isBearer = isBearer;
        this.context = context;
    }
    public AppRequest(int method, String url, AppResponseListener<T> listener, AppErrorListener errorListener, int requestCode) {
        super(method, url, null);
        mListener = listener;
        mErrorListener = errorListener;
        mHeaders = new HashMap<>();
        mRequestCode = requestCode;

    }



    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        Log.d(TAG,"Does it assign headers?") ;
        Map<String, String> params = new HashMap<String, String>();
        params.put("Accept", "application/json");
        params.put("Content-Type", "application/json; charset=utf-8");
        if(isAuthRequired){
            String sss = AppPreferences.getTokens(context).bearerToken;
            Log.d("sss",sss);
            params.put("Authorization", AppPreferences.getTokens(context).bearerToken);
           // params.put("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6InpCbSJ9.eyJzdWIiOiIxMC0zSUc3bmh1UEI3UTEiLCJpYXQiOjE1MDQ5NDI4NDIsImV4cCI6MTUwNTAyOTI0MiwiZW1haWwiOiJjYWxpZm9ybmlhcHN5Y2hpY3NxYUBnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiY2FsaWZvcm5pYXBzeWNoaWNzIiwiZmFtaWx5X25hbWUiOiJxYSIsIm5hbWUiOiJUZXN0In0.1YdVJllKSQOYZ7fr_AzOHIHPv7ZmpcmYxlCJTmj6ftw");
        }

        if (isBearer){

            String s = AppPreferences.getTokens(context).refToken;
            Log.d("ss",s);
           // params.put("Authorization", "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6InpCbSJ9.eyJzdWIiOiIxMC0zSUc3bmh1UEI3UTEiLCJpYXQiOjE1MDQ5NDI4NDIsImV4cCI6MTUwNzUzNDg0MiwiZW1haWwiOiJjYWxpZm9ybmlhcHN5Y2hpY3NxYUBnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiY2FsaWZvcm5pYXBzeWNoaWNzIiwiZmFtaWx5X25hbWUiOiJxYSIsIm5hbWUiOiJUZXN0In0.FOz_ID7AFkaVsvwTx9t_A8vflQ9twRgzmrVdbquQkIU");
            params.put("Authorization",AppPreferences.getTokens(context).refToken);
        }


        return params;

    }

    public void addHeader(String key, String value) {
        mHeaders.put(key, value);
    }

    @Override
    protected void deliverResponse(T response) {
        if (mListener != null) {
            mListener.onResponse(response, mRequestCode);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        try {
            if (mErrorListener != null) {

                if(error!=null){

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    mErrorListener.onError(mRequestCode,error.networkResponse.statusCode, error);
                } else if (error instanceof AuthFailureError) {
                    mErrorListener.onError(mRequestCode,error.networkResponse.statusCode, error);
                } else if (error instanceof ServerError) {
                    mErrorListener.onError(mRequestCode,error.networkResponse.statusCode, error);
                    //TODO
                } else if (error instanceof NetworkError) {

                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
                    }
                //else{*/

        /*        try {
                    *//*JsonResponseHandler jsonResponseHandler = new JsonResponseHandler(error.getMessage());
                    ErrorResponseModel errorResponseModel = new ErrorResponseModel(jsonResponseHandler.getJSON());
                    mErrorListener.onError(mRequestCode, error.networkResponse.statusCode, errorResponseModel);*//*

                } catch (NullPointerException e) {
                   // JsonResponseHandler jsonResponseHandler = new JsonResponseHandler(error.getMessage());
                  //  ErrorResponseModel errorResponseModel = new ErrorResponseModel(jsonResponseHandler.getJSON());
                   // mErrorListener.onError(mRequestCode, ERROR_UNKNOWN, errorResponseModel);
                }*/
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       // }
    }
//    @Override
//    protected VolleyError parseNetworkError(VolleyError volleyError){
//        if(volleyError.networkResponse != null && volleyError.networkResponse.data != null){
//                 volleyError = new VolleyError(new String(volleyError.networkResponse.data));
//        }
//        this.volleyError = volleyError;
//        return volleyError;
//    }

    public interface AppErrorListener {
        void onError(int requestCode, int statusCode, VolleyError error);
    }
}
