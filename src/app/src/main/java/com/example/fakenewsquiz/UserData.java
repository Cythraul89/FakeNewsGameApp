package com.example.fakenewsquiz;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.AsynchronousFileChannel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.widget.TextView;

public class UserData {

    static private String filename ="config.xml";
    // Eine (versteckte) Klassenvariable vom Typ der eigenen Klasse
    private static UserData instance;
    private int m_score=0;
    private int m_question=0;
    private int m_age=48;
    private String m_name="Darth Vader";



    public int getAge() {
        return m_age;
    }

    public void setAge(int m_age) {
        this.m_age = m_age;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }


    public int getScore() {
        return m_score;
    }

    public void setScore(int m_score) {
        this.m_score = m_score;
    }

    public int getQuestion() {
        return m_question;
    }

    public void setQuestion(int m_question) {
        this.m_question = m_question;
    }

    // Verhindere die Erzeugung des Objektes über andere Methoden
    private UserData () {}
    // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes
    // Objekt erzeugt und dieses zurückliefert.
    public static UserData getInstance () {
        if (UserData.instance == null) {
            UserData.instance = new UserData ();
        }
        return UserData.instance;
    }

    public void increaseScore()
    {
        m_score++;
    }

    public void increaseQuestion()
    {
        m_question++;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public void loadUserData(Context context)
    {
        try {
            final File initialFile = new File(context.getDataDir(),filename);
            final InputStream targetStream =
                    new DataInputStream(new FileInputStream(initialFile));

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(targetStream);

            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc. getElementsByTagName("user");

            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    m_score=Integer.decode(getValue("m_score", element2));
                    m_question=Integer.decode(getValue("m_question", element2)) ;
                    m_age=Integer.decode(getValue("m_age", element2));
                    m_name=getValue("m_name", element2) ;
                }
            }
        }catch(Exception ex)
        {
            Log.e("Exception: ",ex.toString());
        }

    }



    public void storeUserData(Context context)
    {

        File newxmlfile = new File(context.getDataDir(),filename);

        try{
            newxmlfile.createNewFile();
        }catch(IOException e)
        {
            Log.e("IOException: ",e.toString());
        }

        FileOutputStream fileos = null;
        try{
            fileos = new FileOutputStream(newxmlfile);

        }catch(FileNotFoundException e)
        {
            Log.e("FileNotFoundException: ",e.toString());
            return;
        }

        XmlSerializer serializer = Xml.newSerializer();
        try{
            serializer.setOutput(fileos, "UTF-8");
            serializer.startDocument(null, Boolean.valueOf(true));
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            serializer.startTag(null, "user");

            serializer.startTag(null, "m_score");
            serializer.text(Integer.toString(m_score));
            serializer.endTag(null, "m_score");

            serializer.startTag(null, "m_question");
            serializer.text(Integer.toString(m_question));
            serializer.endTag(null, "m_question");

            serializer.startTag(null, "m_age");
            serializer.text(Integer.toString(m_age));
            serializer.endTag(null, "m_age");

            serializer.startTag(null, "m_name");
            serializer.text(m_name);
            serializer.endTag(null, "m_name");

            serializer.endTag(null,"user");
            serializer.endDocument();
            serializer.flush();
            fileos.close();

        }catch(Exception e)
        {
            Log.e("Exception: ",e.toString());

        }

    }
}
