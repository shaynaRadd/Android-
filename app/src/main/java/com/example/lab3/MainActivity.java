package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "MainActivity";
    private Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        button = findViewById(R.id.buttonLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("Email", email);
                startActivity(intent);
            }
        });

        SharedPreferences prefs = getSharedPreferences("activity_profile", Context.MODE_PRIVATE);
        String previous = prefs.getString("Email", "");
        editText.setText(previous);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(ACTIVITY_NAME, "IN ONPAUSE");
        SharedPreferences prefs = getSharedPreferences("profile_activity", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("Email", editText.getText().toString());
        edit.commit();

        }

    }



