package devil.mvplogin.viewInterfaces;

import android.content.Context;

/**
 * Created by devil on 3/22/18.
 */

public interface LoginView {

    void showError(String error);

    void moveToHome();

    Context getActivityContext();
}
