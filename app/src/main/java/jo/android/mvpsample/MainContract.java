package jo.android.mvpsample;

public interface MainContract {

    interface View {
        void hideProgress();
        void showProgress();
    }

    interface Presenter {
        void setView(View view);
        void loadFlickrImage();
    }
}
