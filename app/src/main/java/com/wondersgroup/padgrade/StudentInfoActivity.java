package com.wondersgroup.padgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_student_info)
public class StudentInfoActivity extends AppCompatActivity {

    @ViewInject(R.id.checkQuestion)
    private Button checkQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTitle(R.string.app_student_detail);
    }
    @Event(value = R.id.checkQuestion,type = View.OnClickListener.class)
    private void checkQuestionBtnOnClick(View view){
        Intent intent = new Intent(this,QuestionActivity.class);
        startActivity(intent);
    }
}
