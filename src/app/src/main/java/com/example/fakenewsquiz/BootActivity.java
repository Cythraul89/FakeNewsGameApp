package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BootActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);
    }

    /** Called when the user taps the start button*/
    public void start(View view) {
        // transmits some information to a new activity and starts them
        Intent intent = new Intent(this, MainActivity.class);
        String message = "start";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
