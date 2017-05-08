package com.wondersgroup.padgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentListActivity extends AppCompatActivity {

    private ListView studentlist;

    private String[] zkz = { "201701012921", "201701012922", "201701012923", "201701012924" };

    private String[] xm = { "张三", "李四", "王五", "赵六" };

    private String[] sfz = { "370283199002023292", "370283199002023292", "370283199002023292", "370283199002023292" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        //Toast.makeText(getApplicationContext(),"batchlist",Toast.LENGTH_SHORT).show();
        final List<Map<String, Object>> listems = new ArrayList<>();
        for (int i = 0; i < zkz.length; i++) {
            Map<String, Object> listem = new HashMap<>();
            listem.put("zkz", zkz[i]);
            listem.put("xm", xm[i]);
            listem.put("sfz", sfz[i]);
            listems.add(listem);
        }
        /*SimpleAdapter的参数说明
         * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
         * 第二个参数表示生成一个Map(String ,Object)列表选项
         * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
         * 第四个参数表示该Map对象的哪些key对应value来生成列表项
         * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
         * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
         * 下面的程序中如果 new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
         * 这个head的组件会被name资源覆盖
         * */
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.student_list, new String[] { "zkz", "xm","sfz" },
                new int[] {R.id.zkz,R.id.xm,R.id.sfz});

        studentlist=(ListView)findViewById(R.id.studentlist);
        studentlist.setAdapter(simplead);

        studentlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(StudentListActivity.this, zkz[i],Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StudentListActivity.this,StudentInfoActivity.class);
                startActivity(intent);
            }
        });

    }
}
