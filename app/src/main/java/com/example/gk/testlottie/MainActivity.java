package com.example.gk.testlottie;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView lottie_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lottie_view = (LottieAnimationView) findViewById(R.id.lottie_view);
        lottie_view.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                log_e("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                log_e("onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                log_e("onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                log_e("onAnimationRepeat");
            }
        });

        startAnimationWithJson("beating_heart.json");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                if (!lottie_view.isAnimating()) {
                    lottie_view.playAnimation();
                }
                break;
            case R.id.btn_pause:
                if (lottie_view.isAnimating()) {
                    lottie_view.pauseAnimation();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_1:
                startAnimationWithJson("beating_heart.json");
                break;
            case R.id.menu_2:
                startAnimationWithJson("bounching_ball.json");
                break;
            case R.id.menu_3:
                startAnimationWithJson("emoji_tongue.json");
                break;
            case R.id.menu_4:
                startAnimationWithJson("emoji_wink.json");
                break;
            case R.id.menu_5:
                startAnimationWithJson("loading.json");
                break;
            case R.id.menu_6:
                startAnimationWithJson("loading_1.json");
                break;
            default:
                break;
        }
        return true;
    }


    /**
     * 播放指定文件的动画
     *
     * @param jsonName 动画名称 带有后缀名
     */
    private void startAnimationWithJson(String jsonName) {
        lottie_view.setAnimation(jsonName);
        lottie_view.playAnimation();
    }

    /**
     * 日志输出
     *
     * @param content
     */
    private void log_e(String content) {
        Log.e("test", content);
    }
}
