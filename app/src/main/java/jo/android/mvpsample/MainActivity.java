package jo.android.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnClickListener{

    private TextView mTvCount;
    private Button mBtnPlus;
    private Button mBtnMinus;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);

        mTvCount = (TextView)findViewById(R.id.text);

        mBtnPlus = (Button)findViewById(R.id.bt_plus);
        mBtnPlus.setOnClickListener(this);
        mBtnMinus = (Button)findViewById(R.id.bt_minus);
        mBtnMinus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_plus:
                presenter.plusNum();
                break;
            case R.id.bt_minus:
                presenter.miunsNum();
                break;
        }
    }

    @Override
    public void updatePlus(int num) {
        mTvCount.setText(num + " count");
    }

    @Override
    public void updateMinus(int num) {
        mTvCount.setText(num + " count");
    }
}
