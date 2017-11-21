package com.example.android.lifecycles.step5;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.codelabs.lifecycle.R;

/**
 * Created by Navjot on 11/21/2017.
 */

public class Fragment2 extends Fragment
{
    SeekBarViewModel seekBarViewModel;
    TextView seekValue;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.textvalue,container,false);
        seekValue = root.findViewById(R.id.seekBarValue);
       // return super.onCreateView(inflater, container, savedInstanceState);
        //seekBarViewModel = ViewModelProviders.of(getActivity()).get(SeekBarViewModel.class);
        seekBarViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(SeekBarViewModel.class);
        seekBarViewModel.seekbarValue.observe((LifecycleOwner) getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                seekValue.setText("Updated value from model is "+integer);
            }
        });
        return  root;
    }


}
