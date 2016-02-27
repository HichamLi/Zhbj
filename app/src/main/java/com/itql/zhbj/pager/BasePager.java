package com.itql.zhbj.pager;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itql.zhbj.MainActivity;
import com.itql.zhbj.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by HiChamLi on 2015/12/6.
 */
public class BasePager {

    private Context context;

    public View view;

    public RelativeLayout rl_pager_head;
    public FrameLayout fl_pager_content;
    public TextView tv_head;
    public ImageButton ib_menu;

    public BasePager(Context context){
        this.context=context;
        initView();
    }


    public void initView(){
        view=View.inflate(context, R.layout.pager_layout,null);
        tv_head= (TextView) view.findViewById(R.id.tv_head);
        fl_pager_content= (FrameLayout) view.findViewById(R.id.fl_pager_content);
        rl_pager_head= (RelativeLayout) view.findViewById(R.id.rl_pager_head);
        ib_menu= (ImageButton) view.findViewById(R.id.ib_menu);
    }

    public void initData(){

    }

    public void setSlidingMenuEnable(boolean enable){
        MainActivity mainActivity= (MainActivity) context;
        if(enable){
            mainActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else{
            mainActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}
