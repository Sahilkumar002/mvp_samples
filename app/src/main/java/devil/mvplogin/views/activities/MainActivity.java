package devil.mvplogin.views.activities;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import devil.mvplogin.R;
import devil.mvplogin.presenters.LoginPresenter;
import devil.mvplogin.viewInterfaces.LoginView;

public class MainActivity extends BaseAppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    @BindView(R.id.etUserName) EditText etUserName;
    @BindView(R.id.etPassword) EditText etPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
        findViewById(R.id.btnLogin).setOnClickListener(v -> loginPresenter.validateCredts(
                etUserName.getText().toString().trim(), etPassword.getText().toString().trim()));
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

}
