package devil.mvplogin.models.retrofit;

import java.util.List;

import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.models.retrofit.pojos.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by devil on 3/22/18.
 */

public interface API {
    @GET("users")
    Call<List<Users>> getUsers();

    @GET("posts")
    Call<List<Posts>> getPosts(@Query("userId") Integer userId);
}
