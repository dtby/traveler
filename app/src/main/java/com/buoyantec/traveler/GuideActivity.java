package com.buoyantec.traveler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;


public class GuideActivity extends Activity {

    private SliderLayout sliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initSlider();

        Button startBtn = (Button) findViewById(R.id.start_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, LoginActivity.class) );
            }
        });
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

    }
}
