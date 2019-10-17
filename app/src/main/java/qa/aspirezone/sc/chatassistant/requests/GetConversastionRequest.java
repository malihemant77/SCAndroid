package qa.aspirezone.sc.chatassistant.requests;//package com.outlookamusements.psychicapp.models;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;


import org.json.JSONObject;

import qa.aspirezone.sc.chatassistant.models.request.StartConversastionRequestModel;
import qa.aspirezone.sc.chatassistant.models.response.StartConversastionResponseModel;
import qa.aspirezone.sc.chatassistant.network_utils.Listener;
import qa.aspirezone.sc.chatassistant.network_utils.UrlUtils;
import qa.aspirezone.sc.chatassistant.network_utils.network_helpers.AppJsonObjectRequest;
import qa.aspirezone.sc.chatassistant.network_utils.network_helpers.JsonResponseHandler;

/**
 * Created by PSinha on 9/1/2017.
 */

public class GetConversastionRequest {

public static void send(final Context context, StartConversastionRequestModel getPsychicStatusRequestModel, final Listener<StartConversastionResponseModel> callback ) {

        Gson gson = new Gson();
        String json = gson.toJson(getPsychicStatusRequestModel);
        //   Log.d("json",""+json);
        JSONObject jsonObject = new JsonResponseHandler(json).getJSON();
        Log.d("jsonObject",""+jsonObject);
        //Log.d("PSYCHIC_STATUs",""+UrlUtils.PSYCHIC_STATUS_PATH_DETAIL);
        //  Log.d("jsonObject",""+jsonObject);
        // Log.d("PSYCHIC_STATUs",""+UrlUtils.PSYCHIC_STATUS_PATH_DETAIL);

        AppJsonObjectRequest.get(Request.Method.POST, UrlUtils.GET_CONVERSASTION_DETAIL, jsonObject, new Listener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                //  Log.e("response",""+response);
                StartConversastionResponseModel psychicBioResponseModel;
                Gson gson = new Gson();
                psychicBioResponseModel = gson.fromJson(response.toString(), StartConversastionResponseModel.class);
                callback.onSuccess(psychicBioResponseModel);
            }

            @Override
            public void onFailure(int statusCode, VolleyError error) {
                callback.onFailure(statusCode, error);
            }

        }, context, true, false);
    }
}
