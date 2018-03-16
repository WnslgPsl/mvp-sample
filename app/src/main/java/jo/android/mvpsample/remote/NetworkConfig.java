package jo.android.mvpsample.remote;

import jo.android.mvpsample.remote.interceptor.ApplicationInterceptor;
import jo.android.mvpsample.remote.interceptor.NetworkInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConfig {

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new NetworkInterceptor());
        builder.addInterceptor(new ApplicationInterceptor());
        return builder.build();
    }

    public static NetworkCallbackListener createRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient());
        Retrofit retrofit = builder.build();
        return retrofit.create(NetworkCallbackListener.class);
    }
}
