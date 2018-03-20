package jo.android.mvpsample.view.main.adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jo.android.mvpsample.view.main.data.Photo;

public interface AdtSearchListContract {

    interface View {
        void updateView();
    }

    interface Model {
        void addItems(ArrayList<Photo> photos);
    }
}
