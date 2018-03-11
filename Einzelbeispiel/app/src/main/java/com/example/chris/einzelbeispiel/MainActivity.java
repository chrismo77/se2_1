package com.example.chris.einzelbeispiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private TextView txtResult;
    private Button btnCheckInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (EditText) findViewById(R.id.inputString);
        txtResult = (TextView) findViewById(R.id.outputString);
        btnCheckInput = (Button) findViewById(R.id.checkButton);

        btnCheckInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkString();
            }
        });
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }

    public void checkString() {

        String enteredText = txtInput.getText().toString();

        if (txtInput.length() < 5) {
            txtResult.setText("Enter at least 5 characters!");
            return;
        } else if (enteredText.contains(" ")) {
            txtResult.setText("No spaces allowed!");
            return;
        }

        if (isPalindrome(enteredText)) {
            txtResult.setText("Entered string is a palindrome.");
        } else {
            txtResult.setText("Entered string is NOT a palindrome.");
        }

    }

}
