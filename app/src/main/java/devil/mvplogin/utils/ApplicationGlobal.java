package devil.mvplogin.utils;

import android.annotation.SuppressLint;
import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import devil.mvplogin.models.AppPrefsHelper;

/**
 * Created by devil on 3/22/18.
 */

public class ApplicationGlobal extends Application {
    @SuppressLint("StaticFieldLeak") private static AppPrefsHelper prefsHelper;
    private static FirebaseDatabase databaseInstance;

//    public static void setPrefsHelper(AppPrefsHelper prefsHelper) {
//        ApplicationGlobal.prefsHelper = prefsHelper;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        prefsHelper = new AppPrefsHelper(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseInstance = FirebaseDatabase.getInstance();

    }

    public static AppPrefsHelper getPrefsHelper() {
        return prefsHelper;
    }


    public static FirebaseDatabase getDatabaseInstance() {
        return databaseInstance;
    }

}
