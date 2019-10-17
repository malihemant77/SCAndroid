package qa.aspirezone.sc.chatassistant.activities;

import android.os.Bundle;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import qa.aspirezone.sc.chatassistant.R;

//import com.iquip.dprandroid.R;


public class LoginActivity extends AppCompatActivity {
//    private static final android.R.attr R = ;

    //  private SharedPreference sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupLoginScreen();
     /*   sharedPreference = new SharedPreference(this);
        Log.e("response", "fname" + sharedPreference.getCustFirstName());
        Log.e("response", "bool" + sharedPreference.getFeaturedlistitemposition());
   */ }

    private void setupLoginScreen(){
       /* LoginFragment mLoginFragment = new LoginFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.loginContainer, mLoginFragment);
        fragmentTransaction.commit();*/
    }
}
