package jo.android.mvpsample;

import android.support.annotation.Nullable;

import jo.android.mvpsample.data.PhotoResponse;
import jo.android.mvpsample.remote.NetworkCallbackListener;
import jo.android.mvpsample.network.NetworkConfig;
import jo.android.mvpsample.remote.NetworkManager;
import retrofit2.Call;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view = null;


    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadFlickrImage() {

        view.showProgress();

        Call<PhotoResponse> call = NetworkConfig.createRetrofit().getFlickrSearch("json", "1",
                "flickr.photos.search", BuildConfig.FLICKR_API_KEY, "ogm", 1, 20);
        NetworkManager<PhotoResponse> networkManager = new NetworkManager<>(call);
        networkManager.setOnStartNetworkListener(new NetworkCallbackListener<PhotoResponse>() {
            @Override
            public void onResponse(@Nullable PhotoResponse photoResponse) {
                view.hideProgress();
            }

            @Override
            public void onFailure(String msg) {
                view.hideProgress();
            }
        });
    }

}
