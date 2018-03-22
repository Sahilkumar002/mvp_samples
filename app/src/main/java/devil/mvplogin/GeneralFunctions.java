package devil.mvplogin;

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

}
