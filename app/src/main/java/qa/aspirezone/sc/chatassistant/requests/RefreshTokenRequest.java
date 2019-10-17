package qa.aspirezone.sc.chatassistant.requests;

import android.content.Context;
import android.content.Intent;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import qa.aspirezone.sc.chatassistant.activities.LoginActivity;
import qa.aspirezone.sc.chatassistant.models.AuthResponseModel;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequest;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequestHandler;
import qa.aspirezone.sc.chatassistant.network_utils.AppResponseListener;
import qa.aspirezone.sc.chatassistant.network_utils.Listener;
import qa.aspirezone.sc.chatassistant.network_utils.UrlUtils;
import qa.aspirezone.sc.chatassistant.network_utils.VolleyHelper;
import qa.aspirezone.sc.chatassistant.preferences.AppPreferences;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RefreshTokenRequest extends AppRequestHandler<String> {
    public RefreshTokenRequest(int method, String url, Map<String, String> params, AppResponseListener<String> listener, AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context) {
        super(method, url, params, null,listener, errorListener, requestCode, isAuthRequired, isBearer, context);
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

    public static void get(final Context context, final Listener<AuthResponseModel> callback) {

        Map<String, String> params = new HashMap<>();
        RefreshTokenRequest request = new RefreshTokenRequest(
                Request.Method.POST,
                UrlUtils.AUTHENTICATION,params,new AppResponseListener<String>() {
            @Override
            public void onResponse(String response, int requestCode) {
                AuthResponseModel authResponseModel = null;
                Gson gson = new Gson();
                authResponseModel = gson.fromJson(response, AuthResponseModel.class);
                AppPreferences.saveTokens(authResponseModel,context);
                callback.onSuccess(authResponseModel);
            }


        }, new AppErrorListener() {
            @Override
            public void onError(int requestCode, int statusCode, VolleyError error) {
                Intent intent = new Intent(context,LoginActivity.class);
                context.startActivity(intent);
            }
        }, 0,false,true,context
        );
        VolleyHelper.getInstance(context).addToRequestQueue(request);
    }

}



