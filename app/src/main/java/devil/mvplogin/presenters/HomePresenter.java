package devil.mvplogin.presenters;


import java.util.List;

import devil.mvplogin.models.BaseInteractor;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.viewInterfaces.HomeView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private BaseInteractor<List<Users>> interactor;

    @Override
    public void attachView(HomeView view) {
        super.attachView(view);
        interactor = new BaseInteractor<>();
    }


    public void loadUsers() {
        getView().showDialog();
        disposable.add(interactor.getDisposable(RestClient.getClient().getUsers(), new OnResponseCallBack() {
            @Override
            public void onSuccess(Response<?> response) {
                getView().dismissDialog();
                try {
                    if (response.code() == 200 && response.body() != null) {
                        getView().updateList((List<Users>) response.body());
                    } else {
                        getView().showMessage("API Error");
                    }
                } catch (Exception e) {
                    getView().showMessage(e.getLocalizedMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                getView().dismissDialog();
                getView().showMessage(t.getLocalizedMessage());
            }
        }));


//        interactor.getRetrofitCall(RestClient.getClient().getUsers(), new OnResponseCallBack() {
//            @Override
//            public void onSuccess(Response<?> response) {
//                getView().dismissDialog();
//                try {
//                    if (response.code() == 200 && response.body() != null) {
//                        getView().updateList((List<?>) response.body());
//                    } else {
//                        getView().showMessage("API Error");
//                    }
//                } catch (Exception e) {
//                    getView().showMessage(e.getLocalizedMessage());
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                getView().dismissDialog();
//                getView().showMessage(t.getLocalizedMessage());
//            }
//        });


    }

}
