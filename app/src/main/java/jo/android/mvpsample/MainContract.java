package jo.android.mvpsample;

public interface MainContract {

    interface View {
        void updatePlus(int num);
        void updateMinus(int num);
    }

    interface Presenter {
        void setView(View view);
        void plusNum();
        void miunsNum();
    }
}
