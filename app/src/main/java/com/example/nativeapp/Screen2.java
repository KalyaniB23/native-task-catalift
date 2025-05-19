package com.example.nativeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Screen2 extends AppCompatActivity {

    private Button backButton2;

    private final int[] chipIds = {
            R.id.chip1, R.id.chip2, R.id.chip3, R.id.chip4, R.id.chip5,
            R.id.chip6, R.id.chip7, R.id.chip8, R.id.chip9, R.id.chip10,
            R.id.chip11, R.id.chip12, R.id.chip13, R.id.chip14, R.id.chip15
    };

    private final List<String> selectedChips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen2);


        backButton2 = findViewById(R.id.backButton2);

        setupChipButtons();
    }

    private void setupChipButtons() {
        for (int chipId : chipIds) {
            Button chip = findViewById(chipId);

            chip.setSelected(false);
            chip.setBackgroundResource(R.drawable.chip_unselected_background);
            chip.setTextColor(getResources().getColor(R.color.dark_blue));

            chip.setOnClickListener(v -> {
                Button clickedChip = (Button) v;
                boolean isSelected = !clickedChip.isSelected();
                clickedChip.setSelected(isSelected);

                String chipText = clickedChip.getText().toString();

                if (isSelected) {
                    if (!selectedChips.contains(chipText)) {
                        selectedChips.add(chipText);
                    }
                    clickedChip.setTextColor(getResources().getColor(android.R.color.white));
                    clickedChip.setBackgroundResource(R.drawable.chip_selected_background);
                } else {
                    selectedChips.remove(chipText);
                    clickedChip.setTextColor(getResources().getColor(R.color.dark_blue));
                    clickedChip.setBackgroundResource(R.drawable.chip_unselected_background);
                }

                Log.d("SelectedChips", selectedChips.toString());
            });
        }
    }

//    private void setupButtonListeners() {
//        backButton2.setOnClickListener(v -> {
//            Intent intent = new Intent(Screen2.this, MainActivity.class);
//            startActivity(intent);
//        });
//
//    }
}
