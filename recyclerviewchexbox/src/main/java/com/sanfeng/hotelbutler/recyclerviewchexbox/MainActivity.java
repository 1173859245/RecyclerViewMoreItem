package com.sanfeng.hotelbutler.recyclerviewchexbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
  private Button selectAll;
    private Button noAllSeclect;
    private Button submit;
    private  adapter  ad;
    private List<String>  datas;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.myRecy);
        initData();
        ad=new adapter(datas,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
        //添加分割线
        recyclerView.addItemDecoration(new MyDecoration(this,MyDecoration.VERTICAL_LIST));
        ad.setRecyclerViewOnItemClickListener(new adapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                ad.setSelectItem(position);
            }

            @Override
            public boolean onLongItemClickListtener(View view, int position) {
                ad.setShowBox();
                //设置选中的项
                ad.setSelectItem(position);
                ad.notifyDataSetChanged();
                return true;
            }
        });
        selectAll=(Button)findViewById(R.id.selctall);
        noAllSeclect=(Button)findViewById(R.id.allnoselct);
        submit=(Button)findViewById(R.id.submit);
        //全选
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<Integer ,Boolean> map=ad.getMap();
                for (int i=0;i<map.size();i++){
                    map.put(i,true);
                    ad.notifyDataSetChanged();
                }
            }
        });

        //全不选
        noAllSeclect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<Integer ,Boolean> map=ad.getMap();
                for (int i=0;i<map.size();i++){
                    map.put(i,false);
                    ad.notifyDataSetChanged();
                }
            }
        });

        //选中的提交
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<Integer ,Boolean> map=ad.getMap();
                for (int i=0;i<map.size();i++){
                    if (map.get(i)){
                        Log.d("TAG", "你选了第：" + i + "项");
                        Log.d("TAG", datas.get(i));
                    }
                }
            }
        });
    }


    private void initData(){
        datas=new ArrayList<>();
        datas.add("张三");
        datas.add("李四");
        datas.add("王二");
        datas.add("麻子");
        datas.add("小三");
        datas.add("小四");

    }
}
