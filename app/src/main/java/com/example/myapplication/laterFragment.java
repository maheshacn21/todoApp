package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;


public class laterFragment extends Fragment implements Serializable {


    public laterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_later, container, false);
//        Bundle bundle=getArguments();
//        String s=bundle.getString("key");

//            System.out.println(s);


        return view;
    }
}