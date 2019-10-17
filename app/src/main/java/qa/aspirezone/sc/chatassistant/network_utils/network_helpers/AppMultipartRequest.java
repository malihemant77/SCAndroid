package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import android.net.Uri;

import com.android.volley.AuthFailureError;
import qa.aspirezone.sc.chatassistant.network_utils.AppRequestHandler;
import qa.aspirezone.sc.chatassistant.network_utils.AppResponseListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppMultipartRequest extends AppJsonObjectRequest {

    private HashMap<String, List<Uri>> mFiles;
    private Map<String, String> mParams;

    public AppMultipartRequest(int method, String url, AppResponseListener<JSONObject> listener, AppRequestHandler.AppErrorListener errorListener, int requestCode) {
        super(method, url, listener, errorListener, requestCode);
        mFiles = new HashMap<>();
        mParams = new HashMap<String, String>();
    }

    public Map<String, List<Uri>> getFiles(){
        return mFiles;
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    public void addParam(String key, String value) {
        mParams.put(key, value);
    }

    public void addFile(String key, Uri value){
        List<Uri> uris = mFiles.get(key);
        if(uris==null){
            uris = new ArrayList<>();
        }
        uris.add(value);
        mFiles.put(key,uris);
    }
}
