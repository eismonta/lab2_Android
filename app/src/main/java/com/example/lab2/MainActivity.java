package com.example.lab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendDataToResult(String message) {
        ResultFragment resultFrag = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.container_result);
        if (resultFrag != null) {
            resultFrag.updateText(message);
        }
    }
    public void resetApp() {
        InputFragment inputFrag = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.container_input);
        ResultFragment resultFrag = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.container_result);

        if (inputFrag != null) inputFrag.clearForm();
        if (resultFrag != null) resultFrag.updateText("Очікування даних");
    }
}