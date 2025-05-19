package com.example.nativeapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner educationLevelSpinner, institutionSpinner;
    private EditText pastRolesEditText;
    private TextView wordCountText;
    private Button continueButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        educationLevelSpinner = findViewById(R.id.educationLevelSpinner);
        institutionSpinner = findViewById(R.id.institutionSpinner);
        pastRolesEditText = findViewById(R.id.pastRolesEditText);
        wordCountText = findViewById(R.id.wordCountText);
        continueButton = findViewById(R.id.continueButton);
        backButton = findViewById(R.id.backButton);

        setupSpinners();
        setupEditTextWatcher();
        setupButtonListeners();
    }

    private void setupSpinners() {

        ArrayList<String> educationLevels = new ArrayList<>();
        educationLevels.add("Select Education Level");
        educationLevels.add("High School");
        educationLevels.add("Bachelor's Degree");
        educationLevels.add("Master's Degree");
        educationLevels.add("PhD");

        ArrayList<String> institutions = new ArrayList<>();

        institutions.add("Select Institution");
        institutions.add("Vellore Institute of Technology");
        institutions.add("IIT Bombay");
        institutions.add("IIIT Hyderabad");


        ArrayAdapter<String> educationAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, educationLevels);
        educationLevelSpinner.setAdapter(educationAdapter);

        ArrayAdapter<String> institutionAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, institutions);
        institutionSpinner.setAdapter(institutionAdapter);
    }

    private void setupEditTextWatcher() {
        pastRolesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int wordCount = s.toString().trim().split("\\s+").length;
                if (s.toString().trim().isEmpty()) wordCount = 0;

                wordCountText.setText(wordCount + "/100 words typed");
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }


    private void setupButtonListeners() {
        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Screen2.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> {
            Toast.makeText(this, "Back pressed", Toast.LENGTH_SHORT).show();
        });
    }
}
