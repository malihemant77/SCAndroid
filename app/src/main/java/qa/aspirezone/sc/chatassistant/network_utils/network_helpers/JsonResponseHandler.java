package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonResponseHandler {

    Object objects;
    
    public JsonResponseHandler(Object response) {
          this.objects = response;
        
    }
    
    public JSONObject getJSON(){


        JSONObject object = null;
        try {
            object = new JSONObject((String) objects);
        } catch (JSONException e) {
            e.printStackTrace();
           
        }
        return object;
    }
    public JSONArray getJsonArray(){


        JSONArray object = null;
        try {
            object = new JSONArray((String) objects);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return object;
    }

    
}
