package com.wondersgroup.padgrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A login screen that offers login via email/password.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewInject(R.id.username)
    private EditText username;

    @ViewInject(R.id.password)
    private EditText password;

    @ViewInject(R.id.login)
    private Button login;

    @ViewInject(R.id.showPassCheckBox)
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        password.setCursorVisible(false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                password.setSelection(password.getText().length());
            }
        });
    }

    @Event(value = R.id.login, type = View.OnClickListener.class)
    private void loginButtonOnClick(View v) {
       // Intent intent = new Intent(LoginActivity.this,CategoryCheckActivity.class);
        Intent intent = new Intent(LoginActivity.this,BatchCheckActivity.class);
        startActivity(intent);
      /*  String url = "http://172.16.6.99:8080/ExamManagementServer/MobilePayServerAction/test.action";
        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("username", "abc");
        params.addQueryStringParameter("password", "123");
        // 默认缓存存活时间, 单位:毫秒（如果服务器没有返回有效的max-age或Expires则参考）
        params.setCacheMaxAge(1000 * 60);
        PostUtil.post(params, new NetWorkReceiver() {
            @Override
            public void onSuccess(Object obj) {
                Test test = (Test) obj;
                Toast.makeText(LoginActivity.this,test.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });*/
    }

}

