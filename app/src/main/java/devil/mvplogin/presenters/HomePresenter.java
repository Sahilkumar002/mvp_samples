package devil.mvplogin.presenters;


import java.util.List;

import devil.mvplogin.utils.ApplicationGlobal;
import devil.mvplogin.models.BaseInteractor;
import devil.mvplogin.models.retrofit.pojos.Users;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.viewInterfaces.HomeView;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class HomePresenter extends BasePresenter<HomeView> {


    @Override
    public void attachView(HomeView view) {
        super.attachView(view);
    }


    public void loadUsers() {
        if (getView() != null) getView().showDialog();

        interactor.getRetrofitCall(RestClient.getClient().getUsers(), new OnResponseCallBack() {
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
        });


    }

}
