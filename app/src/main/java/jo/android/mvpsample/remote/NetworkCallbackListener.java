package jo.android.mvpsample.remote;

import android.support.annotation.Nullable;

public interface NetworkCallbackListener<T> {

    void onResponse(@Nullable T t);
    void onFailure(String msg);

}
