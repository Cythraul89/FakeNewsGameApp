package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        String text=UserData.getInstance().getName();
        EditText edit = findViewById(R.id.editName);
        edit.setText(text);

        text=Integer.toString(UserData.getInstance().getAge());
        edit = findViewById(R.id.editAge);
        edit.setText(text);

    }

    /** Called when the user taps the Send button */
    public void finish(View view) {

        String text="";
        EditText edit = findViewById(R.id.editName);
        text=edit.getText().toString();
        UserData.getInstance().setName(text);

        text=Integer.toString(UserData.getInstance().getAge());
        edit = findViewById(R.id.editAge);
        text=edit.getText().toString();
        UserData.getInstance().setAge(Integer.decode(text));

        UserData.getInstance().storeUserData();

        Intent intent = new Intent(this, MainActivity.class);
        String message = "finish";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
