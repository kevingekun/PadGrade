package com.wondersgroup.padgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_question)
public class QuestionActivity extends AppCompatActivity {

    @ViewInject(R.id.question)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTitle(R.string.app_question);
    }

    @Event(value = R.id.markChart,type = View.OnClickListener.class)
    private void markChartBtnOnClick(View view){
        Intent intent = new Intent(this,MarkChartActivity.class);
        startActivity(intent);
    }
}
