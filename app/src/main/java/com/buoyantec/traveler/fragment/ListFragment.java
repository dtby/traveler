package com.buoyantec.traveler.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buoyantec.traveler.R;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

/**
 * Created by fw on 15/10/14.
 */
public class ListFragment extends Fragment {

    private SliderLayout sliderShow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_fragment, null);
        sliderShow = (SliderLayout) view.findViewById(R.id.slider);
        initSlider();
        return view;
    }

    private void initSlider(){
        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView
                .description("Game of Thrones")
                .image(R.mipmap.ic_launcher);

        sliderShow.addSlider(textSliderView);
    }
}
