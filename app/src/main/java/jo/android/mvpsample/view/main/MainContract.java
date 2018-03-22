package jo.android.mvpsample.view.main;

import jo.android.mvpsample.view.main.data.Photo;

public interface MainContract {

    interface View {
        void hideProgress();
        void showProgress();
        void showMessage(String message);
        void showDetailInfo(String title);
    }

    interface Presenter {
        void loadFlickrImage();
    }
}
