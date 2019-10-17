package qa.aspirezone.sc.chatassistant.adapters;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import qa.aspirezone.sc.chatassistant.R;
import qa.aspirezone.sc.chatassistant.activities.BaseActivity;
import qa.aspirezone.sc.chatassistant.models.NavigationMenuItemModel;
//
//import com.iquip.dprandroid.R;
//import com.iquip.dprandroid.activities.BaseActivity;
//import com.iquip.dprandroid.models.NavigationMenuItemModel;


import java.util.List;

public class NavigationMenuAdapter extends RecyclerView.Adapter<NavigationMenuAdapter.NavigationMenuViewHolder> {

    private List<NavigationMenuItemModel> mMenuItems;
    private Context context;

    public class NavigationMenuViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public NavigationMenuViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_nav_title);
            imageView = (ImageView) view.findViewById(R.id.iv_nav_image);
            linearLayout = (LinearLayout)view.findViewById(R.id.rv_layout);

        }
    }
    public NavigationMenuAdapter(Context context, List<NavigationMenuItemModel> mMenuItems) {
        this.mMenuItems = mMenuItems;
        this.context = context;
    }

    @Override
    public NavigationMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.navigation_item, parent, false);

        return new NavigationMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NavigationMenuViewHolder holder, final int position) {

        NavigationMenuItemModel menuItemModel = mMenuItems.get(position);
        holder.title.setText(menuItemModel.title);
        holder.imageView.setImageDrawable(menuItemModel.imageDrawable);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseActivity)context).onMenuItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mMenuItems.size();
    }
}
