package com.wondersgroup.padgrade;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


public class MarkChartActivity extends AppCompatActivity {

    @ViewInject(R.id.mtv)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_mark);
        GridLayout gridLayout = new GridLayout(this);

        TextView textView1 = new TextView(this);
        textView1.setWidth(200);
        textView1.setText("hello");
        textView1.setBackgroundColor(Color.RED);

        gridLayout.addView(textView1);

        setContentView(gridLayout);

       /* LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPadding(5,5,5,5);

        Button btn1=new Button(this);
        Button btn2=new Button(this);
        btn1.setText("Button1");
        btn2.setText("Button2");

        ll.addView(btn1);
        ll.addView(btn2);
        setContentView(ll);*/
    }
}
