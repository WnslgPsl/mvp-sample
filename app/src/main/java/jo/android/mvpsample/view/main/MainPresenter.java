package jo.android.mvpsample.view.main;

import jo.android.mvpsample.BuildConfig;
import jo.android.mvpsample.remote.MainDataSource;
import jo.android.mvpsample.remote.MainRepository;
import jo.android.mvpsample.view.main.adapter.AdtSearchListContract;
import jo.android.mvpsample.view.main.data.PhotoResponse;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view = null;
    private MainRepository mainRepository;
    private AdtSearchListContract.View adapterView;
    private AdtSearchListContract.Model adapterModel;

    public MainPresenter(MainContract.View view, MainRepository mainRepository,
                         AdtSearchListContract.View adapterView, AdtSearchListContract.Model adapterModel){
        this.view = view;
        this.mainRepository = mainRepository;
        this.adapterView = adapterView;
        this.adapterModel = adapterModel;
    }

    @Override
    public void loadFlickrImage() {

        view.showProgress();

        mainRepository.getSearchPhotos("json", "1",
                "flickr.photos.search", "ogm", BuildConfig.FLICKR_API_KEY, 1,
                20, new MainDataSource.LoadFlickrCallback<PhotoResponse>() {
                    @Override
                    public void onSuccess(PhotoResponse photoResponse) {
                        view.hideProgress();

                        if(photoResponse.getStat().equals("ok")){
                            adapterModel.addItems(photoResponse.getPhotos().getPhoto());
                            adapterView.updateView();
                        }else{
                            //TODO: ok가 아닐 시 액티비티로 상태값 전달
                        }

                    }

                    @Override
                    public void onFailure(String message) {
                        view.hideProgress();
                        //TODO: ok가 아닐 시 액티비티로 상태값 전달
                    }
                });
    }

}
