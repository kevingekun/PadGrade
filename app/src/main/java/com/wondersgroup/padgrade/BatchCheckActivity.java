package com.wondersgroup.padgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wondersgroup.adapter.BatchListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批次选择
 */
public class BatchCheckActivity extends AppCompatActivity {

    private ListView lv;
    //自定义适配器
    private BatchListAdapter adapter;
    private List<Map<String,Object>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_check);
        lv = (ListView) findViewById(R.id.lv_batch_check);

        list = new ArrayList<>();
        for(int i=0;i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("title","批次名称"+i);
            map.put("address","批次地点"+i);
            map.put("time","批次时间"+i);
            list.add(map);
        }
        adapter = new BatchListAdapter(list,this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BatchCheckActivity.this,CategoryCheckActivity.class);
                startActivity(intent);
            }
        });
    }
}
