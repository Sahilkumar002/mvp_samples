package devil.mvplogin.presenters;

import java.util.List;

import devil.mvplogin.models.interactors.BaseInteractor;
import devil.mvplogin.models.retrofit.OnResponseCallBack;
import devil.mvplogin.models.retrofit.RestClient;
import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.viewInterfaces.PostView;
import retrofit2.Response;

/**
 * Created by devil on 3/23/18.
 */

public class PostsPresenter extends BasePresenter {

    private PostView postView;
    private BaseInteractor interactor;

    public PostsPresenter(PostView postView) {
        this.postView = postView;
        interactor = new BaseInteractor();
    }

    public void loadPosts() {
        postView.showDialog();
        interactor.getRetrofitCall(RestClient.getClient().getPosts(postView.getUserId()),
                new OnResponseCallBack() {
                    @Override
                    public void onSuccess(Response<?> response) {
                        postView.dismissDialog();
                        try {
                            if (response.code()==200 && response.body()!=null){
                                postView.updateList((List<Posts>) response.body());
                            }else {
                                postView.showMessage("API ERROR");
                            }

                        } catch (Exception e) {
                            postView.showMessage(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        postView.dismissDialog();
                        postView.showMessage(t.getLocalizedMessage());
                    }
                });
    }
}
