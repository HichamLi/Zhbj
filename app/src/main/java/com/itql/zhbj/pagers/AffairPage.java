package com.itql.zhbj.pagers;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by HiChamLi on 2015/12/6.
 */
public class AffairPage extends BasePager {

    private Activity activity;
    public TextView tv_content;

    public AffairPage(Activity activity) {
        super(activity);
        this.activity=activity;
    }

    public void initData(){
        this.tv_head.setText("政务");
        tv_content=new TextView(activity);
        tv_content.setText("政务");
        tv_content.setTextSize(24);
        this.fl_pager_content.addView(tv_content);
        setSlidingMenuEnable(true);
    }


}
