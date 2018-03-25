package devil.mvplogin.models;

import devil.mvplogin.models.retrofit.OnResponseCallBack;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class BaseInteractor<T> {

    public Disposable getDisposable(Observable<Response<T>> observable,
                                    OnResponseCallBack callBack) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<?>>() {
                    @Override
                    public void onNext(Response<?> response) {
                        callBack.onSuccess(response);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

//    public void getRetrofitCall(Call<T> call, OnResponseCallBack callBack) {
//        call.enqueue(new Callback<T>() {
//            @Override
//            public void onResponse(Call<T> call, Response<T> response) {
//                callBack.onSuccess(response);
//            }
//
//            @Override
//            public void onFailure(Call<T> call, Throwable t) {
//                callBack.onError(t);
//            }
//        });
//    }
}
