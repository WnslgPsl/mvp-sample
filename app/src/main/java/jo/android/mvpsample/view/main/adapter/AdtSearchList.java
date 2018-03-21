package jo.android.mvpsample.view.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jo.android.mvpsample.R;
import jo.android.mvpsample.util.CustomRecyclerViewHolder;
import jo.android.mvpsample.util.OnItemClickListener;
import jo.android.mvpsample.view.main.adapter.viewholder.SearchListrPhotoViewHolder;
import jo.android.mvpsample.view.main.data.Photo;

public class AdtSearchList extends RecyclerView.Adapter<CustomRecyclerViewHolder> implements AdtSearchListContract.View,
        AdtSearchListContract.Model{

    private Context mContext;
    private ArrayList<Photo> items = new ArrayList<>();
    private OnItemClickListener onItemClickListener;


    public AdtSearchList(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_photo_item, parent, false);
        return new SearchListrPhotoViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder holder, int position) {
        holder.bind(items, position);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public void updateView() {
        notifyDataSetChanged();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Photo getItem(int position) {
        return items.get(position);
    }

    @Override
    public void addItems(ArrayList<Photo> photos) {
        items.addAll(photos);
    }
}
