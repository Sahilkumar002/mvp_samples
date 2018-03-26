package devil.mvplogin.presenters;

import android.text.TextUtils;

import com.google.firebase.database.DatabaseReference;

import devil.mvplogin.R;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.utils.ApplicationGlobal;
import devil.mvplogin.viewInterfaces.LoginView;

/**
 * Created by devil on 3/22/18.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private DatabaseReference databaseReference;

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
        databaseReference = ApplicationGlobal.getDatabaseInstance().getReference(getView().getActivityContext().getString(R.string.user_login_query));
    }

    public void validateCredts(String userName, String password) {
        if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
            getView().moveToHome();
        } else {
            String id = databaseReference.push().getKey();
            databaseReference.child(id).setValue(new Users(id, userName, password))
                    .addOnCompleteListener(task -> getView().moveToHome());
        }
    }

}
