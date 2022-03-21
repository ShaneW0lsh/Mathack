package com.shane.mathack.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shane.mathack.R;
import com.shane.mathack.activities.TaskSessionActivity;

public class PlayFragment extends Fragment {

    FloatingActionButton mStartFab;
    EditText mDepthEditText, mConstrEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initViews();
        manageListeners();
    }

    private void initViews() {
        mStartFab = (FloatingActionButton) getView().findViewById(R.id.extended_fab_start);
        mDepthEditText = (EditText) getView().findViewById(R.id.depthEditText);
        mConstrEditText = (EditText) getView().findViewById(R.id.consrEditText);
    }

    private void manageListeners() {
        mStartFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String depthStr = mDepthEditText.getText().toString(),
                        constraintStr = mConstrEditText.getText().toString();
                Intent intent = TaskSessionActivity.newIntent(getActivity(), depthStr, constraintStr);
                startActivity(intent);

                // For the other new intent get an array of all activated operators using checkboxes
            }
        });
    }
}
