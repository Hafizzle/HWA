package com.hafizzle.huntwiseapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hafizzle.huntwiseapp.R;

public class BlacktailDeerFragment extends Fragment {
    View view;
    public BlacktailDeerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.blacktail_deer_fragment, container, false);
        return view;
    }
}
