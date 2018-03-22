package devil.mvplogin.viewInterfaces;

import java.util.List;

import devil.mvplogin.models.Users;

/**
 * Created by devil on 3/22/18.
 */

public interface HomeView {

    void showData(String userName);

    void showDialog();

    void dismissDialog();

    void updateList(List<Users> usersList);
}
