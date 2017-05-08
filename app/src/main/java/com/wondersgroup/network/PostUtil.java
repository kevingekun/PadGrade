package com.wondersgroup.network;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wondersgroup.padgrade.Test;

import net.sf.json.JSONObject;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buger on 17/5/4/004.
 */

public class PostUtil {
    /**
     *以get方式获取数据
     * @param params
     * @return
     */
    public static void post(RequestParams params,final NetWorkReceiver receiver){

        x.http().post(params, new Callback.CommonCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                //解析result
                //如果服务返回304或onCache选择了信任缓存,这时result为null
                Log.i("Login", "开始请求");
                if (result != null) {
                    this.result = result;
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
                if (ex instanceof HttpException) { //网络错误
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
                    Toast.makeText(x.app(), responseMsg, Toast.LENGTH_LONG).show();
                } else { //其他错误
                    Toast.makeText(x.app(), "系统出错", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
                if (!hasError && result != null) {
                    //成功获取数据
                    //Toast.makeText(x.app(), result, Toast.LENGTH_LONG).show();
                    Test jsonObject = new Gson().fromJson(result,Test.class);
                    receiver.onSuccess(jsonObject);
                }
            }
        });
    }
}
