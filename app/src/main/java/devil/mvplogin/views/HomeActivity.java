package devil.mvplogin.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import devil.mvplogin.R;
import devil.mvplogin.presenters.HomePresenter;
import devil.mvplogin.viewInterfaces.HomeView;

/**
 * Created by devil on 3/22/18.
 */

public class HomeActivity extends AppCompatActivity implements HomeView {
    TextView tvUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUserName = findViewById(R.id.tvUserName);
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.showSavedData();

    }

    @Override
    public void showData(String userName) {
        tvUserName.setText(userName);
    }
}
