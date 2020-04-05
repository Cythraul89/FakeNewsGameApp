package com.example.fakenewsquiz;

public class Question
{
    private int m_id = 0;
    private String m_question ="";
    private String m_answer ="";
    private String m_solution ="";
    private String m_source ="";

    public int getId() {
        return m_id;
    }

    public String getQuestion() {
        return m_question;
    }

    public String getAnswer() {
        return m_answer;
    }

    public String getSolution() {
        return m_solution;
    }

    public String getSource() {
        return m_source;
    }

    public Question(int id, String question, String answer, String source, String solution)
    {
        m_id = id;
        m_question = question;
        m_answer = answer;
        m_source = source;
        m_solution = solution;
    }

    private Question(){};
}
