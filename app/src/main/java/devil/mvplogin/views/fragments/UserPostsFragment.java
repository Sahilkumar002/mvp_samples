package devil.mvplogin.views.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import devil.mvplogin.R;
import devil.mvplogin.adapters.PostsListAdapter;
import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.presenters.BasePresenter;
import devil.mvplogin.presenters.PostsPresenter;
import devil.mvplogin.viewInterfaces.PostView;

/**
 * Created by devil on 3/23/18.
 */

public class UserPostsFragment extends BaseFragment implements PostView {
    @BindView(R.id.recyclerView) RecyclerView recyclerview;
    private PostsListAdapter mAdapter;
    private List<Posts> postsList = new ArrayList<>();
    private int postId;
    private PostsPresenter presenter;

    public static UserPostsFragment newInstance(Integer postId) {
        UserPostsFragment fragment = new UserPostsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("postId", postId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_posts;
    }

    @Override
    protected void init() {
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new PostsListAdapter(getActivity(), postsList);
        recyclerview.setAdapter(mAdapter);
        if (getArguments() != null) {
            postId = getArguments().getInt("postId");
        }
        presenter = new PostsPresenter();
        presenter.attachView(this);
        presenter.loadPosts();
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return presenter /*== null ? new PostsPresenter(this) : presenter*/;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getUserId() {
        return postId;
    }

    @Override
    public void updateList(List<Posts> posts) {
        postsList.clear();
        postsList.addAll(posts);
        mAdapter.notifyDataSetChanged();
    }


}
