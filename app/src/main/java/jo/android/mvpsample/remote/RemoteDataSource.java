package jo.android.mvpsample.remote;

import android.support.annotation.Nullable;

import jo.android.mvpsample.BuildConfig;
import jo.android.mvpsample.view.main.data.PhotoResponse;
import jo.android.mvpsample.network.retrofit.NetworkConfig;
import jo.android.mvpsample.network.retrofit.NetworkCallbackListener;
import jo.android.mvpsample.network.retrofit.NetworkManager;
import retrofit2.Call;

/**
 * 실제 remote 연결
 */
public class RemoteDataSource implements MainDataSource{

    private RemoteDataSource() {
    }

    private static class RemoteDataSourceHolder{
        public static final RemoteDataSource INSTANCE = new RemoteDataSource();
    }

    public static RemoteDataSource getRemoteDataSource() {
        return RemoteDataSourceHolder.INSTANCE;
    }

    @Override
    public void getSearchPhotos(String format, String nojsoncallback, String method, String searchKeyword, String flickrKey,int requestPage,
                                int requestPerPage, final LoadFlickrCallback<PhotoResponse> callback) {

        Call<PhotoResponse> call = NetworkConfig.createRetrofit().getFlickrSearch(format, nojsoncallback,
                method, BuildConfig.FLICKR_API_KEY, searchKeyword, requestPage, requestPerPage);

        NetworkManager<PhotoResponse> networkManager = new NetworkManager<>(call);
        networkManager.setOnStartNetworkListener(new NetworkCallbackListener<PhotoResponse>() {
            @Override
            public void onResponse(@Nullable PhotoResponse photoResponse) {
                callback.onSuccess(photoResponse);
            }

            @Override
            public void onFailure(String msg) {
                callback.onFailure(msg);
            }
        });
    }
}
