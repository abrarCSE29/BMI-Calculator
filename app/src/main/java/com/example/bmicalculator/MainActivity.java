package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput, feetInput, inchInput;
    private TextView bmiResult;
    private Button calculateButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        feetInput = findViewById(R.id.feetInput);
        inchInput = findViewById(R.id.inchInput);
        bmiResult = findViewById(R.id.bmiResult);
        calculateButton = findViewById(R.id.calculateButton);
        resetButton = findViewById(R.id.resetButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void calculateBMI() {

        String weightStr = weightInput.getText().toString();
        String feetStr = feetInput.getText().toString();
        String inchStr = inchInput.getText().toString();

        if (!weightStr.isEmpty() && !feetStr.isEmpty() && !inchStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float feet = Float.parseFloat(feetStr);
            float inches = Float.parseFloat(inchStr);
            float totalHeightInMeters = ((feet * 12) + inches) * 0.0254f;
            float bmi = weight / (totalHeightInMeters * totalHeightInMeters);

            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                bmiCategory = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                bmiCategory = "Overweight";
            } else {
                bmiCategory = "Obese";
            }

            bmiResult.setText("BMI: " + bmi + "\nCategory: " + bmiCategory);
        } else {
            bmiResult.setText("Please enter all values.");
        }
    }

    private void resetFields() {
        weightInput.setText("");
        feetInput.setText("");
        inchInput.setText("");
        bmiResult.setText("Your BMI will be shown here.");
    }
}
