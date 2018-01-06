package com.ghl.wuhan.glowallet.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.ghl.wuhan.glowallet.customdialog.CustomToChooseDialog;
import com.ghl.wuhan.glowallet.login.LoginActivity;

import java.util.Date;

/**
 * 项目名称：GLOWallet
 * 类描叙：所有activity类的基础类，包含双击退出，单击返回登录
 * 创建人：chenmin
 * 创建时间： 2017/12/14 14:35
 * 修改人：chenmin
 * 修改时间： 2017/12/14 14:35
 * 修改备注：
 * 版本：
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // super.setContentView(R.layout.base_layout);

        AppManager.addActivity(this);
    }


    /**
     * The Prelong tim.
     */
    long prelongTim = 0;//定义上一次单击的时间
    /**
     * The Diff time.
     */
    long diffTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(prelongTim==0){//第一次单击，初始化为本次单击的时间
                prelongTim = (new Date()).getTime();
            }else{
                long curTime = (new Date()).getTime();//本地单击的时间
                diffTime = curTime-prelongTim;
                prelongTim = curTime;//当前单击事件变为上次时间
                AppUtils.showLog("middle两次单击间隔时间   ："+diffTime);//计算本地和上次的时间差
                if(diffTime <300){  //300毫秒内点击两次，算是双击
                    AppUtils.showLog("小于300ms间隔时间   ："+diffTime);//计算本地和上次的时间差
                    exit();
                }else {
                    Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
        return false;
    }

    /**
     * Exit.
     */
    public void exit() {
        CustomToChooseDialog retDialog;
        CustomToChooseDialog.Builder customBuilder = new
                CustomToChooseDialog.Builder(BaseActivity.this);

        customBuilder.setTitle(AppUtils.APP_NAME);
        customBuilder.setMessage("             Are you sure to exit app?              ");
        customBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                AppManager.AppExit(BaseActivity.this);
                finish();
                System.exit(0);

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        prelongTim = 0;
                        dialog.dismiss();
                    }

                });
        retDialog = customBuilder.create();
        retDialog.show();
    }


}
