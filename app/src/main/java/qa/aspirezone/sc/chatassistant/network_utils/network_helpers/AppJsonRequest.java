package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import android.content.Context;

import com.android.volley.VolleyLog;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequest;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequestHandler;
import qa.aspirezone.sc.chatassistant.network_utils.AppResponseListener;

import java.io.UnsupportedEncodingException;


public abstract class AppJsonRequest<T> extends AppRequest<T> {

    /**
     * Default charset for JSON request.
     */
    protected static final String PROTOCOL_CHARSET = "utf-8";

    /**
     * Content type for request.
     */
    private static final String PROTOCOL_CONTENT_TYPE =
            String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    private final String mRequestBody;
   // int method, String url, Map<String, String> params,JSONObject requestBody, AppResponseListener<T> listener, AppRequest.AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context
    public AppJsonRequest(int method, String url, AppResponseListener<T> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode) {
        super(method, url, listener, errorListener, requestCode);
        mRequestBody = null;
    }

    public AppJsonRequest(int method, String url, String requestBody, AppResponseListener<T> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode, boolean isAuthRequired, boolean isBearer, Context context) {
        super(method, url, null,listener, errorListener, requestCode,isAuthRequired,isBearer,context);
        mRequestBody = requestBody;
    }

    @Override
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override
    public byte[] getPostBody() {
        return getBody();
    }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override
    public byte[] getBody() {
        try {
            return mRequestBody == null ? null : mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf("Unsupported Encoding while trying to send the bytes of %s using %s",
                    mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }

   /* @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        Log.d(TAG,"Does it assign headers?") ;
        Map<String,String> params = new HashMap<String, String>();
        params.put("Accept", "application/json");
        params.put("Content-Type", "application/json; charset=utf-8");
        return params;

    }*/
}
