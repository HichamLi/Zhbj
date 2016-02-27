package com.itql.zhbj.fragments;

import android.view.View;

import com.itql.zhbj.R;

/**
 * Created by HiChamLi on 2015/11/30.
 */
public class LeftMenuFragment extends BaseFragment {
    public static final String TAG="left_menu_fragment";

    @Override
    public View initView() {
        View view=View.inflate(activity, R.layout.fragment_left_menu,null);
        return view;
    }
}
