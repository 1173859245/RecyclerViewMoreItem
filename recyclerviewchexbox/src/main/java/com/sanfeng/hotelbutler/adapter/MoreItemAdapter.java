package com.sanfeng.hotelbutler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.sanfeng.hotelbutler.model.ModelOne;
import com.sanfeng.hotelbutler.model.ModelThree;
import com.sanfeng.hotelbutler.model.ModelTwo;
import com.sanfeng.hotelbutler.recyclerviewchexbox.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class MoreItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ONE_ITEM=0;
    public static final int TWO_ITEM=1;
    public static final int Three_ITEM=2;



    private LayoutInflater layoutInflater;
    private List<ModelThree> datas;
    private ModelTwo data2;
    private ModelOne data1;

    public MoreItemAdapter(List<ModelThree> datas,ModelTwo modelTwo,ModelOne modelOne, Context context) {
        this.datas = datas;
        this.data2=modelTwo;
        this.data1=modelOne;
        layoutInflater=LayoutInflater.from(context);
    }

    public static OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface OnItemClickListener {
        void onClick(View view, int position,String text);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case ONE_ITEM :
                return new ItemOneViewHolder(layoutInflater.inflate(R.layout.item1,parent,false));
            case TWO_ITEM:
                return new ItemTwoViewHolder(layoutInflater.inflate(R.layout.item2,parent,false));
             case Three_ITEM:
              return new ItemThreeViewHolder(layoutInflater.inflate(R.layout.grid_item,parent,false));

        }


      return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         int typePosition=getItemViewType(position);
        switch (typePosition){
            case ONE_ITEM :
                ((ItemOneViewHolder)holder).bindHoder(data1);
                break;
            case TWO_ITEM:
                ((ItemTwoViewHolder)holder).bindHoder(data2);
                break;
            case Three_ITEM:
                ((ItemThreeViewHolder)holder).bindHoder(datas.get(position-2));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ONE_ITEM;
        }else if (position==1){
            return TWO_ITEM;
        }else {
            return Three_ITEM;
        }


    }

    @Override
    public int getItemCount() {
        return datas.size()==0?2:datas.size()+2;
    }
}
