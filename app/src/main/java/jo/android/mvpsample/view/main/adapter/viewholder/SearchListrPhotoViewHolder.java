package jo.android.mvpsample.view.main.adapter.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jo.android.mvpsample.R;
import jo.android.mvpsample.util.CustomRecyclerViewHolder;
import jo.android.mvpsample.util.GlideApp;
import jo.android.mvpsample.util.OnItemClickListener;
import jo.android.mvpsample.view.main.data.Photo;

public class SearchListrPhotoViewHolder extends CustomRecyclerViewHolder<ArrayList<Photo>> implements View.OnClickListener{

    private ImageView mIvSearchPhoto;
    private OnItemClickListener onItemClickListener;

    public SearchListrPhotoViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);

        itemView.setOnClickListener(this);
        this.onItemClickListener = onItemClickListener;
        mIvSearchPhoto = (ImageView)itemView.findViewById(R.id.iv_search_photo_item);
    }

    @Override
    public void bind(ArrayList<Photo> item, int position) {

        GlideApp.with(mIvSearchPhoto.getContext())
                .load(item.get(position).getPhotoURL())
                .centerCrop()
                .into(mIvSearchPhoto);
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(getAdapterPosition());
    }
}
