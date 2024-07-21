package com.example.duet_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private Button open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        open = findViewById(R.id.buttonCreateAccount);

        // Handle Login Button Click (replace with your login logic)
        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Replace with your actual validation and login logic
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulate successful login
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // Move to next activity or handle success
                }
                Intent intent = new Intent(MainActivity.this, home_page.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonCreateAccount).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chat.class);
                startActivity(intent);
            }


        });


    }
}