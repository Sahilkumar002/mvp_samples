package devil.mvplogin.views.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import devil.mvplogin.R;
import devil.mvplogin.adapters.UsersListAdapter;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.presenters.HomePresenter;
import devil.mvplogin.viewInterfaces.HomeView;

/**
 * Created by devil on 3/22/18.
 */

public class HomeActivity extends BaseAppCompatActivity implements HomeView {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private UsersListAdapter mAdapter;
    private List<Users> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new UsersListAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);

        HomePresenter homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.loadUsers();
    }

    @Override
    public void showDialog() {
        showProgress();
    }

    @Override
    public void dismissDialog() {
        hideProgress();
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
