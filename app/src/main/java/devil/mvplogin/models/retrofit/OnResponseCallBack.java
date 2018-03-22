package devil.mvplogin.models.retrofit;

import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public interface OnResponseCallBack {

    void onSuccess(Response<?> response);

    void onError(Throwable t);
}
