package jo.android.mvpsample.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import jo.android.mvpsample.R;
import jo.android.mvpsample.remote.MainRepository;
import jo.android.mvpsample.util.NetworkDialog;
import jo.android.mvpsample.view.main.adapter.AdtSearchList;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnClickListener{

    private MainContract.Presenter presenter;
    private NetworkDialog mNetworkDialog;

    private RecyclerView mRvSearchList;
    private GridLayoutManager mGridLayoutManager;
    private AdtSearchList mAdtSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvSearchList = (RecyclerView)findViewById(R.id.rv_search_list);
        mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRvSearchList.setLayoutManager(mGridLayoutManager);

        mAdtSearchList = new AdtSearchList(MainActivity.this);
        mRvSearchList.setAdapter(mAdtSearchList);

        presenter = new MainPresenter(this, MainRepository.getFlickrRepository(), mAdtSearchList, mAdtSearchList);
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

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailInfo(String title) {
        Toast.makeText(MainActivity.this, "Photo Title : " + title, Toast.LENGTH_SHORT).show();
    }
}
