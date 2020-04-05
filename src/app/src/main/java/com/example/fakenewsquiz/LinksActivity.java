package com.example.fakenewsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LinksActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    List<String> m_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        String text="";
        loadList();

        for (int i = 0; i < m_list.size(); i++)
        {
            text += m_list.get(i);
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textLink);
        textView.setText(text);
        Linkify.addLinks(textView, Linkify.ALL);
    }

    /** Called when the user taps the back button */
    public void finish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "back";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** loads the links from the links.xml file */
    private void loadList()
    {
        m_list= new ArrayList<String>();

        boolean inTag=false;
        try{
            XmlPullParser xpp=getResources().getXml(R.xml.links);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType()==XmlPullParser.START_TAG) {
                    inTag=true;
                }
                else if(xpp.getEventType()==XmlPullParser.TEXT)
                {
                    if (inTag == true) {
                        m_list.add(xpp.getText() +"\n \n");
                    }
                }
                else if(xpp.getEventType()==XmlPullParser.END_TAG)
                {
                    inTag=false;
                }
                xpp.next();
            }

        }
        catch(Exception ex)
        {
            Log.e("Exception: ",ex.toString());
        }
    }
}
