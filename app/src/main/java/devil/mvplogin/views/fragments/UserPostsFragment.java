package devil.mvplogin.views.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devil.mvplogin.utils.GeneralFunctions;
import devil.mvplogin.R;
import devil.mvplogin.adapters.PostsListAdapter;
import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.presenters.PostsPresenter;
import devil.mvplogin.viewInterfaces.PostView;

/**
 * Created by devil on 3/23/18.
 */

public class UserPostsFragment extends Fragment implements PostView {
    private RecyclerView recyclerview;
    private PostsListAdapter mAdapter;
    private List<Posts> postsList = new ArrayList<>();
    private int postId;
    private Dialog mDialog;

    public static UserPostsFragment newInstance(Integer postId) {
        UserPostsFragment fragment = new UserPostsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("postId", postId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_posts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDialog = GeneralFunctions.dialog(getActivity());
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new PostsListAdapter(getActivity(), postsList);
        recyclerview.setAdapter(mAdapter);
        if (getArguments() != null) {
            postId = getArguments().getInt("postId");
        }

        PostsPresenter presenter = new PostsPresenter(this);
        presenter.loadPosts();

    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void dismissDialog() {
        mDialog.dismiss();
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
