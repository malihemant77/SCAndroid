package qa.aspirezone.sc.chatassistant.customs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;


//import com.iquip.dprandroid.adapters.AlertListAdapter;

import java.util.List;

import qa.aspirezone.sc.chatassistant.adapters.AlertListAdapter;

public class AppDialog {

    Activity activity;
    List<String> buttons;
    Dialog settingsDialog;
    String mTitle;
    String mBody;
    OnButtonItemClick callBack;


   public AppDialog(Activity activity, List<String> buttons, String title, String body, OnButtonItemClick callBack){

       this.activity = activity;
       this.buttons = buttons;
       this.mTitle = title;
       this.mBody = body;
       this.callBack = callBack;
       createDialog();


   }

   public interface OnButtonItemClick{
        public void onButtonClick(int position);

    }


    public void dismiss(){

       this.settingsDialog.dismiss();
   }

   public void show(){

       this.settingsDialog.show();
   }


   private void createDialog(){

       settingsDialog = new Dialog(activity);
       settingsDialog.setCancelable(false);
       settingsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
       settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//       settingsDialog.setContentView(activity.getLayoutInflater().inflate(R.layout.alert_dialog
//               , null));
//       ListView listView = (ListView)settingsDialog.findViewById(R.id.list_alert);
//       TextView title = (TextView)settingsDialog.findViewById(R.id.alert_title) ;
//       TextView body = (TextView)settingsDialog.findViewById(R.id.alert_body) ;
//       title.setText(mTitle);
//       body.setText(mBody);
       final AlertListAdapter alertListAdapter = new AlertListAdapter(activity, buttons, new OnButtonItemClick() {
           @Override
           public void onButtonClick(int position) {
               callBack.onButtonClick(position);
               settingsDialog.dismiss();
           }
       });
//       listView.setAdapter(alertListAdapter);



   }



}
