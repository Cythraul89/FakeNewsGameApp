package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StatusActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.imageTrophie3);

        if(UserData.getInstance().getScore()<2)
        {
            mImageView.setVisibility(View.INVISIBLE);
        }
        else
        {
            mImageView.setVisibility(View.VISIBLE);
        }
    }
    /** Called when the user taps the Send button */
    public void finish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "back";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
