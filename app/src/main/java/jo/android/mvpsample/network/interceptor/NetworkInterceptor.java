package jo.android.mvpsample.network.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor{

    private static final String TAG = NetworkInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Log.d(TAG, "intercept : request method " + request.method());
        Log.d(TAG, "intercept : request url " + request.headers());
        Log.d(TAG, "intercept : request connection " + chain.connection());

        Log.d(TAG, "/////////////////////////////////////////////////////////////////");
        Response response = chain.proceed(request);
        Log.d(TAG, "intercept : response requested url " + response.request().url());
        Log.d(TAG, "intercept : response header" + response.headers());
        Log.d(TAG, "intercept : response code" + response.code());

        switch (response.code()){
            case 200:
                Log.d(TAG, "network error : 성공");
                break;
            case 401:
                Log.d(TAG, "network error : 401 에러");
                Request newRequest1 = request.newBuilder()
//                        .head()
                        .build();
                response = chain.proceed(newRequest1);
                break;
            case 500:
                Log.d(TAG, "network error : 500 서버 에러");
                break;
        }

        return response;
    }
}
