package jo.android.mvpsample.remote;

import jo.android.mvpsample.data.PhotoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkCallbackService {

    @GET("format=json&nojsoncallback=1")
    Call<PhotoResponse> getFlickrSearch(
            @Query("method") String method,
            @Query("api_key") String api_key,
            @Query("text") String text,
            @Query("page") int page,
            @Query("per_page") int per_page);
}
