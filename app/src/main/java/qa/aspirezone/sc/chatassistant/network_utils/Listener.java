package qa.aspirezone.sc.chatassistant.network_utils;
import com.android.volley.VolleyError;

public interface Listener<T> {
        void onSuccess(T response);

        void onFailure(int statusCode, VolleyError error);
    }