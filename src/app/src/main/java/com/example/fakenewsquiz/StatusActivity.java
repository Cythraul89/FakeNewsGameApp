package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StatusActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
    }
    /** Called when the user taps the Send button */
    public void finish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "finish";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
