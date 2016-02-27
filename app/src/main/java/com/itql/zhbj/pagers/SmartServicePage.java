package com.itql.zhbj.pagers;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by HiChamLi on 2015/12/6.
 */
public class SmartServicePage extends BasePager {

    private Activity activity;
    public TextView tv_content;

    public SmartServicePage(Activity activity) {
        super(activity);
        this.activity=activity;
    }

    public void initData(){
        this.tv_head.setText("智慧服务");
        tv_content=new TextView(activity);
        tv_content.setText("智慧服务");
        tv_content.setTextSize(24);
//        tv_content.setGravity(Gravity.CENTER);
        this.fl_pager_content.addView(tv_content);

        setSlidingMenuEnable(true);
    }


}
