package devil.mvplogin.models;

import devil.mvplogin.models.retrofit.OnResponseCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by devil on 3/22/18.
 */

public class BaseInteractor<T> {
    public void getRetrofitCall(Call<T> call, OnResponseCallBack callBack) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                callBack.onSuccess(response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callBack.onError(t);
            }
        });
    }
}
