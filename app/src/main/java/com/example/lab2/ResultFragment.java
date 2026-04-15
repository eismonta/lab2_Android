package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_result, container, false);

        tvResult = v.findViewById(R.id.textResultFragment);
        Button btnCancel = v.findViewById(R.id.buttonCancel);

        btnCancel.setOnClickListener(view -> {
            ((MainActivity) getActivity()).resetApp();
        });

        return v;
    }

    public void updateText(String newText) {
        if (tvResult != null) {
            tvResult.setText(newText);
        }
    }
}