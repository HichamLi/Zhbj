package com.itql.zhbj.pager;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.itql.zhbj.R;

/**
 * Created by HiChamLi on 2015/12/6.
 */
public class HomePage extends BasePager {

    private Activity activity;
    public TextView tv_content;

    public HomePage(Activity activity) {
        super(activity);
        this.activity=activity;
    }

    public void initData(){
        this.tv_head.setText("智慧北京");
        tv_content=new TextView(activity);
        tv_content.setText("智慧北京");
        tv_content.setTextSize(24);
        this.fl_pager_content.addView(tv_content);
        setSlidingMenuEnable(false);
        ib_menu.setVisibility(View.INVISIBLE);
    }


}
