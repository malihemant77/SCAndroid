package qa.aspirezone.sc.chatassistant.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import qa.aspirezone.sc.chatassistant.models.AuthResponseModel;

public class AppPreferences {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String TAG = AppPreferences.class.getSimpleName(),
            TAG_BEARER_TOKEN = TAG + ".TAG_BEARER_TOKEN",
            TAG_REFRESH_TOKEN = TAG + ".TAG_REFRESH_TOKEN",
            TAG_USER_ID = TAG + ".TAG_USER_ID",
            TAG_DISPLAY_NAME= TAG + ".TAG_DISPLAY_NAME",
            TAG_CHAT_TOKEN = TAG + ".TAG_CHAT_TOKEN";



    public static void saveTokens(AuthResponseModel authResponseModel, Context context){
         sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
         editor = sharedPreferences.edit();
        editor.putString(TAG_USER_ID,authResponseModel.userId);
        editor.putString(TAG_DISPLAY_NAME,authResponseModel.displayName);
        editor.putString(TAG_BEARER_TOKEN,"bearer " +authResponseModel.bearerToken);
        editor.putString(TAG_REFRESH_TOKEN,"bearer " +authResponseModel.meta.refreshToken);
        editor.apply();

    }

    public static AuthResponseModel getTokens(Context context){
        sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return  new AuthResponseModel(sharedPreferences.getString(TAG_USER_ID,""),sharedPreferences.getString(TAG_DISPLAY_NAME,""),
                sharedPreferences.getString(TAG_BEARER_TOKEN,""),sharedPreferences.getString(TAG_REFRESH_TOKEN,""));

    }


    public static void saveChatToken(String token, Context context){
        sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(TAG_CHAT_TOKEN,token);
        editor.apply();
    }


    public static String getChatToken(Context context){
        sharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_REFRESH_TOKEN,"");
    }
    public static void Clear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
