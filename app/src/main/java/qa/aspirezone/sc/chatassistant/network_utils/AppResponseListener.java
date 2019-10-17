package qa.aspirezone.sc.chatassistant.network_utils;

public interface AppResponseListener<T> {
    void onResponse(T response, int requestCode);
}