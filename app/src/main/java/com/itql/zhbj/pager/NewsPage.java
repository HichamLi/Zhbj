package com.itql.zhbj.pager;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by HiChamLi on 2015/12/6.
 */
public class NewsPage extends BasePager {

    private Activity activity;
    public TextView tv_content;

    public NewsPage(Activity activity) {
        super(activity);
        this.activity=activity;
    }

    public void initData(){
        this.tv_head.setText("新闻");
        tv_content=new TextView(activity);
        tv_content.setText("新闻中心");
        tv_content.setTextSize(24);
        this.fl_pager_content.addView(tv_content);
        setSlidingMenuEnable(true);
    }


}
