package jo.android.mvpsample.remote.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApplicationInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder()
//                .addHeader("서버와 약속된 헤더네임", "")
                .build();
        Response response = chain.proceed(newRequest);
        return response;
    }

}
