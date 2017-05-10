package com.wondersgroup.padgrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.wondersgroup.adapter.RadioListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 考评员选择考评类别
 */
public class CategoryCheckActivity extends AppCompatActivity {

    private ListView categoryList;

    private RadioListViewAdapter adapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_check);

        list.add("类别一");
        list.add("类别二");
        list.add("类别三");

        adapter = new RadioListViewAdapter(this, list);
        categoryList = (ListView) findViewById(R.id.categoryList);
        categoryList.setAdapter(adapter);
        setListViewHeightBasedOnChildren(categoryList);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {

        Adapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        int viewCount = listAdapter.getCount();
        for (int i = 0; i < viewCount; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + 10;//加10是为了适配自定义背景

        listView.setLayoutParams(params);
    }

    public void categoryConfirm(View view) {
        Intent intent = new Intent(CategoryCheckActivity.this,StudentListActivity.class);
        startActivity(intent);
    }
}
