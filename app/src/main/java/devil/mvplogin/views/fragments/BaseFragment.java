package devil.mvplogin.views.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import devil.mvplogin.presenters.BasePresenter;
import devil.mvplogin.utils.GeneralFunctions;

/**
 * Created by devil on 3/23/18.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnBinder;
    private Dialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog = GeneralFunctions.dialog(getActivity());
        init();
    }

    @Override
    public void onDestroyView() {
        mUnBinder.unbind();
        if (null != getBasePresenter()) {
            getBasePresenter().onDetach();
        }
        super.onDestroyView();
    }

    public void showDialog() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public void dismissDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract BasePresenter getBasePresenter();


}
