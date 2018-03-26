package devil.mvplogin.views.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import devil.mvplogin.R;
import devil.mvplogin.adapters.UsersListAdapter;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.presenters.HomePresenter;
import devil.mvplogin.utils.ApplicationGlobal;
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

    @Override
    protected void onResume() {
        super.onResume();
//        ApplicationGlobal.getDatabaseInstance().getReference().addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                list.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Users users = snapshot.getValue(Users.class);
//                        list.add(users);
//                }
//                updateList(list);
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }

}
