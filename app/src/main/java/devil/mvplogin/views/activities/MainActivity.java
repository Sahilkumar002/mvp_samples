package devil.mvplogin.views.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindInt;
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

}
