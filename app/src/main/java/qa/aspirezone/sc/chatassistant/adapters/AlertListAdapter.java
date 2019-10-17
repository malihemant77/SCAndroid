package qa.aspirezone.sc.chatassistant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

//
//import com.iquip.dprandroid.R;
//import com.iquip.dprandroid.customs.AppDialog;

import java.util.ArrayList;
import java.util.List;

import qa.aspirezone.sc.chatassistant.R;
import qa.aspirezone.sc.chatassistant.customs.AppDialog;


public class AlertListAdapter extends BaseAdapter {
    private Context mcontext;
    public List<String> list = new ArrayList<>();
    private static LayoutInflater inflater=null;
    AppDialog.OnButtonItemClick callBack;



    public AlertListAdapter(Context context, List<String> list, AppDialog.OnButtonItemClick callBack) {
        mcontext = context;
        this.list=list;
        inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.callBack = callBack;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item_alert_dialog, null);
        Button button = vi.findViewById(R.id.alert_button);
        button.setText(list.get(position));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onButtonClick(position);
            }
        });

        return vi;
    }

}
