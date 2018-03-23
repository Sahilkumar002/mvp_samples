package devil.mvplogin.views;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devil.mvplogin.utils.GeneralFunctions;
import devil.mvplogin.R;
import devil.mvplogin.adapters.UsersListAdapter;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.presenters.HomePresenter;
import devil.mvplogin.viewInterfaces.HomeView;

/**
 * Created by devil on 3/22/18.
 */

public class HomeActivity extends AppCompatActivity implements HomeView {

    private Dialog dialog;
    private RecyclerView mRecyclerView;
    private UsersListAdapter mAdapter;
    private List<Users> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dialog = GeneralFunctions.dialog(this);

        init();

    }

    private void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new UsersListAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);

        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.loadUsers();
    }


    @Override
    public void showDialog() {
        if (dialog != null) dialog.show();
    }

    @Override
    public void dismissDialog() {
        if (dialog != null) dialog.dismiss();

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateList(List<Users> usersList) {
        list.clear();
        list.addAll(usersList);
        mAdapter.notifyDataSetChanged();
    }
}
