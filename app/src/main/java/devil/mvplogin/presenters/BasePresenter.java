package devil.mvplogin.presenters;

import java.lang.ref.WeakReference;

/**
 * Created by devil on 3/22/18.
 */

public class BasePresenter<V> {

    private WeakReference<V> view;


    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }


    protected V getView() {
        return view != null ? view.get() : null;
    }

    public void onDetach() {
        view = null;
    }

}
