package com.shane.mathack.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.shane.mathack.R;

public class LearnFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("LEARN", "Learn fragment was created");
        return inflater.inflate(R.layout.fragment_learn, container, false);
    }
}
