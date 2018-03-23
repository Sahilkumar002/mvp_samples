package devil.mvplogin.views.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import devil.mvplogin.utils.GeneralFunctions;

/**
 * Created by devil on 3/23/18.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    public void showProgress() {
        if (mDialog == null) mDialog = GeneralFunctions.dialog(this);
        mDialog.show();
    }

    public void hideProgress() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

}
