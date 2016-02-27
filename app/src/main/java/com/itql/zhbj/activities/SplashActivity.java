package com.itql.zhbj.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.itql.zhbj.R;
import com.itql.zhbj.utils.SPUtils;


public class SplashActivity extends AppCompatActivity {

    private RelativeLayout rl_splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        startAnim();
    }

    private void init(){
        rl_splash= (RelativeLayout) findViewById(R.id.rl_splash);
    }

    private void startAnim(){
        AnimationSet animationSet=new AnimationSet(false);

        RotateAnimation rotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               jumpNextPage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rl_splash.startAnimation(animationSet);
    }

    private void jumpNextPage(){
        boolean isFirstUserGuide= SPUtils.getBoolean(SplashActivity.this, "isFirstUserGuide", false);

        if(!isFirstUserGuide){
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
            finish();
        }else{
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
        }
    }
}
