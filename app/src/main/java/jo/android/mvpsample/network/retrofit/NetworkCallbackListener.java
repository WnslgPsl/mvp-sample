package jo.android.mvpsample.network.retrofit;

import android.support.annotation.Nullable;

public interface NetworkCallbackListener<T> {

    void onResponse(@Nullable T t);
    void onFailure(String msg);

}
