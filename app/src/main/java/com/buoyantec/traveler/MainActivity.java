package com.buoyantec.traveler;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.buoyantec.traveler.bean.Tab;
import com.buoyantec.traveler.fragment.ListFragment;
import com.buoyantec.traveler.fragment.EyeFragment;
import com.buoyantec.traveler.fragment.CollectFragment;
import com.buoyantec.traveler.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LayoutInflater mInflater; // view的读取

    private FragmentTabHost mTabHost;

    private List<Tab> mTabs = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPage();
    }

    private void initPage(){
        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        Tab tab_list = new Tab(R.string.icon_list, R.drawable.selector_icon_list, ListFragment.class);
        Tab tab_eye = new Tab(R.string.icon_eye, R.drawable.selector_icon_eye, EyeFragment.class);
        Tab tab_collect = new Tab(R.string.icon_collect, R.drawable.selector_icon_collect, CollectFragment.class);
        Tab tab_me = new Tab(R.string.icon_me, R.drawable.selector_icon_me, MeFragment.class);

        mTabs.add(tab_list);
        mTabs.add(tab_eye);
        mTabs.add(tab_collect);
        mTabs.add(tab_me);

        for(Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        // 默认选择第一个
        mTabHost.setCurrentTab(0);

        //TODO 重新截图Tab
        //TODO 替换logo
        //TODO 底部线条添加
        //TODO 去除Tab分割线
    }

    private View buildIndicator(Tab tab){
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.text_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return view;
    }
}
