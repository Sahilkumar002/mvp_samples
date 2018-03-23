package devil.mvplogin.presenters;

import android.text.TextUtils;

import devil.mvplogin.utils.ApplicationGlobal;
import devil.mvplogin.viewInterfaces.LoginView;

/**
 * Created by devil on 3/22/18.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
    }

    public void validateCredts(String userName, String password) {
        if (TextUtils.isEmpty(userName)) {
            getView().showError("UserName Empty");
        } else if (TextUtils.isEmpty(password)) {
            getView().showError("Password Empty");
        } else {
            ApplicationGlobal.getPrefsHelper().saveUserData(userName);
            getView().moveToHome();
        }
    }

}
