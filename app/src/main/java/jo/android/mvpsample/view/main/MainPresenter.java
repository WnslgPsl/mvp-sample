package jo.android.mvpsample.view.main;

import android.util.Log;
import android.widget.Toast;

import jo.android.mvpsample.BuildConfig;
import jo.android.mvpsample.remote.MainDataSource;
import jo.android.mvpsample.remote.MainRepository;
import jo.android.mvpsample.util.OnItemClickListener;
import jo.android.mvpsample.view.main.adapter.AdtSearchListContract;
import jo.android.mvpsample.view.main.data.Photo;
import jo.android.mvpsample.view.main.data.PhotoResponse;

public class MainPresenter implements MainContract.Presenter, OnItemClickListener{

    private MainContract.View view;
    private MainRepository mainRepository;
    private AdtSearchListContract.View adapterView;
    private AdtSearchListContract.Model adapterModel;

    public MainPresenter(MainContract.View view, MainRepository mainRepository,
                         AdtSearchListContract.View adapterView, AdtSearchListContract.Model adapterModel) {
        this.view = view;
        this.mainRepository = mainRepository;
        this.adapterView = adapterView;
        this.adapterModel = adapterModel;
        this.adapterView.setOnItemClickListener(this);
    }

    @Override
    public void loadFlickrImage() {

        view.showProgress();

        mainRepository.getSearchPhotos("json", "1",
                "flickr.photos.search", "LOVE", BuildConfig.FLICKR_API_KEY, 1,
                200, new MainDataSource.LoadFlickrCallback<PhotoResponse>() {
                    @Override
                    public void onSuccess(PhotoResponse photoResponse) {
                        view.hideProgress();

                        if(photoResponse.getStat().equals("ok")){
                            adapterModel.addItems(photoResponse.getPhotos().getPhoto());
                            adapterView.updateView();
                        }else{
                            view.showMessage("stat : " + photoResponse.getStat());
                        }

                    }

                    @Override
                    public void onFailure(String message) {
                        view.hideProgress();
                        view.showMessage("Failure : " + message);
                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        view.showDetailInfo(adapterModel.getItem(position).getTitle());
    }
}
