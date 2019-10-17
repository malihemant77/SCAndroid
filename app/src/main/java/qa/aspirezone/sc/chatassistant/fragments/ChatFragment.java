package qa.aspirezone.sc.chatassistant.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.java_websocket.client.DefaultSSLWebSocketClientFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import javax.net.ssl.SSLContext;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import qa.aspirezone.sc.chatassistant.R;
import qa.aspirezone.sc.chatassistant.models.request.StartConversastionRequestModel;
import qa.aspirezone.sc.chatassistant.models.response.StartConversastionResponseModel;
import qa.aspirezone.sc.chatassistant.network_utils.Listener;
import qa.aspirezone.sc.chatassistant.requests.GetConversastionRequest;

public class ChatFragment extends Fragment implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener {
    private WebSocketClient mWebSocketClient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


    /*     mToolbar = v.findViewById(R.id.toolbar_chat);
        if (mToolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        }
        mToolbar.setTitle(null);*/
//        init(v);

        getToken();

        return v;
    }
    private void connectWebSocket(StartConversastionResponseModel response) {
        final String url = response.streamUrl;
        URI uri=null;
        try{
            uri = new URI(url);
        }
        catch (URISyntaxException e)
        {
            Log.e("URISyntaxException", e.getMessage());
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                mWebSocketClient.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     //   TextView textView = (TextView)getActivity().findViewById(R.id.messages);
                       /// textView.setText(textView.getText() + "\n" + message);
                        Log.d("message",""+message);
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        if (url.indexOf("wss") == 0) {
            try {
                SSLContext sslContext = SSLContext.getDefault();
                mWebSocketClient.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sslContext));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mWebSocketClient.connect();
    }

    public void getToken(){
        final String token="Bearer roq9p2kHaU4.00j_Ac9c6jG9qWpQydG0OpUM7riJGxNl1zScHBeyIss";
        StartConversastionRequestModel psychicBioRequestModel = new StartConversastionRequestModel(token);

        GetConversastionRequest.send(getContext(), psychicBioRequestModel, new Listener<StartConversastionResponseModel>() {
            @Override
            public void onSuccess(StartConversastionResponseModel response) {
                Log.e("conversationId",""+response.conversationId);
                Log.e("streamUrl",""+response.streamUrl);
                try {
                    connectWebSocket(response);
//                    responses = response;
//                    progressBarHandler.hide();
//                    if(initFromServer(v,response))
//                    {
//                        //  fetchDataFromServer(responses) ;
//                        //  Toast.makeText(context,"Server Response Success",Toast.LENGTH_SHORT).show();
//                        ll.setVisibility(LinearLayout.GONE);
//                        setStatus();
//                    }
//                    else
//                    {
//                        //  progressBarHandler.hide();
//                        //  Toast.makeText(context,"List Response fail",Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(context, BaseActivity.class);
//                        getActivity().startActivity(intent);
//
//                    }
//                    //    setResponseData();
//
//                    //  chatButton.setOnClickListener(obj);
//                    //  callButton.setOnClickListener(obj);
//
//                    // mProgressDialogFragment.dismiss();
//                    showFavButton();
//
//                    //  getPsychicStatusHandler.getGetPsychicStatus();
//
//                    statusBean=getPsychicStatusHandler.getStatusBean();
                    // mProgressDialogFragment.dismiss();
                }catch (Exception e){
                    Log.e("Exception isFavorite",""+e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, VolleyError error) {
//                progressBarHandler.hide();
                //mProgressDialogFragment.dismiss();
                //progressBar.setVisibility(ProgressBar.GONE);
                //  Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                getActivity().finish();

            }
        });
    }
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {

    }
}
