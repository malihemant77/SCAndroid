package qa.aspirezone.sc.chatassistant.models;


public class AuthResponseModel {
    /**
     * userId : 10-3IG7nhuPB7Q1
     * sessionId : Y5a0SgC40uQJRNCls3eS
     * userName : californiapsychicsqa@gmail.com
     * displayName : Test
     * bearerToken : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6InpCbSJ9.eyJzdWIiOiIxMC0zSUc3bmh1UEI3UTEiLCJpYXQiOjE1MDQ1MDkwMDUsImV4cCI6MTUwNDU5NTQwNSwiZW1haWwiOiJjYWxpZm9ybmlhcHN5Y2hpY3NxYUBnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiQ2FsaWZvcm5pYSIsImZhbWlseV9uYW1lIjoiUWEiLCJuYW1lIjoiVGVzdCJ9.KW6c-TIZz4RKGwBTsGIj2kSBPgGyt3oo6stLR0HA9sY
     * responseStatus : {}
     * meta : {"refreshToken":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6InpCbSJ9.eyJzdWIiOiIxMC0zSUc3bmh1UEI3UTEiLCJpYXQiOjE1MDQ1MDkwMDUsImV4cCI6MTUwNzEwMTAwNSwiZW1haWwiOiJjYWxpZm9ybmlhcHN5Y2hpY3NxYUBnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiQ2FsaWZvcm5pYSIsImZhbWlseV9uYW1lIjoiUWEiLCJuYW1lIjoiVGVzdCJ9.HTVI-ZDRXcZaSu5LZBcfUD_kwsaepq09iRjQPOn9NCE"}
     */

    public String userId;
    public String sessionId;
    public String userName;
    public String displayName;
    public String bearerToken;
    public ResponseStatusBean responseStatus;
    public MetaBean meta;
    public String refToken;

   /* public String userName;
    public String displayName;
    public String bearerToken;
    public String refreshToken;
    public String userId;
    public String sessionId;*/


   /* public AuthResponseModel(JSONObject jsonObject,boolean isBearerResponse){
        try {
            if(!isBearerResponse){
                this.userName = jsonObject.getString("userName");}
            this.displayName = jsonObject.getString("displayName");
            this.bearerToken = "bearer "+jsonObject.getString("bearerToken");
            this.refreshToken = "bearer "+jsonObject.getJSONObject("meta").getString("refreshToken");
            this.userId = jsonObject.getString("userId");
            this.sessionId = jsonObject.getString("sessionId");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/

    public AuthResponseModel(String userId, String displayName, String bearerToken, String refreshToken){
        this.userId = userId;
        this.bearerToken = bearerToken;
        this.refToken = refreshToken;
        this.displayName = "Hello,"+displayName;

    }


    public static class ResponseStatusBean {
    }

    public static class MetaBean {
        /**
         * refreshToken : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6InpCbSJ9.eyJzdWIiOiIxMC0zSUc3bmh1UEI3UTEiLCJpYXQiOjE1MDQ1MDkwMDUsImV4cCI6MTUwNzEwMTAwNSwiZW1haWwiOiJjYWxpZm9ybmlhcHN5Y2hpY3NxYUBnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiQ2FsaWZvcm5pYSIsImZhbWlseV9uYW1lIjoiUWEiLCJuYW1lIjoiVGVzdCJ9.HTVI-ZDRXcZaSu5LZBcfUD_kwsaepq09iRjQPOn9NCE
         */

        public String refreshToken;
    }
}
