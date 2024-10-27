package com.example.sasha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView mainText;
    private Button forwardButton;
    private static final int SHOW_OTHER_ACTIVITY = 1;
    private String name = "";
    private String greeting = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.setSelectAllOnFocus(true);

        mainText = findViewById(R.id.mainText);

        forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greeting = String.valueOf(editText.getText());
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                intent.putExtra("greeting", greeting);
                startActivityForResult(intent, SHOW_OTHER_ACTIVITY);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (SHOW_OTHER_ACTIVITY):
                if (resultCode == Activity.RESULT_OK) {
                    name = data.getStringExtra("name");
                    mainText.setText(greeting + ", " + name + "!");
                }
        }
    }
}