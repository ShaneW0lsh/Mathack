package com.shane.mathack.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.shane.mathack.R;
import com.shane.mathack.activities.TaskSessionActivity;

public class PlayFragment extends Fragment {

    Button mStartButton;
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
        mStartButton = (Button) getView().findViewById(R.id.start_button);
    }

    private void manageListeners() {
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TaskSessionActivity.class);
                startActivity(intent);
            }
        });
    }
}
