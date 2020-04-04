package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String text="Question: " + Integer.toString(UserData.getInstance().getQuestion());
        TextView textView = findViewById(R.id.textQuestion);
        textView.setText(text);

        text="";
        if(message.equals("true"))
        {
            text="You are wrong\n";
        }
        else
        {
            UserData.getInstance().increaseScore();
            text="You are right\n";
        }


        text += "You can catch COVID-19, no matter how sunny or hot the weather is. Countries with hot weather have reported cases of COVID-19." +
        "To protect yourself make sure you clean your hands frequently and thoroughly and avoid touching your eyes, mouth and nose. \n\n";

        text+="Sources:\n";
        text+="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/myth-busters \n";

        // Capture the layout's TextView and set the string as its text
        textView = findViewById(R.id.textExplain);
        textView.setText(text);

        text="Score: " + Integer.toString(UserData.getInstance().getScore());
        textView = findViewById(R.id.textScore);
        textView.setText(text);


    }
    /** Called when the user taps the Send button */
    public void nextQuestion(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        String message = "next";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void finish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "finish";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
