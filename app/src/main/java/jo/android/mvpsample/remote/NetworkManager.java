package jo.android.mvpsample.remote;

import android.content.Context;

import jo.android.mvpsample.util.NetworkDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkManager<T> {

    private Context mContext;
    private boolean mNetworkDialogCheck;
    private NetworkDialog mNetworkDialog;
    private Call<T> call;

    public NetworkManager(Context mContext, Call<T> call, boolean mNetworkDialogCheck){
        this.mContext = mContext;
        this.call = call;
        this.mNetworkDialogCheck = mNetworkDialogCheck;

        mNetworkDialog = new NetworkDialog(mContext);

        if(mNetworkDialog != null && mNetworkDialogCheck){
            mNetworkDialog.showNetworkDialog();
        }
    }

    public void setOnStartNetworkListener(final NetworkCallbackListener mNetworkCallbackListener){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.body() != null) {
                    mNetworkCallbackListener.onResponse(response.body());
                }

                if(mNetworkDialog != null && mNetworkDialogCheck){
                    mNetworkDialog.dismissNetworkDialog();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                mNetworkCallbackListener.onFailure(t.getMessage().toString());

                if(mNetworkDialog != null && mNetworkDialogCheck){
                    mNetworkDialog.dismissNetworkDialog();
                }

            }
        });
    }


}
