package com.itql.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.itql.zhbj.R;
import com.itql.zhbj.pager.AffairPage;
import com.itql.zhbj.pager.BasePager;
import com.itql.zhbj.pager.HomePage;
import com.itql.zhbj.pager.NewsPage;
import com.itql.zhbj.pager.SettingPage;
import com.itql.zhbj.pager.SmartServicePage;
import com.jeremyfeinstein.slidingmenu.lib.CustomViewAbove;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by HiChamLi on 2015/11/30.
 */
public class ContentFragment extends BaseFragment {
    public static final String TAG="content_fragment";

    private ArrayList<BasePager> basePagers;

    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;

    @ViewInject(R.id.vp_content)
    private ViewPager vp_content;

    @Override
    public View initView() {
        View view=View.inflate(activity, R.layout.fragment_content,null);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void initDatas() {
        rg_main.check(R.id.rb_main_home);
        basePagers=new ArrayList<>();

        basePagers.add(new HomePage(this.activity));
        basePagers.add(new NewsPage(this.activity));
        basePagers.add(new SmartServicePage(this.activity));
        basePagers.add(new AffairPage(this.activity));
        basePagers.add(new SettingPage(this.activity));

        vp_content.setAdapter(new MyVPAdapter());
        vp_content.setOnPageChangeListener(new MyVPChange());

        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main_home:
                        vp_content.setCurrentItem(0, false);
                        break;
                    case R.id.rb_main_news:
                        vp_content.setCurrentItem(1, false);
                        break;
                    case R.id.rb_main_smart_service:
                        vp_content.setCurrentItem(2, false);
                        break;
                    case R.id.rb_main_affair:
                        vp_content.setCurrentItem(3, false);
                        break;
                    case R.id.rb_main_setting:
                        vp_content.setCurrentItem(4, false);
                        break;
                }
            }
        });

        basePagers.get(0).initData();
    }

    private class MyVPAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(basePagers.get(position).view);
            return basePagers.get(position).view ;
        }
    }

    private class MyVPChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            basePagers.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
