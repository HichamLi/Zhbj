package com.itql.zhbj.activities;


import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.itql.zhbj.R;
import com.itql.zhbj.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private RelativeLayout rl_guide;
    private LinearLayout ly_guide_point;
    private ViewPager vp_guide;
    private int[] imageViews;
    private List<ImageView> imageViewList;
    private View v_guide_red_point;
    private int distanceOfPoint;
    private Button btn_guide_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        init();

    }

    private void init(){
        rl_guide= (RelativeLayout) findViewById(R.id.rl_guide);
        ly_guide_point= (LinearLayout) findViewById(R.id.ly_guide_point);

        initGuideImage();

        vp_guide= (ViewPager) findViewById(R.id.vp_guide);
        vp_guide.setAdapter(new MyVPAdapter());
        vp_guide.addOnPageChangeListener(new MyPageChangeListener());
        initPoint();
        btn_guide_start= (Button) findViewById(R.id.btn_guide_start);
        btn_guide_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.setBoolean(GuideActivity.this, "isFirstUserGuide", true);
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    /**
     * 初始化引导图片
     */
    private void initGuideImage() {
        imageViews=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        imageViewList=new ArrayList<>();
        for(int i=0;i<imageViews.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(imageViews[i]);
            imageViewList.add(imageView);
        }
    }

    /**
     * 初始化圆点并附着在引导图片上
     */
    private void initPoint(){
        for(int i=0;i<imageViews.length;i++){
            View view=new View(this);
            view.setBackgroundResource(R.drawable.guide_gray_point);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(10,10);
            if(i>0){
                layoutParams.leftMargin=20;
            }
            view.setLayoutParams(layoutParams);
            ly_guide_point.addView(view);
        }
        ly_guide_point.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                distanceOfPoint=ly_guide_point.getChildAt(1).getLeft()-ly_guide_point.getChildAt(0).getLeft();
                ly_guide_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        v_guide_red_point=findViewById(R.id.v_guide_red_point);
    }

    private class MyVPAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) v_guide_red_point.getLayoutParams();
            layoutParams.leftMargin= (int) (distanceOfPoint * positionOffset) + position * distanceOfPoint;
            v_guide_red_point.setLayoutParams(layoutParams);
        }

        @Override
        public void onPageSelected(int position) {
            if(position==imageViews.length-1){
                btn_guide_start.setVisibility(View.VISIBLE);
            }else{
                btn_guide_start.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
