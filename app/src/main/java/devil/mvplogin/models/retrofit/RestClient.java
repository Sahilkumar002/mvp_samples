package devil.mvplogin.models.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by devil on 3/22/18.
 */

public class RestClient {
    private static API REST_CLIENT;
    private static Retrofit retrofit;

    public static API getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        REST_CLIENT = retrofit.create(API.class);
        return REST_CLIENT;
    }
}
