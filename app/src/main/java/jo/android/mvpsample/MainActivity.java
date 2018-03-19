package jo.android.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import jo.android.mvpsample.util.NetworkDialog;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnClickListener{

    private MainContract.Presenter presenter;
    private NetworkDialog mNetworkDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);
        mNetworkDialog = new NetworkDialog(MainActivity.this);

        presenter.loadFlickrImage();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public void hideProgress() {
        if(mNetworkDialog != null && mNetworkDialog.isShowing()){
            mNetworkDialog.dismissNetworkDialog();
        }
    }

    @Override
    public void showProgress() {
        if(mNetworkDialog != null && !mNetworkDialog.isShowing()){
            mNetworkDialog.showNetworkDialog();
        }
    }
}
