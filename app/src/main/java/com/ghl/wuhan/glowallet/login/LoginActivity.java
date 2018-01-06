package com.ghl.wuhan.glowallet.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ghl.wuhan.glowallet.MainActivity;
import com.ghl.wuhan.glowallet.R;
import com.ghl.wuhan.glowallet.utils.BaseActivity;

/**
 * 项目名称：GLOWallet
 * 类描叙：登录
 * 创建人：chenmin
 * 创建时间： 2017-12-12 15:30：20
 * 修改人：chenmin
 * 修改时间： 2017-12-12 15:30：20
 * 修改备注：
 * 版本：
 */
public class LoginActivity extends BaseActivity {

    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }


}
