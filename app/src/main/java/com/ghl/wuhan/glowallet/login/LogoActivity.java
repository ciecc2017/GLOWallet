package com.ghl.wuhan.glowallet.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.ghl.wuhan.glowallet.R;

/**
 * 项目名称：GLOWallet
 * 类描叙：Logo 启动
 * 创建人：chenmin
 * 创建时间： 2017-12-12 15:30：20
 * 修改人：chenmin
 * 修改时间： 2017-12-12 15:30：20
 * 修改备注：
 * 版本：
 */
public class LogoActivity extends Activity {

    private Handler myhandler = new Handler();
    private ImageView iv_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        startAlphaAnimation();
        myhandler.postDelayed(r, 3000);

    }


    public void startAlphaAnimation(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(3000);
        iv_logo.startAnimation(alphaAnimation);

    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setClass(LogoActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        if(myhandler!=null){
            myhandler.removeCallbacks(r);
            myhandler = null;
        }
        super.onDestroy();
    }


}
