package com.example.danny.xfermode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.danny.xfermode.XferModeView.BollProgressBar;

public class MainActivity extends Activity {

    private BollProgressBar bollProgressBar;
    private static final int PROGRESS= 0X0003;
    //定义一个进度
    private int progress;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case PROGRESS:
                    progress++;
                    if (progress <= 100) {
                        bollProgressBar.setCurrentProgress(progress);
                        sendEmptyMessageDelayed(PROGRESS, 100);
                    }
                    break;
                default:
                    break;
            }
        }
    };
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            bollProgressBar = (BollProgressBar) findViewById(R.id.bollProgressBar);

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.sendEmptyMessageDelayed(PROGRESS, 1000);
                }
            });

        }
}
