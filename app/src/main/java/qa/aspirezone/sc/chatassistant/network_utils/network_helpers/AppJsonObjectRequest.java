package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import qa.aspirezone.sc.chatassistant.activities.LoginActivity;
import qa.aspirezone.sc.chatassistant.models.AuthResponseModel;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequestHandler;
import qa.aspirezone.sc.chatassistant.network_utils.AppResponseListener;
import qa.aspirezone.sc.chatassistant.network_utils.Listener;
import qa.aspirezone.sc.chatassistant.network_utils.VolleyHelper;
import qa.aspirezone.sc.chatassistant.requests.RefreshTokenRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class AppJsonObjectRequest extends AppJsonRequest<JSONObject> {
    public static AppJsonObjectRequest request;

    public AppJsonObjectRequest(int method, String url, AppResponseListener<JSONObject> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode) {
        super(method, url, listener, errorListener, requestCode);
    }

    public AppJsonObjectRequest(int method, String url, JSONObject jsonRequest, AppResponseListener<JSONObject> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context) {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener, errorListener, requestCode,isAuthRequired,isBearer,context);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return super.getParams();
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
    public static void get(int requestType, String url, JSONObject requestBody, final Listener<JSONObject> responseCallback, final Context context, boolean isAuthRequired, boolean isBearer) {
        Log.e("url", url);
        Log.e("requestBody", requestBody.toString());
        request = new AppJsonObjectRequest(
                requestType,
                url,requestBody,new AppResponseListener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response, int requestCode) {

               // Log.e("get response",""+response);
           //     Log.e("get response",""+response);
                responseCallback.onSuccess(response);
            }

        }, new AppRequestHandler.AppErrorListener() {
            @Override
            public void onError(int requestCode, int statusCode, VolleyError error) {


                if (statusCode == 401){

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

                }else{

                    responseCallback.onFailure(statusCode,error);
                }



            }
        }, 0,isAuthRequired,isBearer,context

        );
      //  request.setParams(params);
        // mRequest = request;

        request.setRetryPolicy(new DefaultRetryPolicy(
                300000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleyHelper.getInstance(context).addToRequestQueue(request);

    }
     @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        //Log.d(TAG,"Does it assign headers?") ;
        Map<String,String> params = new HashMap<String, String>();
        params.put("Accept", "application/json");
        params.put("Content-Type", "application/json; charset=utf-8");
         params.put("Authorization", "Bearer roq9p2kHaU4.00j_Ac9c6jG9qWpQydG0OpUM7riJGxNl1zScHBeyIss");
        return params;

    }
}
