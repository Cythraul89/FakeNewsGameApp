package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class LinksActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        String text="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters\n";
        text+="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters\n";
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textLink);
        textView.setText(text);
        Linkify.addLinks(textView, Linkify.ALL);
    }

    /** Called when the user taps the Send button */
    public void finish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "finish";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
