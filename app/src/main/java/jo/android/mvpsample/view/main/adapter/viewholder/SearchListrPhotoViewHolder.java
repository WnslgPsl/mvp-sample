package jo.android.mvpsample.view.main.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jo.android.mvpsample.R;
import jo.android.mvpsample.util.CustomRecyclerViewHolder;
import jo.android.mvpsample.util.GlideApp;
import jo.android.mvpsample.view.main.data.Photo;

public class SearchListrPhotoViewHolder extends CustomRecyclerViewHolder<ArrayList<Photo>> {

    private ImageView mIvSearchPhoto;

    public SearchListrPhotoViewHolder(View itemView) {
        super(itemView);

        mIvSearchPhoto = (ImageView)itemView.findViewById(R.id.iv_search_photo_item);
    }

    @Override
    public void bind(ArrayList<Photo> item, int position) {

        GlideApp.with(mIvSearchPhoto.getContext())
                .load(item.get(position).getPhotoURL())
                .centerCrop()
                .into(mIvSearchPhoto);
    }
}
