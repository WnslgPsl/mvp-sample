package jo.android.mvpsample.remote;

import android.content.Context;

import jo.android.mvpsample.util.NetworkDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkManager<T> {

    private Call<T> call;

    public NetworkManager(Call<T> call){
        this.call = call;
    }

    public void setOnStartNetworkListener(final NetworkCallbackListener mNetworkCallbackListener){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.body() != null) {
                    mNetworkCallbackListener.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                mNetworkCallbackListener.onFailure(t.getMessage().toString());
            }
        });
    }


}
