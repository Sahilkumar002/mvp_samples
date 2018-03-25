package devil.mvplogin.models.retrofit;

import java.util.List;

import devil.mvplogin.models.retrofit.pojos.Posts;
import devil.mvplogin.models.retrofit.pojos.Users;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by devil on 3/22/18.
 */

public interface API {

    @GET("users")
    Observable<Response<List<Users>>> getUsers();

//    Call<List<Users>> getUsers();


    @GET("posts")
    Observable<Response<List<Posts>>> getPosts(@Query("userId") Integer userId);

//    Call<List<Posts>> getPosts(@Query("userId") Integer userId);
}
