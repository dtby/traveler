package com.buoyantec.traveler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;


public class GuideActivity extends Activity {

    private SliderLayout sliderShow;
    private PagerIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initSlider();
    }

    private void initSlider(){
        sliderShow = (SliderLayout) findViewById(R.id.slider);

        DefaultSliderView textSliderView1 = new DefaultSliderView(this);
        textSliderView1
                .image(R.mipmap.ic_guide_1);

        DefaultSliderView textSliderView2 = new DefaultSliderView(this);
        textSliderView2
                .image(R.mipmap.ic_guide_2);

        DefaultSliderView textSliderView3 = new DefaultSliderView(this);
        textSliderView3
                .image(R.mipmap.ic_guide_3);

        DefaultSliderView textSliderView4 = new DefaultSliderView(this);
        textSliderView4
                .image(R.mipmap.ic_guide_4);

        DefaultSliderView textSliderView5 = new DefaultSliderView(this);
        textSliderView5
                .image(R.mipmap.ic_guide_5);

        sliderShow.addSlider(textSliderView1);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);
        sliderShow.addSlider(textSliderView4);
        sliderShow.addSlider(textSliderView5);

        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setDuration(3000);
        sliderShow.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 4){
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                        }
                    }, 2000);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );

    }
}
