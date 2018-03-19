package jo.android.mvpsample.network;

import jo.android.mvpsample.data.PhotoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkCallbackService {

    @GET("rest")
    Call<PhotoResponse> getFlickrSearch(
            @Query("format") String format,
            @Query("nojsoncallback") String nojsoncallback,
            @Query("method") String method,
            @Query("api_key") String api_key,
            @Query("text") String text,
            @Query("page") int page,
            @Query("per_page") int per_page);
}
