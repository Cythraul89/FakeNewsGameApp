package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Question question=QuestionDataBase.getInstance().getQuestion(UserData.getInstance().getQuestion());

        String text="Question: " + Integer.toString(UserData.getInstance().getQuestion());
        TextView textView = findViewById(R.id.textQuestion);
        textView.setText(text);

        ImageView mImageGood = (ImageView) findViewById(R.id.imageGood);
        ImageView mImageBad = (ImageView) findViewById(R.id.imageBad);

        text="";
        if(message.equals(question.getSolution()))
        {
            UserData.getInstance().increaseScore();
            mImageGood.setVisibility(View.VISIBLE);
            mImageBad.setVisibility(View.INVISIBLE);
            text="You are right\n";
        }
        else
        {
            mImageGood.setVisibility(View.INVISIBLE);
            mImageBad.setVisibility(View.VISIBLE);
            text="You are wrong\n";
        }


        text += question.getAnswer()+"\n\n";

        text+="Do you want to know more?\n";
        text+= question.getSource()+"\n";

        // Capture the layout's TextView and set the string as its text
        textView = findViewById(R.id.textExplain);
        textView.setText(text);
        Linkify.addLinks(textView, Linkify.ALL);

        text="Score: " + Integer.toString(UserData.getInstance().getScore());
        textView = findViewById(R.id.textScore);
        textView.setText(text);


        UserData.getInstance().storeUserData(this.getApplicationContext());

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
