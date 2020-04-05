package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get message
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(message.equals("start")) {
            // load user data only on startup
            UserData.getInstance().loadUserData(this.getApplicationContext());
        }

        // write score to screen
        String text="Score: " + Integer.toString(UserData.getInstance().getScore());
        TextView textView = findViewById(R.id.textScore);
        textView.setText(text);
    }

    /** Called when the user taps the Play */
    public void startPlay(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Status */
    public void showStatus(View view) {
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Submit button */
    public void showSubmit(View view) {
        Intent intent = new Intent(this, SubmitActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Settings button */
    public void showSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Links button */
    public void showLinks(View view) {
        Intent intent = new Intent(this, LinksActivity.class);
        startActivity(intent);
    }


}
