package com.wondersgroup.padgrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchListActivity extends AppCompatActivity {

    private ListView batchlist;

    private String[] pcmc = { "201701012921焊工五级", "201701012922育婴师三级", "201701012923计算机操作员五级", "201701012924钳工四级" };

    private String[] address = { "辽阳西路221号", "辽阳西路221号", "辽阳西路221号", "辽阳西路221号辽阳西路221号辽阳西路221号" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_check);

        final List<Map<String, Object>> listems = new ArrayList<>();
        for (int i = 0; i < pcmc.length; i++) {
            Map<String, Object> listem = new HashMap<>();
            listem.put("pcmc", pcmc[i]);
            listem.put("exam_address", address[i]);
            listems.add(listem);
        }

        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.batch_list, new String[] { "pcmc", "exam_address"},
                new int[] {R.id.pcmc,R.id.exam_address});

        batchlist=(ListView)findViewById(R.id.lv_batch_check);
        batchlist.setAdapter(simplead);

        batchlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(BatchListActivity.this, pcmc[i],Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BatchListActivity.this,CategoryCheckActivity.class);
                startActivity(intent);
            }
        });


    }
}
