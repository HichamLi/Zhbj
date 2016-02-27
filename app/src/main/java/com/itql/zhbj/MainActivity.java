package com.itql.zhbj;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.itql.zhbj.fragment.ContentFragment;
import com.itql.zhbj.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){

        //设置侧边栏
        setBehindContentView(R.layout.left_menu);

        //获取侧边栏对象
        SlidingMenu slidingMenu=getSlidingMenu();

        //设置为左
        slidingMenu.setMode(SlidingMenu.LEFT);

        //设置全屏触摸
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置预留屏幕宽度
        slidingMenu.setBehindOffset(200);

        initFragment();

    }

    private void initFragment(){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_left_menu,new LeftMenuFragment(),LeftMenuFragment.TAG);
        fragmentTransaction.replace(R.id.fl_main,new ContentFragment(),ContentFragment.TAG);

        fragmentTransaction.commit();
    }
}
