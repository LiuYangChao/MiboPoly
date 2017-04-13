package com.cssrc.mibopoly.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssrc.mibopoly.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoubanFragment extends Fragment {

    public static DoubanFragment newInstance(String text){
        DoubanFragment fragmentCommon=new DoubanFragment();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    public DoubanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_douban, container, false);
    }

}
