package devil.mvplogin.models.retrofit;

import java.util.List;

import devil.mvplogin.models.Users;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by devil on 3/22/18.
 */

public interface API {
    @GET("users")
    Call<List<Users>> getUsers();
}
