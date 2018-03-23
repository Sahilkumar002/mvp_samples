package devil.mvplogin.utils;

import android.annotation.SuppressLint;
import android.app.Application;

import devil.mvplogin.models.AppPrefsHelper;

/**
 * Created by devil on 3/22/18.
 */

public class ApplicationGlobal extends Application {
    @SuppressLint("StaticFieldLeak") private static AppPrefsHelper prefsHelper;

    public static AppPrefsHelper getPrefsHelper() {
        return prefsHelper;
    }

    public static void setPrefsHelper(AppPrefsHelper prefsHelper) {
        ApplicationGlobal.prefsHelper = prefsHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        prefsHelper = new AppPrefsHelper(this);
    }
}
