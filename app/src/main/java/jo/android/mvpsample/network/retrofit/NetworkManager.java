package jo.android.mvpsample.network.retrofit;

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

                if(response.isSuccessful()){
                    if (response.body() != null) {
                        mNetworkCallbackListener.onResponse(response.body());
                    }else{
                        mNetworkCallbackListener.onFailure("요청은 성공했으나, 응답 데이터가 없음.");
                    }
                }else{
                    mNetworkCallbackListener.onFailure("요청은 성공했으나, 서버 개발자의 의도에 의한 Error 처리.");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                mNetworkCallbackListener.onFailure(t.getMessage().toString());
            }
        });
    }


}
