package com.sanfeng.hotelbutler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public abstract class TypeAbsViewHolder<T> extends RecyclerView.ViewHolder {
    public TypeAbsViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHoder(T mode);


}
