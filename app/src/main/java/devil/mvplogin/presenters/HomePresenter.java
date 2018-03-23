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

public class HomePresenter extends BasePresenter {

    private HomeView homeView;
    private BaseInteractor<List<Users>> interactor;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        interactor = new BaseInteractor<>();
    }

    public void showSavedData() {
        if (homeView != null) {
            homeView.showMessage(ApplicationGlobal.getPrefsHelper().getUserName());
        }
    }

    public void loadUsers() {
        if (homeView != null) homeView.showDialog();

        interactor.getRetrofitCall(RestClient.getClient().getUsers(), new OnResponseCallBack() {
            @Override
            public void onSuccess(Response<?> response) {
                homeView.dismissDialog();
                try {
                    if (response.code() == 200 && response.body() != null) {
                        homeView.updateList((List<Users>) response.body());
                    } else {
                        homeView.showMessage("API Error");
                    }
                } catch (Exception e) {
                    homeView.showMessage(e.getLocalizedMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                homeView.dismissDialog();
                homeView.showMessage(t.getLocalizedMessage());
            }
        });


    }

}
