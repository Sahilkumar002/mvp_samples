package devil.mvplogin.presenters;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by devil on 3/22/18.
 */

public class BasePresenter<V> {

    private WeakReference<V> view;
    public CompositeDisposable disposable;

    public void attachView(V view) {
        this.view = new WeakReference<>(view);
        disposable = new CompositeDisposable();
    }

    protected V getView() {
        return view != null ? view.get() : null;
    }

    public void onDetach() {
        view = null;
        if (null != disposable) {
            disposable.clear();
        }
    }

}
