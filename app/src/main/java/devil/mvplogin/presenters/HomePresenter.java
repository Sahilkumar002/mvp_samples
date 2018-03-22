package devil.mvplogin.presenters;

import devil.mvplogin.ApplicationGlobal;
import devil.mvplogin.viewInterfaces.HomeView;

/**
 * Created by devil on 3/22/18.
 */

public class HomePresenter {

    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    public void showSavedData() {
        if (homeView != null) {
            homeView.showData(ApplicationGlobal.getPrefsHelper().getUserName());
        }
    }

}
