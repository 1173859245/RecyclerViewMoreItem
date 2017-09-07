package com.sanfeng.hotelbutler.recyclerviewchexbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sanfeng.hotelbutler.adapter.MoreItemAdapter;
import com.sanfeng.hotelbutler.model.ModelOne;
import com.sanfeng.hotelbutler.model.ModelThree;
import com.sanfeng.hotelbutler.model.ModelTwo;

import java.util.ArrayList;
import java.util.List;

public class MoreItemActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
   private MoreItemAdapter adapter;
    private ModelOne data1;
    private ModelTwo data2;
    private List<ModelThree> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_item);
        inintData();
        initView();
    }

    private void inintData() {
        data1=new ModelOne();
        data1.text1="我是第一Item(0)!!!";
        data1.text2="我是第一Item(1)!!!";

        data2=new ModelTwo();
        data2.title="我是第二ItemTitle!!!";
        data2.content="我是第二ItemContent!!!";


        datas=new ArrayList<>();

        for (int i=0;i<10;i++){
            ModelThree data=new ModelThree();
            data.text="我是第三种数据"+i;
            datas.add(data);
        }

    }

    private void initView() {
        adapter=new MoreItemAdapter(datas,data2,data1,this);
        recyclerView=(RecyclerView)findViewById(R.id.myRecyClerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MoreItemActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(new MoreItemAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position, String text) {
                Toast.makeText(MoreItemActivity.this,text+position,Toast.LENGTH_LONG).show();
            }
        });
    }
}
