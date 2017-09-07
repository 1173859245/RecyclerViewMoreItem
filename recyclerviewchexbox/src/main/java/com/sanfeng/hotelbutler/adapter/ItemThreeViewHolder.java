package com.sanfeng.hotelbutler.adapter;

import android.view.View;
import android.widget.TextView;

import com.sanfeng.hotelbutler.model.ModelThree;
import com.sanfeng.hotelbutler.model.ModelTwo;
import com.sanfeng.hotelbutler.recyclerviewchexbox.R;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class ItemThreeViewHolder extends TypeAbsViewHolder<ModelThree> {
    public TextView text;
    public ItemThreeViewHolder(View itemView) {
        super(itemView);
        text=(TextView)itemView.findViewById(R.id.text);
    }

    @Override
    public void bindHoder(ModelThree mode) {
           text.setText(mode.text);
    }


}
