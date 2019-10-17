package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import android.net.Uri;

//import com.iquip.dprandroid.network_utils.AppRequestHandler;
//import com.iquip.dprandroid.network_utils.AppResponseListener;

import org.json.JSONObject;

import qa.aspirezone.sc.chatassistant.network_utils.AppRequestHandler;
import qa.aspirezone.sc.chatassistant.network_utils.AppResponseListener;


public class AppBinaryRequest extends AppJsonObjectRequest {
    private Uri uri;

    public AppBinaryRequest(int method, String url, AppResponseListener<JSONObject> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode) {
        super(method, url, listener, errorListener, requestCode);
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
