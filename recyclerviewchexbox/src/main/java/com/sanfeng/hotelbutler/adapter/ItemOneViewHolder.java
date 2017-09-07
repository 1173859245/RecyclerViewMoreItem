package com.sanfeng.hotelbutler.adapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.sanfeng.hotelbutler.model.ModelOne;
import com.sanfeng.hotelbutler.recyclerviewchexbox.R;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class ItemOneViewHolder extends TypeAbsViewHolder<ModelOne> implements View.OnClickListener  {
    public TextView textViewTitle;
    public TextView textViewContent;
    public ItemOneViewHolder(View itemView) {
        super(itemView);
        textViewTitle=(TextView)itemView.findViewById(R.id.item1TextTitle);
        textViewContent=(TextView)itemView.findViewById(R.id.item1Text);

    }

    @Override
    public void bindHoder(ModelOne mode) {
      textViewTitle.setText(mode.text1);
      textViewContent.setText(mode.text2);
      itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
     if (MoreItemAdapter.clickListener!=null){
         MoreItemAdapter.clickListener.onClick(itemView,getAdapterPosition(),textViewTitle.getText().toString());
     }
    }
}
