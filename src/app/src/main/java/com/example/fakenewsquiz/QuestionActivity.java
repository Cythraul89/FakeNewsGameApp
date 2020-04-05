package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // get new question
        UserData.getInstance().increaseQuestion();
        Question question=QuestionDataBase.getInstance().getQuestion(UserData.getInstance().getQuestion());

        // print score
        String text="Score: " + Integer.toString(UserData.getInstance().getScore());
        TextView textView = findViewById(R.id.textScore);
        textView.setText(text);

        // print question number
        text="Question: " + Integer.toString(UserData.getInstance().getQuestion());
        textView = findViewById(R.id.textQuestion);
        textView.setText(text);

        // print question text
        text=question.getQuestion()+"\n";
        // Capture the layout's TextView and set the string as its text
        textView = findViewById(R.id.textDescription);
        textView.setText(text);
    }

    /** Called when the user taps the True button */
    public void trueAnswer(View view) {
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = "true";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the False button */
    public void falseAnswer(View view) {
        Intent intent = new Intent(this, AnswerActivity.class);
        String message = "false";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
