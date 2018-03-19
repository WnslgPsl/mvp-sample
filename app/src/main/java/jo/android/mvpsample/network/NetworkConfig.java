package jo.android.mvpsample.network;

import jo.android.mvpsample.network.interceptor.ApplicationInterceptor;
import jo.android.mvpsample.network.interceptor.NetworkInterceptor;
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

    public static NetworkCallbackService createRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.flickr.com/services/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient());
        Retrofit retrofit = builder.build();
        return retrofit.create(NetworkCallbackService.class);
    }
}
