package devil.mvplogin.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import devil.mvplogin.R;
import devil.mvplogin.presenters.LoginPresenter;
import devil.mvplogin.viewInterfaces.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private EditText mUserName, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = findViewById(R.id.etUserName);
        mPassword = findViewById(R.id.etPassword);
        loginPresenter = new LoginPresenter(this);

        findViewById(R.id.btnLogin).setOnClickListener(v -> loginPresenter.validateCredts(mUserName.getText().toString().trim(),
                mPassword.getText().toString().trim()));
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
