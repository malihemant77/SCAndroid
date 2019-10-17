package qa.aspirezone.sc.chatassistant.activities;

import android.content.Intent;
import android.os.Bundle;
import 	androidx.fragment.app.Fragment ;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DefaultItemAnimator;
//import androidx.drawerlayout.widget.LinearLayoutManager;
//import androidx.drawerlayout.widget.RecyclerView;
//import androidx.drawerlayout.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import qa.aspirezone.sc.chatassistant.R;
import qa.aspirezone.sc.chatassistant.adapters.NavigationMenuAdapter;
import qa.aspirezone.sc.chatassistant.fragments.ChatFragment;
import qa.aspirezone.sc.chatassistant.models.NavigationMenuItemModel;
import qa.aspirezone.sc.chatassistant.preferences.AppPreferences;
import qa.aspirezone.sc.chatassistant.preferences.SharedPreference;


import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private NavigationMenuAdapter mMenuAdapter;
    private List<NavigationMenuItemModel> mNavMenuItems = new ArrayList<>();
    private ImageButton mChatButton;
    private RecyclerView mRecyclerView;
    public TextView mTitle;
    private Button mBackButton,btnLogout;
    private TextView mNavTitle;
//    private PsychicsListFragment psychicsListFragment;
//    private MyAccountFragment myAccountFragment;
//    private PsychicBioFragment psychicBioFragment;
    private static String identifier;
    private static boolean bool_filterby;
    private ArrayList<String> toolfilterData = new ArrayList<>();
    private ArrayList<String> filterData = new ArrayList<>();
    private ArrayList<String> abilityFilterData = new ArrayList<>();
//    private ArrayList<FilterByPriceBeen> pricefilterData = new ArrayList<>();
    private ArrayList<String> stylefilterData = new ArrayList<>();
    private SharedPreference sharedPreference;
//    private ProgressBarHandler progressBarHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

//        progressBarHandler =new ProgressBarHandler(this);
        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//         mDrawerToggle.setDrawerIndicatorEnabled(false);
//         toolbar.setNavigationIcon(R.drawable.ic_action_menuicon);
//        psychicsListFragment = PsychicsListFragment.newInstance(false);
//        myAccountFragment = MyAccountFragment.newInstance();
//
//        mChatButton = (ImageButton) toolbar.findViewById(R.id.btn_chat_menu);9
        mTitle = (TextView) findViewById(R.id.tv_title);
        mNavTitle = (TextView) findViewById(R.id.tv_user_name);
//        //psychicBioFragment = PsychicBioFragment.newInstance();
//        mChatButton = (ImageButton) toolbar.findViewById(R.id.btn_chat_menu);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mNavTitle = (TextView) findViewById(R.id.tv_user_name);
//        btnLogout = (Button) findViewById(R.id.btn_logout);
//
//        mNavTitle.setText(AppPreferences.getTokens(this).displayName);
//
//        mChatButton.setOnClickListener(this);
//        btnLogout.setOnClickListener(this);
        mTitle.setText("Dashboard");
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavTitle = (TextView) drawer.findViewById(R.id.tv_nav_title);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
//
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.nav_drawer_recycler_view);
        mMenuAdapter = new NavigationMenuAdapter(this, mNavMenuItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mMenuAdapter);
        sharedPreference = new SharedPreference(this);
//        getIntentData();
        setupMenu();
    }
//*/
//    private void getIntentData() {
//        try {
//            Bundle args = getIntent().getExtras();
//
//            if (args != null) {
//                filterData.clear();
//                abilityFilterData.clear();
//                toolfilterData.clear();
//                pricefilterData.clear();
//                stylefilterData.clear();
//
//                filterData = args.getStringArrayList("filterdata");
//                abilityFilterData = args.getStringArrayList("abfilterdata");
//                toolfilterData = args.getStringArrayList("toolfilterdata");
//                pricefilterData = (ArrayList<FilterByPriceBeen>) args.getSerializable("pricefilterdata");
//                stylefilterData = args.getStringArrayList("stylefilterdata");
//                identifier = args.getString("itendifier");
//                bool_filterby = args.getBoolean("filterby");
//            }
//
//            try {
//                if (bool_filterby == true) {
//                    PsychicsListFragment psychicsListFragment = new PsychicsListFragment();
//                    Bundle bundle = new Bundle();
//                    bundle.putStringArrayList("filterdata", filterData);
//                    bundle.putStringArrayList("abfilterdata", abilityFilterData);
//                    bundle.putStringArrayList("toolfilterdata", toolfilterData);
//                    bundle.putSerializable("pricefilterdata", pricefilterData);
//                    bundle.putStringArrayList("stylefilterdata", stylefilterData);
//                    bundle.putString("itendifier", identifier);
//                    bundle.putBoolean("filterby", bool_filterby);
//                    psychicsListFragment.setArguments(bundle);
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.add(R.id.baseContainer, psychicsListFragment);
//                    fragmentTransaction.commit();
//                } else {
//                    psychicsListFragment = PsychicsListFragment.newInstance(false);
//                    setFragment(psychicsListFragment);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    private void setupMenu() {
        NavigationMenuItemModel menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_menu_psychic_list), "CHAT");
        mNavMenuItems.add(menuItem);
//        menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_support_email), "IMPREST ACCOUNT");
//        mNavMenuItems.add(menuItem);
//        menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_menu_my_account), "WORK DONE AT SITE");
//        mNavMenuItems.add(menuItem);
//        menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_menu_add_dollars), "REPORT");
//        mNavMenuItems.add(menuItem);
//        menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_menu_help), "MY PROFILE");
//        mNavMenuItems.add(menuItem);
//        menuItem = new NavigationMenuItemModel(getResources().getDrawable(R.drawable.ic_support_phone), "CONTACF
        mMenuAdapter.notifyDataSetChanged();
    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//
//            sharedPreference.setFeaturedOptionActive(false);
//            sharedPreference.setFeaturedlistitemposition(0);
//            super.onBackPressed();
//        }
//    }
//
    public void onMenuItemClick(int position) {
        Fragment fragment = null;
        ChatFragment chatFragment = new ChatFragment();
//        mChatButton.setVisibility(View.VISIBLE);
        switch (position) {
            case 0:

                fragment = chatFragment;
                break;

            case 1:

               // fragment = psychicsListFragment;
                break;

            case 2:
                sharedPreference.setFeaturedOptionActive(false);
                sharedPreference.setFeaturedlistitemposition(0);
                // Intent intent=new Intent();
                //  intent.setClassName(getBaseContext(),EditMyAccountActivity.class);
            //    myAccountFragment = MyAccountFragment.newInstance();
            //    fragment = myAccountFragment;

                break;

            case 3:
           //    fragment = psychicsListFragment;
                break;

            case 4:
             //   fragment = psychicsListFragment;
                break;

            case 5:
             //   fragment = psychicsListFragment;
                break;
        }
        setFragment(fragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.baseContainer, fragment);
        fragmentTransaction.commit();
    }

//private void logout(){
//    progressBarHandler.show();
//    LogoutRequest.send(getBaseContext(), new Listener<String>() {
//        @Override
//        public void onSuccess(String response) {
//           /* Toast.makeText(getApplicationContext(), "Logout Successfully!!!"+response, Toast.LENGTH_LONG).show();
//
//            Log.e("response", "Load More End" + response.toString());*/
//            Log.e("response", "Load More End" + response.toString());
//
//            sharedPreference.Clear();
//            AppPreferences.Clear();
//            PsychicsListFragment.newInstance(true);
//            progressBarHandler.hide();
//            Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            finish();
//
//
//        }
//
//        @Override
//        public void onFailure(int statusCode, VolleyError error) {
//            progressBarHandler.hide();
//        }
//    });
//}
//
//
    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//
//            case R.id.btn_back: {
//
//                break;
//            }
//
//            case R.id.btn_logout: {
//             //   Toast.makeText(getApplicationContext(), "Logout Successfully!!!", Toast.LENGTH_LONG).show();
//                logout();
//                break;
//            }
//
//            case R.id.btn_chat_menu: {
//                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
//                /// startActivity(intent);
//                break;
//            }
//        }
    }

}
