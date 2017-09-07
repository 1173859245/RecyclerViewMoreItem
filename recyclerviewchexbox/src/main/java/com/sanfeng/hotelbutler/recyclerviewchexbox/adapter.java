package com.sanfeng.hotelbutler.recyclerviewchexbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class adapter extends RecyclerView.Adapter<adapter.MyHolder> implements View.OnClickListener,View.OnLongClickListener {
   private List<String> list;
    private Context context;
    //是否显示单选框默认为false
    public boolean isShowBox;
    private Map<Integer,Boolean> map=new HashMap<>();
    //接口实例
    private RecyclerViewOnItemClickListener onItemClickListener;

    public adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        initMap();
    }
//初始化map集合默认为false不选中
   private  void initMap(){
       for (int i=0 ;i<list.size();i++){
         map.put(i,false);
       }
   }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyHolder holder=new MyHolder(root);
        //为Item设置点击事件
         root.setOnClickListener(this);
        root.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
            holder.textView.setText(list.get(position));
        if (isShowBox){
            holder.checkBox.setVisibility(View.VISIBLE);
        }else {
            holder.checkBox.setVisibility(View.INVISIBLE);
        }
        Animation animaation= AnimationUtils.loadAnimation(context,R.anim.list_anim);
        if (isShowBox){
            holder.checkBox.startAnimation(animaation);
        }
        //设置Tag值
        holder.root.setTag(position);
         holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            map.put(position,b);
             }
         });
        //设置ChexBox的状态
        if (map.get(position)==null){
            map.put(position,false);
        }
        holder.checkBox.setChecked(map.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null){
            //使用getTag方法获取数据
            onItemClickListener.onItemClickListener(view, (Integer) view.getTag());
        }

    }

    @Override
    public boolean onLongClick(View view) {
        //不管显示隐藏，清空状态
        initMap();
        return onItemClickListener!=null && onItemClickListener.onLongItemClickListtener(view, (Integer) view.getTag());
    }
    //设置点击事件
    public void setRecyclerViewOnItemClickListener(RecyclerViewOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    //设置是否显示CheckBox
    public void setShowBox(){
        isShowBox=!isShowBox;
    }
   //点击Item选中ChecBox
    public  void setSelectItem(int position){
        //对当前状态取反
        if (map.get(position)){
            map.put(position,false);
        }else {
            map.put(position,true);
        }
        notifyItemChanged(position);
    }
    //返回集合给MainActivity
    public Map<Integer,Boolean> getMap(){
        return map;
    }

    class MyHolder extends RecyclerView.ViewHolder {
              private TextView textView;
              private CheckBox checkBox;
              private View root;

        public MyHolder(View itemView) {
            super(itemView);
            this.root=itemView;
            textView=(TextView)itemView.findViewById(R.id.Mytext);
            checkBox=(CheckBox)itemView.findViewById(R.id.myChexBox);
        }
    }

    public  interface RecyclerViewOnItemClickListener{
        void onItemClickListener(View view,int position);
        boolean onLongItemClickListtener(View view,int position);
    }
}
