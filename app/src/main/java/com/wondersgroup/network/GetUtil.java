package com.wondersgroup.network;

import android.util.Log;
import android.widget.Toast;


import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buger on 17/5/4/004.
 */

public class GetUtil {
    /**
     *以get方式获取数据
     * @param params
     * @return
     */
    public static JSONObject get(RequestParams params){

        final List<JSONObject> list = new ArrayList<>();

        x.http().get(params, new Callback.CacheCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public boolean onCache(String result) { //得到缓存数据, 缓存过期后不会进入
                this.result = result;
                return true; //true: 信任缓存数据, 不再发起网络请求; false不信任缓存数据
            }

            @Override
            public void onSuccess(String result) {
                //如果服务返回304或onCache选择了信任缓存,这时result为null
                Log.i("JAVA", "开始请求");
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
                    Toast.makeText(x.app(), result, Toast.LENGTH_LONG).show();
                    //list.add(JSONObject.fromObject(result));
                }
            }
        });
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }
}
