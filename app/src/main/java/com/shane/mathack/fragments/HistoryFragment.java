package com.shane.mathack.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shane.mathack.R;

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("HISTORY", "History was created");
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        System.out.println("toolbar was created!");
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
}
