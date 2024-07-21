package com.example.duet_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class regestration_page extends AppCompatActivity {
    EditText editTextName, editTextDOB;
    RadioGroup radioGroupGender;
    Button buttonSubmit;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize views
//        editTextName = findViewById(R.id.editTextName);
//        editTextDOB = findViewById(R.id.editTextDOB);
//        radioGroupGender = findViewById(R.id.radioGroupGender);
//        buttonSubmit = findViewById(R.id.buttonSubmit);
//        textViewResult = findViewById(R.id.textViewResult);

        // Button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String name = editTextName.getText().toString();
                String dob = editTextDOB.getText().toString();
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                String gender = selectedGenderRadioButton.getText().toString();

                // Validate inputs
                if (name.isEmpty() || dob.isEmpty()) {
                    textViewResult.setText("Please fill in all fields.");
                } else {
                    // Get current date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = sdf.format(new Date());

                    // Calculate age
                    String[] dobParts = dob.split("-");
                    int year = Integer.parseInt(dobParts[0]);
                    int currentYear = Integer.parseInt(currentDate.substring(0, 4));
                    int age = currentYear - year;

                    // Display result
                    String result = "Name: " + name + "\nDOB: " + dob + "\nGender: " + gender + "\nAge: " + age;
                    textViewResult.setText(result);
                }
            }
        });
    }
}