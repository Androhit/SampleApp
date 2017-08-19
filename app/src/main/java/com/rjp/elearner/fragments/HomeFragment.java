package com.rjp.elearner.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.rjp.elearner.R;
import com.rjp.elearner.activities.HomeActivity;
import com.rjp.elearner.adapters.WeekListAdapter;
import com.rjp.elearner.base.BaseFragment;
import com.rjp.elearner.beans.WeeksBean;
import com.rjp.elearner.helpers.DummyDataHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout sliderLayout;
    private RecyclerView rvList;


    public static String getFragmentTag() {
        return HomeFragment.class.getSimpleName();
    }

    public static BaseFragment newInstance() {
        return new HomeFragment();
    }

    private void init(View view) {
        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        rvList = (RecyclerView) view.findViewById(R.id.rvList);
    }

    private void initList() {

        ArrayList<WeeksBean> weeks = DummyDataHelper.getWeeks();

        WeekListAdapter adapt = new WeekListAdapter(getContext(), weeks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(mLayoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapt);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);

        HashMap<String, String> url_maps = DummyDataHelper.getUrls();

        for (String name : url_maps.keySet()) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            // initialize a SliderLayout
            sliderView.image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            sliderView.bundle(new Bundle());
            sliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(sliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);

        initList();
        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        sliderLayout.stopAutoCycle();

        super.onStop();
    }

}