package com.example.testingproject2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Calculator calculator;
    private EditText passwordInput;
    private Button validateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        passwordInput = findViewById(R.id.passwordInput);
        validateButton = findViewById(R.id.validateButton);
        resultText = findViewById(R.id.resultText);

        validateButton.setOnClickListener(v -> {
            String password = passwordInput.getText().toString();
            String result = calculator.validatePassword(password);
            resultText.setText(result);
        });
    }
}
