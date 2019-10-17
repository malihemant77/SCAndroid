package qa.aspirezone.sc.chatassistant.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private SharedPreferences sharedpreferences;
    private static final String preference = "preference";
    private static final String custGroup = "custGroup";
    private static final String vipCustomer = "vipCustomer";
    private static final String custFirstName = "custFirstName";
    private static final String custLastName = "custLastName";
    private static final String custCountry = "custCountry";
    private static final String featuredOptionActive = "featuredOptionActive";
    private static final String featuredlistitemposition = "featuredlistitemposition";

    private SharedPreferences.Editor editor;

    public SharedPreference(Context context) {
        sharedpreferences = context.getSharedPreferences(preference,
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

   public void setCustGroup(int custGroups) {
       editor.putInt(custGroup, custGroups);
       editor.commit();
   }

    public  int getCustGroup() {
        if (sharedpreferences.contains(custGroup)) {
            return (sharedpreferences.getInt(custGroup, 0));
        }
        return 0;
    }

    public void setVipCustomer(int vipCustomers) {
        editor.putInt(vipCustomer, vipCustomers);
        editor.commit();
    }
    public  int getVipCustomer() {
        if (sharedpreferences.contains(vipCustomer)) {
            return (sharedpreferences.getInt(vipCustomer, 0));
        }
        return 0;
    }

    public void setFeaturedOptionActive(boolean foa) {
        editor.putBoolean(featuredOptionActive, foa);
        editor.commit();
    }
    public boolean getFeaturedOptionActive() {
        if (sharedpreferences.contains(featuredOptionActive)) {
            return (sharedpreferences.getBoolean(featuredOptionActive,false));
        }
        return false;
    }

    public void setFeaturedlistitemposition(int fop) {
        editor.putInt(featuredlistitemposition, fop);
        editor.commit();
    }
    public  int getFeaturedlistitemposition() {
        if (sharedpreferences.contains(featuredlistitemposition)) {
            return (sharedpreferences.getInt(featuredlistitemposition, 0));
        }
        return 0;
    }

    public void setCustFirstName(String custFirstName1) {
        editor.putString(custFirstName, custFirstName1);
        editor.commit();
    }
    public String getCustFirstName() {
        if (sharedpreferences.contains(custFirstName)) {
            return (sharedpreferences.getString(custFirstName, ""));
        }
        return "";
    }

    public void setCustLastName(String custLastName1) {
        editor.putString(custLastName, custLastName1);
        editor.commit();
    }
    public String getCustLastName() {
        if (sharedpreferences.contains(custLastName)) {
            return (sharedpreferences.getString(custLastName, ""));
        }
        return "";
    }

    public void setCustCountry(String custCountry1) {
        editor.putString(custCountry, custCountry1);
        editor.commit();
    }
    public String getCustCountry() {
        if (sharedpreferences.contains(custCountry)) {
            return (sharedpreferences.getString(custCountry, ""));
        }
        return "";
    }

    public void Clear() {
        editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }
}
