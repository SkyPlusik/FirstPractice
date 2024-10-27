package com.example.sasha;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OtherActivity extends AppCompatActivity {
    private EditText editText;
    private TextView mainText;
    private Button backButton;
    private String name = "";
    private String greeting = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent data = getIntent();
        greeting = data.getStringExtra("greeting");

        mainText = findViewById(R.id.mainTextOther);
        mainText.setText(greeting + ", ");

        editText = findViewById(R.id.editTextOther);
        editText.setSelectAllOnFocus(true);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = String.valueOf(editText.getText());
                Intent result = new Intent();
                result.putExtra("name", name);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}