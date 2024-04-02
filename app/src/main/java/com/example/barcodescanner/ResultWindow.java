package com.example.barcodescanner;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class ResultWindow extends AppCompatActivity {
    EditText scan_output ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_window);


        String result_code = getIntent().getStringExtra("");

        scan_output = findViewById(R.id.scan_output);

        if (scan_output != null) {
            scan_output.setText(result_code);
        }
    }


}