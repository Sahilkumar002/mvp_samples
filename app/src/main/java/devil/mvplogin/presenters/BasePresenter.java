package devil.mvplogin.presenters;

import java.lang.ref.WeakReference;

import devil.mvplogin.models.BaseInteractor;

/**
 * Created by devil on 3/22/18.
 */

public class BasePresenter<V> {

    private WeakReference<V> view;
    BaseInteractor interactor;

    public void attachView(V view) {
        this.view = new WeakReference<>(view);
        interactor = new BaseInteractor();
    }

    protected V getView() {
        return view != null ? view.get() : null;
    }

    public void onDetach() {
        view = null;
    }

}
