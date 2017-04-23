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
public class TuChongFragment extends Fragment {

    public static TuChongFragment newInstance(){
        TuChongFragment fragmentCommon=new TuChongFragment();
        Bundle bundle=new Bundle();
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    public TuChongFragment() {




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_douban, container, false);
    }

}
