package qa.aspirezone.sc.chatassistant.network_utils;

import android.content.Context;
import android.content.Intent;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
//import com.outlookamusements.psychicapp.activities.LoginActivity;
//import com.outlookamusements.psychicapp.models.AuthResponseModel;
//import com.outlookamusements.psychicapp.requests.RefreshTokenRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class AppRequestHandler<T> extends AppRequest<String> {

    private Map<String, String> mParams;

    public static AppRequestHandler request;
    public JSONObject requestBody;




    public AppRequestHandler(int method, String url, Map<String, String> params, JSONObject requestBody , AppResponseListener<String> listener, AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context) {
        super(method, url,params,listener, errorListener,requestCode,isAuthRequired,isBearer,context);
         // mParams = params;
        this.requestBody = requestBody;

    }
    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            return requestBody == null ? null : requestBody.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getBodyContentType() {
        return "application/json";
    }


    public void addParam(String key, String value) {
        mParams.put(key, value);
    }

    /*@Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }*/

    public void setParams(Map<String, String> params){

        mParams = params;
    }




    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String string = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(string,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    public static void get(final Context context, int requestType, String url, Map<String, String> params, JSONObject requestBody, final Listener<String> responseCallback, boolean isAuthRequired, boolean isBearer) {
        request = new AppRequestHandler(
                requestType,
                url,params,requestBody,new AppResponseListener<String>() {
            @Override
            public void onResponse(String response, int requestCode) {
                        responseCallback.onSuccess(response);
            }

        }, new AppErrorListener() {
            @Override
            public void onError(int requestCode, int statusCode, VolleyError error) {


                if (statusCode == 401){
/*
                    RefreshTokenRequest.get(context, new Listener<AuthResponseModel>() {
                        @Override
                        public void onSuccess(AuthResponseModel response) {
                            VolleyHelper.getInstance(context).addToRequestQueue(request);
                            //Log.d("Response", response.sessionId);
                        }

                        @Override
                        public void onFailure(int statusCode, VolleyError error) {
                            Intent intent = new Intent(context,LoginActivity.class);
                            context.startActivity(intent);
                           // responseCallback.onFailure(statusCode,error);
                        }
                    });
*/
                }else{

                    responseCallback.onFailure(statusCode,error);
                }



            }
        }, 0,isAuthRequired,isBearer,context

        );
        request.setParams(params);
       // mRequest = request;

        request.setRetryPolicy(new DefaultRetryPolicy(
                300000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleyHelper.getInstance(context).addToRequestQueue(request);

    }




}
