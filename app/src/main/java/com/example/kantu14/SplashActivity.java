package com.example.kantu14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final int HANDLER_MSG_OPEN_NEW = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            boolean hasLogin = true;
            if (msg.what == HANDLER_MSG_OPEN_NEW){
                //TODO.根据登录状态给hasLogin赋值
                hasLogin = SharedPreferencesUtil.getInstance(SplashActivity.this).isLogin();
                Intent intent = null;

                if (hasLogin) {

                    intent = new Intent(SplashActivity.this, MainActivity.class);

                }else{

//                    intent = new Intent(SplashActivity.this,ValidatorUtils.class);

                }
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(HANDLER_MSG_OPEN_NEW);
            }
        }, 3000);
    }
}
