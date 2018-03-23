package devil.mvplogin.presenters;

import java.util.List;

import devil.mvplogin.models.BaseInteractor;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.viewInterfaces.PostView;
import retrofit2.Response;

/**
 * Created by devil on 3/23/18.
 */

public class PostsPresenter extends BasePresenter<PostView> {

    private BaseInteractor<List<Posts>> interactor;


    @Override
    public void attachView(PostView view) {
        super.attachView(view);
        interactor = new BaseInteractor<>();
    }

    public void loadPosts() {
        getView().showDialog();
        interactor.getRetrofitCall(RestClient.getClient().getPosts(getView().getUserId()),
                new OnResponseCallBack() {
                    @Override
                    public void onSuccess(Response<?> response) {
                        getView().dismissDialog();
                        try {
                            if (response.code() == 200 && response.body() != null) {
                                getView().updateList((List<Posts>) response.body());
                            } else {
                                getView().showMessage("API ERROR");
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
