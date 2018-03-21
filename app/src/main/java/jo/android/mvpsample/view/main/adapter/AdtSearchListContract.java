package jo.android.mvpsample.view.main.adapter;

import android.widget.AdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jo.android.mvpsample.util.OnItemClickListener;
import jo.android.mvpsample.view.main.data.Photo;

public interface AdtSearchListContract {

    interface View {
        void updateView();
        void setOnItemClickListener(OnItemClickListener onItemClickListener);
    }

    interface Model {
        Photo getItem(int position);
        void addItems(ArrayList<Photo> photos);
    }
}
