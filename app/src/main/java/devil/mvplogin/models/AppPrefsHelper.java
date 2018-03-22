package devil.mvplogin.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by devil on 3/22/18.
 */

public class AppPrefsHelper {

    private static final String PREFS_APP_NAME = "Mvp Sample";
    private static final String PREFS_USERNAME = "UserName";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public AppPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_APP_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void clearPrefs() {
        mEditor.clear();
        mEditor.apply();
    }

    public void saveUserData(String name) {
        mEditor.putString(PREFS_USERNAME, name);
        mEditor.apply();
    }

    public String getUserName() {
        return mSharedPreferences.getString(PREFS_USERNAME, "");
    }

}
