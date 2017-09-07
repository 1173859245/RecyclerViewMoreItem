package com.sanfeng.hotelbutler.adapter;

import android.view.View;
import android.widget.TextView;

import com.sanfeng.hotelbutler.model.ModelThree;
import com.sanfeng.hotelbutler.model.ModelTwo;
import com.sanfeng.hotelbutler.recyclerviewchexbox.R;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class ItemTwoViewHolder extends TypeAbsViewHolder<ModelTwo> {
    public TextView text1;
    public TextView text2;
    public ItemTwoViewHolder(View itemView) {
        super(itemView);
        text1=(TextView)itemView.findViewById(R.id.item2Title);
        text2=(TextView)itemView.findViewById(R.id.item2Content);

    }

    @Override
    public void bindHoder(ModelTwo mode) {
    text1.setText(mode.title);
    text2.setText(mode.content);
    }


}
