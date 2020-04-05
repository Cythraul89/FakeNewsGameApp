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

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(message.equals("start")) {
            UserData.getInstance().loadUserData(this.getApplicationContext());
        }

        //write score to screen
        String text="Score: " + Integer.toString(UserData.getInstance().getScore());
        TextView textView = findViewById(R.id.textScore);
        textView.setText(text);
    }

    /** Called when the user taps the Send button */
    public void startPlay(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        //String message = "test";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void showStatus(View view) {
        Intent intent = new Intent(this, StatusActivity.class);
        //String message = "test";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void showSubmit(View view) {
        Intent intent = new Intent(this, SubmitActivity.class);
        //String message = "test";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void showSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        //String message = "test";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void showLinks(View view) {
        Intent intent = new Intent(this, LinksActivity.class);
        //String message = "test";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
