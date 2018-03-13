package jo.android.mvpsample;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view = null;
    private int num = 0;

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void plusNum() {
        num += 1;
        view.updatePlus(num);
    }

    @Override
    public void miunsNum() {
        num -= 1;
        view.updateMinus(num);
    }

}
