package qa.aspirezone.sc.chatassistant.models;


import java.util.List;

public class ErrorResponseModel {

    public String errorCode;
    public String message;
    public String stackTrace;
    public List<Object> errors = null;


   /* public ErrorResponseModel(JSONObject jsonObject){
        try {
            JSONObject mJsonResponse = jsonObject.getJSONObject("responseStatus");

            this.errorCode = mJsonResponse.getString("errorCode");
            this.message = mJsonResponse.getString("message");
            this.stackTrace = mJsonResponse.getString("stackTrace");
            //this.errors = jsonObject.getJSONArray("");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/




}
