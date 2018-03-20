package jo.android.mvpsample.view.main;

public interface MainContract {

    interface View {
        void hideProgress();
        void showProgress();
    }

    interface Presenter {
        void loadFlickrImage();
    }
}
