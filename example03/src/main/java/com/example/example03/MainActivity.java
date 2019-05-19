package com.example.example03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private Button buttonSubmit;
    private TextView textViewUserName;
    private EditText editTextNameChange;
    //textViewNameChange local variable,unable to be override
    private TextView textViewNamechange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example03);
        editTextUserName = findViewById(R.id.act_main_editText_userName);
        buttonSubmit = findViewById(R.id.act_main_button_submit);
        textViewUserName = findViewById(R.id.act_main_textView_userName);
        editTextNameChange = findViewById(R.id.act_main_editText_change);
        textViewNamechange = findViewById(R.id.act_main_textView_change);

        buttonSubmit.setOnClickListener((v) -> {
            String string = editTextUserName.getText().toString();
            textViewUserName.setText(string);
        });

        editTextNameChange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewNamechange.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
