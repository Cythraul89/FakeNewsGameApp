package com.example.fakenewsquiz;

public class UserData {

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
}
