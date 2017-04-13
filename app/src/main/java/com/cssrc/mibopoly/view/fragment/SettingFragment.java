package com.cssrc.mibopoly.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.view.activity.OpenEyeVideoActivity;
import com.cssrc.mibopoly.view.activity.SettingsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    @Bind(R.id.setTest)
    TextView textView;

    public static SettingFragment newInstance(String text){
        SettingFragment fragmentCommon=new SettingFragment();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.setTest)
    void onClick(){
        Intent intent = new Intent(this.getContext(), SettingsActivity.class);
        startActivity(intent);
    }

}
