package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private Spinner spinner;
    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        spinner = v.findViewById(R.id.spinnerPhoneType);
        radioGroup = v.findViewById(R.id.radioGroupBrands);
        Button btnOk = v.findViewById(R.id.buttonOk);

        String[] options = {"Смартфон", "Кнопковий телефон", "Планшет"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, options);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        btnOk.setOnClickListener(view -> {
            int id = radioGroup.getCheckedRadioButtonId();
            if (id == -1) {
                Toast.makeText(getActivity(), "Помилка. Зробіть вибір.", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton rb = v.findViewById(id);
                String result = spinner.getSelectedItem().toString() + " фірми " + rb.getText();
                ((MainActivity) getActivity()).sendDataToResult(result);
            }
        });

        return v;
    }

    public void clearForm() {
        if (spinner != null) spinner.setSelection(0);
        if (radioGroup != null) radioGroup.clearCheck();
    }
}