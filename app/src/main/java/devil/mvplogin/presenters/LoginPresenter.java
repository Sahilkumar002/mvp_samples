package devil.mvplogin.presenters;

import android.text.TextUtils;

import devil.mvplogin.utils.ApplicationGlobal;
import devil.mvplogin.viewInterfaces.LoginView;

/**
 * Created by devil on 3/22/18.
 */

public class LoginPresenter {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void validateCredts(String userName, String password) {
        if (TextUtils.isEmpty(userName)) {
            loginView.showError("UserName Empty");
        } else if (TextUtils.isEmpty(password)) {
            loginView.showError("Password Empty");
        } else {
            ApplicationGlobal.getPrefsHelper().saveUserData(userName);
            loginView.moveToHome();
        }
    }

    public void onDetachView() {
        loginView = null;
    }

}
