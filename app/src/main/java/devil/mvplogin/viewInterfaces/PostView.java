package devil.mvplogin.viewInterfaces;

import java.util.List;

import devil.mvplogin.models.retrofit.pojos.Posts;

/**
 * Created by devil on 3/23/18.
 */

public interface PostView extends BaseView {

    int getUserId();

    void updateList(List<Posts> postsList);

}
