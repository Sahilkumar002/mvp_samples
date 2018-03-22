package devil.mvplogin.presenters;


import java.util.List;

import devil.mvplogin.ApplicationGlobal;
import devil.mvplogin.models.Users;
import devil.mvplogin.models.interactors.BaseInteractor;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.viewInterfaces.HomeView;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class HomePresenter {

    private HomeView homeView;
    private BaseInteractor<List<Users>> interactor;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        interactor = new BaseInteractor<List<Users>>();
    }

    public void showSavedData() {
        if (homeView != null) {
            homeView.showData(ApplicationGlobal.getPrefsHelper().getUserName());
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
                        homeView.showData("API Error");
                    }
                } catch (Exception e) {
                    homeView.showData(e.getLocalizedMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                homeView.dismissDialog();
                homeView.showData(t.getLocalizedMessage());
            }
        });


    }

}
