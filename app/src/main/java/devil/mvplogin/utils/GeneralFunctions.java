package devil.mvplogin.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by devil on 3/22/18.
 */

public class GeneralFunctions {

    public static ProgressDialog dialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static void addFragment(FragmentManager manager, Fragment fragment, String tag,
                                   int container) {
        if (null == manager.findFragmentById(container)) {
            manager.beginTransaction().add(container, fragment, tag).addToBackStack(tag).commit();
        } else {
            if (!manager.findFragmentById(container).getTag().equals(tag)) {
                manager.beginTransaction().add(container, fragment, tag).addToBackStack(tag).commit();
            }
        }

    }


}
