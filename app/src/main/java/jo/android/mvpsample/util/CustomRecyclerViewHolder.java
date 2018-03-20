package jo.android.mvpsample.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class CustomRecyclerViewHolder<T> extends RecyclerView.ViewHolder{

    public CustomRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T item, int position);
}
