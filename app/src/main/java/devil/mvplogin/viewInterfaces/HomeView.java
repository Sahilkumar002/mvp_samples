package devil.mvplogin.viewInterfaces;

import java.util.List;

import devil.mvplogin.models.retrofit.pojos.Users;

/**
 * Created by devil on 3/22/18.
 */

public interface HomeView extends BaseView {

    void updateList(List<Users> usersList);
}
