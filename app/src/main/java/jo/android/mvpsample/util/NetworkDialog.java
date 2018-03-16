package jo.android.mvpsample.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Window;

import jo.android.mvpsample.R;

public class NetworkDialog extends Dialog{

    public NetworkDialog(@NonNull Context context) {
        super(context);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.network_dialog);
        setCancelable(false);

    }

    public void showNetworkDialog(){
        if(!this.isShowing()) {
            this.show();
        }
    }

    public void dismissNetworkDialog() {
        if(this.isShowing()) {
            this.dismiss();
        }
    }

}
